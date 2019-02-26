abstract class Writer {
  def writerMessage(message: String): Unit
}

trait UpperCaseWriter extends Writer {
  abstract override def writerMessage(message: String): Unit =
    super.writerMessage(message.toUpperCase)
}

trait ProfanityFilteredWriter extends Writer {
  abstract override def writerMessage(message: String): Unit =
    super.writerMessage(message.replace("stupid", "s-----"))
}

class StringWriterDelegate extends Writer {
  val writer = new java.io.StringWriter()

  def writerMessage(message: String): Unit = writer.write(message)
  override def toString: String = writer.toString
}

val myWriterProfanityFirst =
  new StringWriterDelegate with UpperCaseWriter with ProfanityFilteredWriter

val myWriterProfanityLast =
  new StringWriterDelegate with ProfanityFilteredWriter with UpperCaseWriter

myWriterProfanityFirst writerMessage "There is no sin except stupidity"
myWriterProfanityLast writerMessage "There is no sin except stupidity"

println(myWriterProfanityFirst)
println(myWriterProfanityLast)
