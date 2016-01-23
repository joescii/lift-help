package code.snippet

import net.liftweb.actor.LAFuture
import net.liftweb.http.{SessionVar, SHtml}
import net.liftweb.http.LAFutureWithSession._
import net.liftweb.http.js.JE.JsVar
import net.liftweb.http.js.JsCmds
import net.liftweb.util.Helpers._

object MyVar extends SessionVar("init")

object AjaxButton {
  def render = "type=button [onclick]" #>
    SHtml.ajaxCall(
      JsVar("window.myGlobal"),
      myGlobal => {
        futureOp(myGlobal)
          .withCurrentSession
          .foreach(MyVar.set(_))
        JsCmds.Noop
      }
    )

  def futureOp(s:String):LAFuture[String] = LAFuture(() => "Back to the Future[T]: "+s)
}
