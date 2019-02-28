object Tax {
  def taxFor(amount: Double): Double = {
    if(amount < 0)
      throw new IllegalArgumentException("Amount must be greater than zero")
    if(amount < 0.01)
      throw new RuntimeException("Amount too small to be taxed")
    if(amount > 1000000)
      throw new Exception("Amount too larger...")

    amount * 0.08
  }
}

for(amount <- List(100.0, 0.009, -2.0, 1000001.0)) {
  try {
    print(s"Amount: $$$amount ")
    println(s"Tax: $$${Tax.taxFor(amount)} ")
  } catch {
    case ex: IllegalArgumentException => println(ex.getMessage)
    case _: Throwable => println("Something went wrong")
  }
}