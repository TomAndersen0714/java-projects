package basic.concept.variable

/**
 * @author TomAndersen
 */
object Variable {
    // scala 中的程序入口, 只能是单例对象 object 的 main 方法
    def main(args: Array[String]): Unit = {
        // numeric
        var intVar: Int = 1 // 字面量都是对象
        var floatVar = 1.1f // 声明变量时, 类型注释type annotation可以不加, Scala会进行隐式推断,
        // 后续也无法更改变量所能指向数据类型, 如: intVar = 12.1

        var res: Double = 0.0 // var是可变变量, 即变量的指向可以修改
        val constantVal: Double = 1.5 // val是不可变变量, 即变量的指向无法修改

        res = res * constantVal
        println(s"res = ${res}")
        val x, y: Int = 100
        println(s"x = ${x}, y = ${y}")
        var (num1: Float, num2: Double, num3: Int) = (1.2f, 1.2, 3)
        println(s"num1 = ${num1}, num2 = ${num2}, num3 = ${num3}")

        // String
        val str = "Hello World!"
        println(str)
        println(s"str.indexOf('o') = ${str.indexOf('o')}")

        // scala.collection.SeqLike.intersect
        println(str.intersect("world"))
    }
}
