val result = for(i <- 1 to 3)
  yield i * 2

val result2 = (1 to 10).map(_ * 2)

val result3 = for(i <- 1 to 10; if i % 2 == 0)
  yield i * 2