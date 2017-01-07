package controllers

import javax.inject.Inject

import akka.actor.ActorSystem
import akka.pattern.ask
import akka.util.Timeout
import models.HelloActor
import models.HelloActor.SayHello
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc._
import shared.SharedMessages

import scala.concurrent.duration._


/**
  * @author kasonchan
  * @since Jan-2017
  */
class Application @Inject()(implicit webJarAssets: WebJarAssets, val messagesApi: MessagesApi, system: ActorSystem)
  extends Controller with I18nSupport {

  val helloActor = system.actorOf(HelloActor.props, "hello-actor")

  implicit val timeout: Timeout = 5.seconds

  def index = Action.async {
    helloActor ! "Hello from Qwerty"
    (helloActor ? SayHello("Qwerty")).mapTo[String].map { message =>
      Ok(views.html.index(s"${Messages("application.name")} ${SharedMessages.itWorks} $message"))
    }
  }

}
