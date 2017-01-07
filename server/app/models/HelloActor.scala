package models

import akka.actor.{Actor, Props}

/**
  * @authoer kasonchan
  * @since Jan-2017
  */
object HelloActor {
  def props: Props = Props[HelloActor]

  case class SayHello(name: String)

}

class HelloActor extends Actor with akka.actor.ActorLogging {

  import HelloActor._

  def receive: PartialFunction[Any, Unit] = {
    case SayHello(name: String) =>
      Thread.sleep(1000)
      log.info(s"name")
      sender() ! "Hello, " + name
    case s: String =>
      log.info(s"$s")
    case what =>
      log.warning(s"${what.toString}")
  }

}
