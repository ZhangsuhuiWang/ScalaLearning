import scala.collection._

class Marker private (val color: String) {
  override def toString = s"marker color $color"
}

object Marker {
  private val markers = mutable.Map(
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "yellow" -> new Marker("yellow"))

  def supportColors: Iterable[String] = markers.keys
  def apply(color: String): Marker = markers.getOrElseUpdate(color, op = new Marker(color))
}

println(s"Supoorted colors are : ${Marker.supportColors}")
print(Marker("blue"))
print(Marker("red"))

