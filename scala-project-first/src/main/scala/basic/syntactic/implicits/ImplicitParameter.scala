package basic.syntactic.implicits

/**
 * @author TomAndersen
 */
object ImplicitParameter {

    def main(args: Array[String]): Unit = {
        def greet(name: String)(implicit greeting: String): Unit = {
            println(s"$greeting, $name")
        }

        implicit val defaultGreeting: String = "Hello"
        // 使用隐式参数
        greet("Alice")

        // 显式传参调用
        greet(name = "Alice")(defaultGreeting)
    }
}
