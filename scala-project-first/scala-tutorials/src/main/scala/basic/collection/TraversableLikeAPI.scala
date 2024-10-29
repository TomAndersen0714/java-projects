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
    // scanLeft方法的作用是从集合首个元素开始遍历, 并提供一个初始状态, 每次遍历时都会更新其状态, 并保存到返回值中, 遍历结束时会返回一个状态值的集合, 此集合的长度比原集合多1
    val ints: Seq[Int] = tupleSeq.scanLeft(1) {
      case (current, x) => current + x._1
    }
    println(s"ints = ${ints}")

    // scala.collection.TraversableLike.foldLeft
    // foldLeft 方法的作用是从集合首个元素开始遍历, 并提供一个初始状态(如: tupleSeq.head), 然后计算每个元素, 同时更新状态值, 知道返回单个最终状态值
    val foldLeft = tupleSeq.foldLeft(tupleSeq.head) {
      case (current, x) => (current._1 + x._1, current._2 + x._2)
    }
    println(s"foldLeft = ${foldLeft}")
  }
}
