import java.io._

val writer = new PrintWriter(new File("symbol.txt"))
writer write("AAPL")
writer.close()
println(scala.io.Source.fromFile("symbols.txt").mkString)