package basic.collection.mutable

import scala.collection.mutable

/**
 * @author TomAndersen
 */
object SeqAPI {
  def main(args: Array[String]): Unit = {
    val numsSeq: mutable.Seq[Int] = mutable.Seq(1, 2, 3, 4)

    numsSeq(0) = 3

    println(s"numsSeq = ${numsSeq}")
  }
}
