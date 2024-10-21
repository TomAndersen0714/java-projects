package basic.control_structures

/**
 * @author TomAndersen
 */
object For {
  def main(args: Array[String]): Unit = {
    val numsList: List[Int] = List(1, 2, 3, 4, 5)

    // foreach statement
    println("foreach statement: ")
    for (x <- numsList) {
      println(s"x = ${x}")
    }

    // foreach method
    // scala.collection.immutable.List.foreach
    println("foreach method: ")
    numsList.foreach {
      x: Int => println(s"x = ${x}")
    }

    // 在foreach中使用模式匹配, 支持复杂类型成员提取
    val tupleList: List[(String, Int)] = List(("Tom", 1), ("John", 2), ("Alice", 3))
    tupleList.foreach {
      case (x, y) => println(s"(x,y) = (${x},${y})")
    }
  }
}
