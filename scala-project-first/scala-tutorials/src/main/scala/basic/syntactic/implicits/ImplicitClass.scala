package basic.syntactic.implicits

/**
 * @author TomAndersen
 */
object ImplicitClass {
    // Implicit Class
    // 通过隐式类 implicit class, 即装饰器模式, 可以在不修改源码的情况下, 通过为其实模块现功能扩展
    // 类似于 Python 中的装饰器 decorator , Java 中的注解 annotation 等
    implicit class RichInt(val x: Int) {
        def square: Int = x * x
    }

    def main(args: Array[String]): Unit = {

        val num: Int = 5

        // 显式调用, 显式通过类的构造器, 以及对应方法
        println(RichInt(num).square)

        // 隐式调用, 通过 square 方法查找对应隐式类 Implicit Class
        // 然后通过隐式类构造器生成隐式类实例, 调用 square 方法
        println(num.square)
    }
}
