package basic.concept.variable

/**
 * @author TomAndersen
 * @see [[scala.Tuple1]]
 * @see [[https://docs.scala-lang.org/overviews/scala-book/tuples.html]]
 */
object TupleAPI {
  def main(args: Array[String]): Unit = {

    // construct
    val tuple: (Int, Int, Int) = Tuple3(1, 2, 3)
    val tuple1: (Int, Int) = 1 -> 2

    // read
    println(s"tuple1 = ${tuple1}")
    println(s"tuple._1 = ${tuple._1}")
    println(s"tuple._2 = ${tuple._2}")
    println(s"tuple._3 = ${tuple._3}")

  }
}
