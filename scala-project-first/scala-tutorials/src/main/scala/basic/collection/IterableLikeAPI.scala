package basic.collection

/**
 * @author TomAndersen
 * @see [[scala.collection.IterableLike]]
 */
object IterableLikeAPI {
  def main(args: Array[String]): Unit = {
    val nums: Seq[Int] = Seq(1, 2, 3, 4)
    val offsets = nums.scanLeft(0) {
      case (cursor, x) => cursor + 1
    }
    println(s"offsets = ${offsets}")

    // scala.collection.IterableLike.zip
    // zip 方法的作用是将两个集合对应位置上的元素依次组合, 并生成新的集合
    val seq: Seq[(Int, Int)] = nums.zip(offsets.slice(0, nums.length))
    println(s"seq = ${seq}")
  }
}
