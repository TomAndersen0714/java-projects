package basic.collection.immutable

/**
 * @author TomAndersen
 */
object RangeAPI {
  def main(args: Array[String]): Unit = {
    val numsSeq = Seq(1, 2, 3)
    val indices: Range = numsSeq.indices

    // scala.collection.immutable.Range.foreach
    indices.foreach(x => println(x))
  }
}
