for(amount <- List(100.0, 0.009, -2.0, 1000001.0)) {
  try {
    print(s"AMount: $$$amount")
    println(s"Tax: $$${Tax.taxFor(amount)}")
  } catch {
    case ex: IllegalArgumentException => println(ex.getMessage)
    case ex: RuntimeException => println(s"Don't bother reporting... ${ex.getMessage}")
  }
}

