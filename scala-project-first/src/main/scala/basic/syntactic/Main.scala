package basic.syntactic

/**
 * @author TomAndersen
 */
object Main1 {
    // 程序入口声明方式1: 单例对象 object, 通过实现 main 方法, scala可以将main方法作为程序入口执行
    def main(args: Array[String]): Unit = {
        println("Main1: Hello World")
    }
}

object Main2 extends App {
    // 程序入口声明方式2: 单例对象 object 通过继承特质 trait App, scala可以直接将对象体中的代码作为程序入口执行
    println("Main2: Hello World")
}

object Main3 extends App {
    // 程序入口声明方式3: 覆盖特质的main方法, 但此方式已经被标记为了 deprecated
    override def main(args: Array[String]): Unit = {
        println("Main3: Hello World")
    }
}
