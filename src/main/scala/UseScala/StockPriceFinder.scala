object StockPriceFinder {
  import scala.io.Source

  case class Record(year: Int, month: Int, Date: Int, closePrice: BigDecimal)

  def getLastestClosingPrice(symbol: String): BigDecimal = {
    val url = s"https://raw.githubusercontent.com/ReactivePlatform/" +
      s"Pragmatic-Scala-StaticResources/master/src/main/resources/" +
      s"stocks/daily/daily_$symbol.csv"

    val data = Source.fromURL(url).mkString
    val lastestClosePrize = data.split("\n")
      .slice(1, 2)
      .map(record => {
        val Array(timestamp, open, high, low, close, volume) = record.split(",")
        val Array(year, month, data) = timestamp.split("-")
        Record(year.toInt, month.toInt, data.toInt, BigDecimal(close.trim))
      })
      .map(_.closePrice)
      .head
    lastestClosePrize
  }

  def getTickersAndUnits: Map[String, Int] = {
    val classLoader = this.getClass.getClassLoader
    val stocksXMLInputStream = classLoader.getResourceAsStream("stocks.xml")
    val stocksAndUnitsXML = scala.xml.XML.load(stocksXMLInputStream)
    (Map[String, Int]() /: (stocksAndUnitsXML \ "symbol")) {
      (map, symbolNode) =>
        val ticker = (symbolNode \ "@ticker").toString
        val units = (symbolNode \ "units").text.toInt
        map + (ticker -> units)
    }
  }
}

object FindTotalWorthSequential extends App {
  val symbolsAndUnits = StockPriceFinder.getTickersAndUnits

  println("Ticker Units Closing Price($) Total Value($)")

  val startTime = System.nanoTime()
  val valuesAndWorth = symbolsAndUnits.keys.par.map{ symbol =>
    val units = symbolsAndUnits(symbol)
    val latestClosingPrice = StockPriceFinder getLastestClosingPrice(symbol)
    val value = units * latestClosingPrice
    (symbol, units, latestClosingPrice, value)
  }

  val netWorth = (BigDecimal(0.0) /: valuesAndWorth) { (worth, valueAndWorth) =>
    val (_, _, _, value) = valueAndWorth
    (worth) + value
  }
  val endTime = System.nanoTime()

  valuesAndWorth.toList.sortBy(_._1).foreach { valueAndWorth ⇒
    val (symbol, units, latestClosingPrice, value) = valueAndWorth
    println(f"$symbol%7s  $units%5d  $latestClosingPrice%15.2f  $value%.2f")
  }

  println(f"The total value of your investment is $$$netWorth%.2f")
  println(f"Took ${(endTime - startTime) / 1e9}.2f seconds")
}
