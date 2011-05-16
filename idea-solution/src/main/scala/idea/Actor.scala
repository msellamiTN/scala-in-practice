package idea

import scala.actors.Actor
import scala.actors.Actor._

// Sealed class
sealed abstract class Operation
// Add and Sub case class
case class Add(i: Int, y: Int) extends Operation
case class Sub(i: Int, y: Int) extends Operation

object ActorExample {

  // Actor
  val producer: Actor = actor {
    loop {
      receive {
        // Case...
        case Add(x, y) => println(x + y)
        case Sub(x, y) => println(x - y)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    // Bang it !
    producer ! Add(3, 6)
    producer ! Sub(5, 2)
  }

}
