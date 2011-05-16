package idea;

/**
 * Hello world!
 */
object App extends Application {

  // Helloworld
  println( "Hello World!" );

  // List map, filter, mkString
  val list = List(1,2,3)
  println(list map {_*2})
  println(list.filter(_%2==0))
  println(list.mkString(", "))

  // Option Some, None
  var option:Option[String]  = Some("Foo");
  println(option.get)
  option = None
  println(option.getOrElse("0_o"))

  // Curry multiply, double, triple
  def multiply(x:Int)(y:Int):Int = x*y
  def double = multiply(2)(_)
  def triple = multiply(3)(_)
  println(double(3))
  println(triple(3))

}
