package javascript

import com.karasiq.bootstrap.BootstrapImplicits._
import com.karasiq.bootstrap.grid.GridSystem
import com.karasiq.bootstrap.navbar.{NavigationBar, NavigationBarStyle}
import org.scalajs.dom
import org.scalajs.jquery._
import rx._
import shared.SharedMessages

import scala.language.postfixOps
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import scala.util.Try
import scalatags.JsDom.all._

/**
  * @author kasonchan
  * @since Jan-2017
  */
@JSExport
object MainJS extends js.JSApp {
  private implicit val context = implicitly[Ctx.Owner]

  def main(): Unit = {

    Try {
      dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    }

    Try {
      jQuery(() => {
        val navigationBar = NavigationBar()
          .withBrand("Qwerty", href := "")
          .withTabs(
          )
          .withContentContainer(content => GridSystem.container(id := "main-container", GridSystem.mkRow(content)))
          .withStyles(NavigationBarStyle.inverse, NavigationBarStyle.fixedTop)
          .build()

        // Render page
        navigationBar.applyTo(dom.document.body)
        jQuery("body").add("Test")
      })
    }

  }

}
