package basic.concept.variable

/**
 * @author TomAndersen
 * @see [[https://docs.scala-lang.org/overviews/collections-2.13/arrays.html]]
 */
object ArrayAPI {
  def main(args: Array[String]): Unit = {
    // scala.Array.apply
    val arr: Array[Int] = Array(1, 2, 3, 4, 5)
    val arr1: Array[Nothing] = new Array(10)

    // scala.Array.length
    println(s"arr.length = ${arr.length}")

    // read array
    println(s"arr(0) = ${arr(0)}")
    println(s"arr1(0) = ${arr1(0)}")

    // write array
    arr(0) = 10
    println(s"arr(0) = ${arr(0)}")

  }
}
