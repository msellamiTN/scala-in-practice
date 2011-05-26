package idea;

object S99 extends Application {

  val list = List(1, 1, 2, 3, 5, 8)

  // P01 (*) Find the last element of a list.
  // Example:
  // scala> last(List(1, 1, 2, 3, 5, 8))
  // res0: Int = 8
  // To show => Warning


  // P02 (*) Find the last but one element of a list.
  // Example:
  // scala> penultimate(List(1, 1, 2, 3, 5, 8))
  // res0: Int = 5
  // To show => Unreachable code


  // P03 (*) Find the Kth element of a list.
  // By convention, the first element in the list is element 0.
  // Example:
  // scala> nth(2, List(1, 1, 2, 3, 5, 8))
  // scala> nth(1, List(1, 2, 3, 5, 8))
  // scala> nth(0, List(2, 3, 5, 8))
  // res0: Int = 2


  // P04 (*) Find the number of elements of a list.
  // Example:
  // scala> length(List(1, 1, 2, 3, 5, 8))
  // res0: Int = 6
  // To show => builtin, recursive, FP

}

