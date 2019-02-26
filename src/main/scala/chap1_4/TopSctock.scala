case class Record(year: Int, month: Int, data: Int, closePrice:BigDecimal)

def getYearEndClosingPrice(symbol: String, year: Int): BigDecimal = {
  val url = s"https://raw.githubusercontent.com/ReactivePlatform/" +
          s"Pragmatic-Scala-StaticResources/master/src/main/resources/" +
          s"stocks/daily/daily_$symbol.csv"
  val data = io.Source.fromURL(url).mkString
  val maxClosePrize = data.split("\n")
    .filter(record => record.startsWith(s"$year-12"))
    .map(record => {
      val Array(timestamp, open, high, low, close, volume) = record.split(",")
      val Array(year, month, data) = timestamp.split("-")
      Record(year.toInt, month.toInt, data.toInt, BigDecimal(close.trim))
    })
    .sortBy(_.data)(Ordering[Int].reverse)
    .take(1)
    .map(_.closePrice)
    .head
  maxClosePrize
}

val symbols = List("AMD", "AAPL", "AMZN", "IBM", "ORCL", "MSFT")
val year = 2017

val (topStock, topPrice) =
  symbols.par.map{ticker => (ticker, getYearEndClosingPrice(ticker, year))}
  .maxBy(stockPrice => stockPrice._2)
printf(s"Top stock of $year is $topStock closing at price $$$topPrice")
