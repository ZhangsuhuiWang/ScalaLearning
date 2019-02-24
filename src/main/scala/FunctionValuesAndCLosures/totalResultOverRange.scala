def totalResultOverRange(bounder: Int, codeBlock: Int => Int) = {
  var result = 0
  for(i <- 1 to bounder) {
    result += codeBlock(i)
  }
  result
}

println(totalResultOverRange(11, i => i))
println(totalResultOverRange(11, i =>  if (i%2 == 0) i else 0))