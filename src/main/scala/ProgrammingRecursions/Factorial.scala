def factorial(num: Int): BigInt = {
  if(num == 0)
    1
  else
    num * factorial(num - 1)
}

println(factorial(10))