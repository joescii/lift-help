package code.rest

import net.liftweb.http.LiftRules.SplitSuffixPF
import net.liftweb.http.PlainTextResponse
import net.liftweb.http.rest.RestHelper

object RestApi extends RestHelper {
  serve {
    case "test" :: filename :: Nil Get _ =>
      PlainTextResponse(s"filename is $filename", 200)
  }

  val splitter:SplitSuffixPF = {
    case parts => // <= Parts is a List[String] of each part between slashes
      // Since you want the entire filename without the suffix split, there is nothing to do
      // but return the parts and an empty suffix
      (parts, "")
  }
}
