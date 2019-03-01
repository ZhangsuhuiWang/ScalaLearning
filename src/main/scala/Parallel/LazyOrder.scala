import scala.io._

def read = StdIn.readInt()

lazy val first = read
lazy val second = read

if(Math.random() < 0.5)
  second

println(first - second)