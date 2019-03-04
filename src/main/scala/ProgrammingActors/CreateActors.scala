import akka.actor._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object CreateActors extends App {
  val system = ActorSystem("sample")
  val depp = system.actorOf(Props[HollywoodActor])

  depp ! "Wonka"

  val terminateFuture = system.terminate()
  Await.ready(terminateFuture, Duration.Inf)
}
