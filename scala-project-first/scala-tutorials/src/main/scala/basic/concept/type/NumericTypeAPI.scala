package basic.concept.variable

/**
 * @author TomAndersen
 * @see [[scala.Byte]]
 */
object NumericTypeAPI {
  def main(args: Array[String]): Unit = {
    // numeric type class
    val s: Short = 1
    val x: Int = 1
    val l: Long = 1
    val f: Float = 3.0F
    val d: Double = 2.0
    val b: Byte = 1
    val c: Char = '0'

    // scala.Byte
    println(s"b.toShort = ${b.toShort}")
  }
}
