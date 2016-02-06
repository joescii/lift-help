package code.snippet

import net.liftweb.http.SHtml
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.util.Helpers._

class Count {
  def render = "button [onclick]" #> SHtml.ajaxCall(JsRaw("window.count++"), count => println(count))
}
