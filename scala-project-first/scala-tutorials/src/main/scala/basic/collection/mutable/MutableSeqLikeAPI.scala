package basic.collection.mutable

import scala.collection.mutable

/**
 * @author TomAndersen
 * @see [[scala.collection.mutable.SeqLike]]
 */
object MutableSeqLikeAPI {
  def main(args: Array[String]): Unit = {
    val numsSeq = mutable.Seq(1, 2, 3, 4)

    // scala.collection.mutable.SeqLike.update
    // update 更新指定位置的元素
    numsSeq(0) = 2
    numsSeq.update(1, 1)
    println(s"numsSeq = ${numsSeq}")

    //

    // scala.collection.mutable.SeqLike.transform
    // transform 使用指定函数修改当前 Sequence 中的所有元素
    val numsSeq1 = numsSeq.transform(_ * 2)
    println(s"numsSeq = ${numsSeq}")
    println(s"numsSeq1 = ${numsSeq1}")
    println(s"numsSeq == numsSeq1 = ${numsSeq == numsSeq1}")

  }
}
