package javascript

import org.scalajs.dom
import shared.SharedMessages

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

/**
  * @author kasonchan
  * @since Jan-2017
  */
@JSExport
object MainJS extends js.JSApp {

  def main(): Unit = {
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
  }

}
