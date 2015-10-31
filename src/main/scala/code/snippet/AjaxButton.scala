package code.snippet

import net.liftweb.http.SHtml
import net.liftweb.http.js.JE.JsVar
import net.liftweb.http.js.JsCmds
import net.liftweb.util.Helpers._

object AjaxButton {
  def render = "type=button [onclick]" #> SHtml.ajaxCall(JsVar("window.blah"), (blah) => {println(blah); JsCmds.Noop})
}
