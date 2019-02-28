def process(input: String): Unit = {
  val MatchStock ="""^(.+):(\d*\.\d+)""".r
  input match {
    case MatchStock("GOOG", price) => println(s"We got GOOG at $$$price")
    case MatchStock("IBM", price) => println(s"We got IBM at $$$price")
    case MatchStock(symbol, price) => println(s"Price of $symbol is $$$price")
    case _ => println(s"not processing $input")
  }
}

process("GOOG:310.84")
process("IBM:84.01")
process("GE:15.96")
