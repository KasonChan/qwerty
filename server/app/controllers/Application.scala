package controllers

import javax.inject.Inject

import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.mvc._
import shared.SharedMessages

/**
  * @author kasonchan
  * @since Jan-2017
  */
class Application @Inject()(implicit webJarAssets: WebJarAssets, val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def index = Action {
    Ok(views.html.index(Messages("application.name") + " " + SharedMessages.itWorks))
  }

}
