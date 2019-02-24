def compute(input: Int) =
  if(input >= 0)
    Right(math.sqrt(input))
  else
    Left("Error")



def displyaResult(result: Either[String, Double]): Unit = {
  println(s"Raw: $result")
  result match {
    case Right(value) => println(s"result: $value")
    case Left(err) => println(s"Error: $err")
  }
}

displyaResult(compute(4))
displyaResult(compute(-4))