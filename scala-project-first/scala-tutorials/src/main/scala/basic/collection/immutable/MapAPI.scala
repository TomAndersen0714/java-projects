package basic.collection.immutable

/**
 * @author TomAndersen
 * @see [[scala.collection.immutable.Map]]
 */
object MapAPI {
  def main(args: Array[String]): Unit = {
    // scala.collection.immutable.Map
    val map = Map(1 -> "one", 2 -> "two", 3 -> "three")
    map.foreach {
      case (k, v) => println(s"key = ${k}, value = ${v}")
    }

  }
}
