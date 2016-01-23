package code.snippet

import net.liftweb.http.{SessionVar, SHtml}
import net.liftweb.http.FutureWithSession._
import net.liftweb.http.js.JE.JsVar
import net.liftweb.http.js.JsCmds
import net.liftweb.util.Helpers._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

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

  def futureOp(s:String):Future[String] = Future("Back to the Future[T]: "+s)
}
