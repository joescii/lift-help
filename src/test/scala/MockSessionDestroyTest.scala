import org.specs2.mutable.Specification
import net.liftweb.http.S
import net.liftweb.mockweb.MockWeb


class MockSessionDestroyTest extends Specification {
  "LiftSession" should {
    "destroy cleanly" in {
      MockWeb.testS("http://localhost:9090")(
        S.session.map(_.destroySession())
      )

      // Just to type check...
      1 must_== 1
    }
  }
}
