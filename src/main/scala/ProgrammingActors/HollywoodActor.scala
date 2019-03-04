import akka.actor._

class HollywoodActor() extends Actor {
  def receive: Receive = {
    case message => println(s"playing the role of $message")
  }
}


