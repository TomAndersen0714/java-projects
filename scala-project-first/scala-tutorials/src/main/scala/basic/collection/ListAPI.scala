package basic.collection

/**
 * @author TomAndersen
 */
object ListAPI {
  def main(args: Array[String]): Unit = {
    val numsList: List[Int] = List(1, 2, 3, 4)

    // scala.collection.immutable.List.take
    println(s"numsList.take(3) = ${numsList.take(3)}")
  }
}
