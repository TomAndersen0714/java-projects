package basic.collection

/**
 * @author TomAndersen
 */
object ListAPI {
  def main(args: Array[String]): Unit = {
    val numsList: List[Int] = List(1, 2, 3, 4)
    val mixedList: List[Any] = List(1, "two", 3, "four", 5)

    // scala.collection.immutable.List.take
    println(s"numsList.take(3) = ${numsList.take(3)}")

    // scala.collection.immutable.List.foreach
    // foreach 方法是只读遍历, 不支持修改元素
    numsList.foreach(_ * 2)
    numsList.foreach(x => {
      print(x)
    })
    println()

    // scala.collection.immutable.List.map
    // map 方法的作用是将当前遍历当前集合中的每个元素, 并将每个元素使用方法转换后生成新的集合
    val mapList: List[(Int, String)] = numsList.map(x => Tuple2(x, x.toString))
    println(s"mapList = ${mapList}")

    // scala.collection.generic.GenericTraversableTemplate.flatten
    // flatten方法适用于自身同类型嵌套的集合类型，如 List[List[T]]、Seq[Seq[T]]、Array[Array[T]]等。
    // 它会将嵌套集合中的元素提取出来并连接成一个新的集合。
    val listOfList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))
    val flattenList: List[Int] = listOfList.flatten
    println(s"listOfList = ${listOfList}")
    println(s"flattenList = ${flattenList}")

    val listOfListOfList = List(List(List(1), List(2), 3), List(4, 5, 6))
    val flattenList1 = listOfListOfList.flatten
    println(s"listOfListOfList = ${listOfListOfList}")
    println(s"flattenList1 = ${flattenList1}")

    // scala.collection.immutable.List.flatMap
    // map 方法的作用是先遍历当前集合, 并进行转换map, 转换后再进行打平flat, 即map+flatten
    val flatMapList = numsList.flatMap {
      x => Seq(x, x.toString)
    }
    println(s"flatMapList = ${flatMapList}")
    // 使用 flatMap 搭配模式匹配, 能够拆分复杂数据结构
    val flatMapCaseList = mapList.flatMap {
      case (x, y) => Seq(x, y)
    }
    println(s"flatMapCaseList = ${flatMapCaseList}")

    // scala.collection.immutable.List.collect
    // collect 方法的功能是 filter+map 的组合
    val collectSeqList = mapList.collect {
      case (x, y) => Seq(x, y)
    }
    println(s"collectSeqList = ${collectSeqList}")

    // collect 方法可以通过模式匹配 case match 来实现 filter 功能
    val collectList: List[Any] = mixedList.collect {
      case i: Int if i < 3 => i * 2
      case j: String => j
    }
    println(s"collectList = ${collectList}")
  }
}
