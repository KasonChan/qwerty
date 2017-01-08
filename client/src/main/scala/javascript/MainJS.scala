package javascript

import css.MainCSS
import org.scalajs.dom
import rx._
import shared.SharedMessages
import slogging.{ConsoleLoggerFactory, LazyLogging, LogLevel, LoggerConfig}

import scala.language.postfixOps
import scala.scalajs.js
import scala.scalajs.js.Date
import scala.scalajs.js.annotation.{JSExport, ScalaJSDefined}
import scala.util.Try
import scalacss.Defaults._
import org.scalajs.jquery.jQuery

/**
  * @author kasonchan
  * @since Jan-2017
  */
@JSExport
object MainJS extends js.JSApp with LazyLogging {
  private implicit val context = implicitly[Ctx.Owner]

  LoggerConfig.factory = ConsoleLoggerFactory()

  LoggerConfig.level = LogLevel.INFO

  def main(): Unit = {

    toStyleSheetInlineJsOps(MainCSS).addToDocument()

    Try {
      logger.info(s"${SharedMessages.itWorks}")
      dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    }

    remove()

  }

  @JSExport
  def remove(): Unit = {
    jQuery(s"#remove").on("click", () => {
      jQuery(s"#text").remove()
      jQuery(s"#remove").remove()
    })
  }

}
