package basic.collection

/**
 * @author TomAndersen
 */
object SeqAPI {
  def main(args: Array[String]): Unit = {
    val numsSeq: Seq[Int] = Seq(1, 2, 3, 4)

    // scala.collection.IterableLike.take
    // Selects first n elements
    println(s"numsSeq.take(3) = ${numsSeq.take(3)}")

    // scala.collection.TraversableLike.flatMap
    val flatMapSeq: Seq[Int] = numsSeq.flatMap((x: Int) => Seq(x, x))
    println(s"flatMapSeq = ${flatMapSeq}")
  }
}
