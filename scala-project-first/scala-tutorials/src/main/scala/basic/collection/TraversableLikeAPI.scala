package basic.collection

/**
 * @author TomAndersen
 * @see [[scala.collection.TraversableLike]]
 */
object TraversableLikeAPI {
  def main(args: Array[String]): Unit = {

    val numsSeq: Seq[Int] = Seq(1, 2, 3, 4)
    val tupleSeq: Seq[(Int, Int)] = Seq((1, 2), (1, 3), (2, 3))

    println(s"numsSeq = ${numsSeq}")

    // scala.collection.TraversableLike.find
    // find 方法找到第一个非空, 且符合条件的元素, 并返回Option, 即可能是None, 也可能是Some
    val intOption = numsSeq.find(x => x == 3).getOrElse(5)
    println(s"intOption = ${intOption}")

    // scala.collection.TraversableLike.partition
    // partition 方法的作用是基于输入的匿名函数, 将原来的集合拆分为两个子集
    // 其中各个元素的相对顺序, 与其在原集合中的相对顺序相同
    val (numsSeqPart1, numsSeqPart2) = numsSeq.partition { x => x < 3 }
    println(s"numsSeqPart1 = ${numsSeqPart1}")
    println(s"numsSeqPart2 = ${numsSeqPart2}")

    // scala.collection.TraversableLike.groupBy
    // groupBy 方法的作用是按照元素对整个集合进行分组, 并返回对应的 Map
    val intToTuples: Map[Int, Seq[(Int, Int)]] = tupleSeq.groupBy(e => e._1)
    println(s"intToTuples = ${intToTuples}")

    // scala.collection.TraversableLike.scanLeft
    // scanLeft方法的作用是从最左边的元素开始遍历, 并计算其每次的状态值(如:累加求和), 并返回每次状态值对应的集合
    // 传入的参数是一个初始状态值, 和当前状态值的计算函数, 返回结果包含初始状态
    val ints: Seq[Int] = tupleSeq.scanLeft(1) {
      case (current, x) => current + x._1
    }
    println(s"ints = ${ints}")
  }
}
