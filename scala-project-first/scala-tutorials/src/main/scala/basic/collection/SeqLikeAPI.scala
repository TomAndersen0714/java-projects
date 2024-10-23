package basic.collection

/**
 * @author TomAndersen
 * @see [[scala.collection.SeqLike]]
 */
object SeqLikeAPI {
  def main(args: Array[String]): Unit = {
    val numsSeq: Seq[Int] = Seq(1, 2, 3, 4)

    // read
    // scala.collection.IterableLike.head
    println(s"numsSeq.head = ${numsSeq.head}")
    println(s"numsSeq.head = ${numsSeq.head}")
    // scala.collection.TraversableLike.tail
    println(s"numsSeq.tail = ${numsSeq.tail}")

    // scala.collection.SeqLike.indices
    numsSeq.indices.foreach(idx => {
      print(idx)
    })
    println()

    // scala.collection.SeqLike.intersect
    // 注意: 这里有 implicit 转换
    println("Hello World!".intersect("world"))
  }
}
