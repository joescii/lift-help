package code.snippet

import net.liftweb.common.Full
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.{S, SHtml}
import net.liftweb.http.js.JsCmd
import net.liftweb.http.js.JsCmds._
import net.liftweb.http.provider.HTTPCookie
import net.liftweb.util.Helpers._

object CookieForm {
  def render = {
    var name: String = ""
    var value: String = ""

    def process(): JsCmd = {
      val cookie = HTTPCookie(name, value).copy(path = Full("/"))

      println(s"Adding cookie $cookie")
      S.addCookie(cookie)
      println(S.responseCookies)
      JsRaw(s"console.log('Added cookie: $name = $value')")
    }

    "name=name" #> SHtml.text(name, name = _) &
    "name=value" #> (SHtml.text(value, value = _) ++ SHtml.hidden(process))
  }
}
