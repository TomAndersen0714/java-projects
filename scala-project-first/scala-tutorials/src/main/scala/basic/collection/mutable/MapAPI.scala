package basic.collection.mutable

import scala.collection.mutable
import scala.collection.mutable.Map

/**
 * @author TomAndersen
 * @see [[scala.collection.mutable.Map]]
 */
object MapAPI {
  def main(args: Array[String]): Unit = {
    // scala.collection.mutable.Map
    val map = mutable.Map(1 -> "one", 2 -> "two", 3 -> "three")
    map.foreach {
      case (k, v) => println(s"key = ${k}, value = ${v}")
    }

    // update
    map(0) = "zero"
    map.update(1, "ONE")
    println(s"map = ${map}")


  }
}
