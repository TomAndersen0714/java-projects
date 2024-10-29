package basic.collection

/**
 * @author TomAndersen
 */
object SeqAPI {
  def main(args: Array[String]): Unit = {
    val numsSeq: Seq[Int] = Seq(1, 2, 3, 4)
    val tupleSeq: Seq[(Int, Int)] = Seq((1, 2), (3, 4), (5, 6))
    println(s"numsSeq = ${numsSeq}")

    // scala.collection.IterableLike.take
    // Selects first n elements
    println(s"numsSeq.take(3) = ${numsSeq.take(3)}")

    // scala.collection.TraversableLike.flatMap
    val flatMapSeq: Seq[Int] = numsSeq.flatMap((x: Int) => Seq(x, x))
    println(s"flatMapSeq = ${flatMapSeq}")

    // scala.collection.TraversableOnce.toMap
    val map = tupleSeq.toMap
    println(s"map = ${map}")
  }
}
