package basic

/**
 * @author TomAndersen
 */
object Main1 extends App {
    // 单例对象 object 通过继承特质 trait App, scala可以直接将对象体代码作为程序入口执行
    println("Main1: Hello World")
}

object Main2 {
    // 单例对象 object, 通过实现 main 方法, scala可以将main方法作为程序入口执行
    def main(args: Array[String]): Unit = {
        println("Main2: Hello World")
    }
}
