package basic.collection.mutable

import scala.collection.{MapLike, mutable}
import scala.collection.mutable.Map

/**
 * @author TomAndersen
 * @see [[scala.collection.mutable.Map]]
 */
object MapAPI {
  def main(args: Array[String]): Unit = {
    // scala.collection.mutable.Map
    val map = mutable.Map(1 -> "one", 2 -> "two", 3 -> "three")

    // read
    // scala.collection.IterableLike.foreach
    map.foreach {
      case (k, v) => println(s"key = ${k}, value = ${v}")
    }
    // scala.collection.MapLike.keys
    println(s"map.keys = ${map.keys}")
    println(s"map.values = ${map.values}")

    // update
    map(0) = "zero"
    map.update(1, "ONE")
    println(s"map = ${map}")

    val value = mutable.Map[Int, Any]()
    value.update(1, 1)
    value.update(1, "2")
    println(s"value.isInstanceOf[scala.collection.Map[_, _]] = ${value.isInstanceOf[scala.collection.Map[_, _]]}")

    val root = mutable.Map.empty
    Seq(Seq(1, 2, 3, 4), Seq(1, 2, 4, 3), Seq(2, 3, 1, 4)).foreach {
      row => treeNode(root.asInstanceOf[mutable.Map[Int, Any]], row)
    }
    println(s"root = ${root}")
  }

  // 将一条到叶子节点的路径, 加入到 Tree 上
  private def treeNode(root: mutable.Map[Int, Any], nodes: Seq[Int]): mutable.Map[Int, Any] = {
    // 如果当前路径只是一条边, 则直接生成叶节点插入
    if (nodes.length == 2) {
      root.update(nodes.head, nodes.tail.head.asInstanceOf[Any])
    }
    // 如果当前节点是新增节点
    else if (!root.contains(nodes.head)) {
      root.update(nodes.head, treeNode(mutable.Map.empty, nodes.tail))
    }
    // 如果当前节点已经存在, 则链接上当前节点
    else {
      val parent = root(nodes.head)
      root.update(nodes.head, treeNode(parent.asInstanceOf[mutable.Map[Int, Any]], nodes.tail))
    }
    root
  }
}
