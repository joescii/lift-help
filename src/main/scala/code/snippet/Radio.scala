package code.snippet

import net.liftweb.common._
import net.liftweb.http.SHtml
import net.liftweb.util.Helpers._

/**
 * Created by jbarnes on 10/25/2015.
 */
object Radio {
  def render = SHtml.radioCssSel[String](Full("3"), submitHandler) (
    "#radio1" -> "1",
    "#radio2" -> "2",
    "#radio3" -> "3",
    "#radio4" -> "4"
  ) & "type=submit" #> SHtml.onSubmitUnit(submit)

  val submit:() => Unit = { () =>
    println("submitted")
  }

  val submitHandler:Box[String] => Unit = { box =>
    println("We got a box!! "+box)
  }
}
