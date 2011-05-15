import org.scalatest._
import org.scalatest.matchers._
import play._
import play.test._

class BasicTests extends UnitFlatSpec with ShouldMatchers {
    
    it should "run this dumb test" in {
        
        (1 + 1) should be (2)
        
    }

}