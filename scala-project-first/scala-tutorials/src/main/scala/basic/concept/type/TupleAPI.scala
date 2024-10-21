package basic.concept.variable

/**
 * @author TomAndersen
 * @see [[scala.Tuple1]]
 * @see [[https://docs.scala-lang.org/overviews/scala-book/tuples.html]]
 */
object TupleAPI {
  def main(args: Array[String]): Unit = {
    val tuple: (Int, Int, Int) = Tuple3(1, 2, 3)

    // read
    println(s"tuple._1 = ${tuple._1}")
    println(s"tuple._2 = ${tuple._2}")
    println(s"tuple._3 = ${tuple._3}")
  }
}
