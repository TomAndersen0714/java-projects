package basic.collection

/**
 * @author TomAndersen
 * @see [[scala.collection.TraversableLike]]
 */
object TraversableLikeAPI {
  def main(args: Array[String]): Unit = {

    val numsSeq = Seq(1, 2, 3, 4)
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
  }
}
