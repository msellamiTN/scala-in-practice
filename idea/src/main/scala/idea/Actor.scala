package idea

import scala.actors.Actor
import scala.actors.Actor._

// Sealed class Operation

// Add and Sub case class


object ActorExample {

  // Actor
  val producer: Actor = actor {
    loop {
      receive {
        // Case...
        case _ => println("foo")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    // Bang it !
  }

}
