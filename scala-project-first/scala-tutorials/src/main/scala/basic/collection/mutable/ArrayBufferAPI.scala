package basic.collection.mutable

import scala.collection.mutable.ArrayBuffer

/**
 * @author TomAndersen
 * @see [[scala.collection.mutable.ArrayBuffer]]
 */
object ArrayBufferAPI {
  def main(args: Array[String]): Unit = {
    // construct
    val arrayBuffer = ArrayBuffer[Int](1, 2, 3)

    // write
    // scala.collection.mutable.BufferLike.insert
    arrayBuffer.insert(0, 0)
    // scala.collection.mutable.BufferLike.append
    arrayBuffer.append(4)

    // read
    println(s"arrayBuffer = ${arrayBuffer}")
    println(s"arrayBuffer.toSeq = ${arrayBuffer.toSeq.toString()}")

    // delete
    arrayBuffer.trimStart(1)
    arrayBuffer.trimEnd(1)
    println(s"arrayBuffer = ${arrayBuffer}")
  }
}
