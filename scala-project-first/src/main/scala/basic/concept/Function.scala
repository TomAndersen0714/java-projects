package basic

/**
 * @author TomAndersen
 */
object Function {
    def main(args: Array[String]): Unit = {
        // scala 中函数也是某个类的实例, 可以赋值给变量和作为参数传递
        val addOne: Int => Int = (x: Int) => x + 1

        println(s"addOne(5) = ${addOne(5)}")
    }
}
