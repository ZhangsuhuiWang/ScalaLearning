def UsingEither(input: Int) {
  if(input >= 0)
    Right(math.sqrt(input))
  else
    Left("Error")
}
