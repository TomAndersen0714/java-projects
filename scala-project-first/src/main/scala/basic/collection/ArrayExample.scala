package basic.collection

/**
 * @author TomAndersen
 */
object ArrayExample {
    def main(args: Array[String]): Unit = {
        // 创建 Array
        val arr = Array(1, 2, 3, 4, 5)

        // 读取 Array
        println(s"args.length = ${arr.length}")
        println(s"args(0) = ${arr(0)}")
    }
}
