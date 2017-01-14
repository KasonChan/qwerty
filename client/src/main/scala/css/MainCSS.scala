package css

import scala.language.postfixOps
import scalacss.Defaults._

/**
  * @author kasonchan
  * @since Jan-2017
  */
object MainCSS extends StyleSheet.Inline {

  import dsl._

  val common = mixin(
    backgroundColor.green
  )

  val titleDiv = style(
    common, // Applying our mixin
    margin(12 px, auto),
    textAlign.left,
    cursor.pointer
  )

}
