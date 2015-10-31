package code.snippet

import net.liftweb.http.S
import net.liftweb.util.Helpers._

object Stateful {
  def render = "#stateful *" #> S.session.map(_.stateful_?)
}
