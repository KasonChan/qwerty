package javascript

import shared.SharedMessages

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import scala.scalajs.js.annotation.JSExport

@JSExport
object MainJS extends js.JSApp {

  def main(): Unit = {
    g.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
  }

  @JSExport
  def helloWorld(): Unit = {
    println("Hello world!")
  }

}