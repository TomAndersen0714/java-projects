package basic.syntactic.implicits

/**
 * @author TomAndersen
 */
object ImplicitParameter {

    def main(args: Array[String]): Unit = {
        simpleExample()
        example()
    }

    private def simpleExample(): Unit = {
        // implicit parameter 隐式参数, 需要使用多参数列表单独声明
        // @see basic.concept.function.MultipleParameterListsFunction
        def greet(name: String)(implicit greeting: String): Unit = {
            println(s"$greeting, $name")
        }

        implicit val defaultGreeting: String = "Hello"
        // 使用隐式参数
        greet("Alice")

        // 显式传参调用
        greet(name = "Alice")(defaultGreeting)
    }

    private def example(): Unit = {
        trait Comparator[A] {
            def compare(x: A, y: A): Int
        }

        object Comparator {
            implicit object IntComparator extends Comparator[Int] {
                def compare(x: Int, y: Int): Int = Integer.compare(x, y)
            }

            implicit object StringComparator extends Comparator[String] {
                def compare(x: String, y: String): Int = x.compareTo(y)
            }
        }

        def max[A](x: A, y: A)(implicit comparator: Comparator[A]): A =
            if (comparator.compare(x, y) >= 0) x
            else y

        println(max(10, 6)) // 10
        println(max("hello", "world")) // world
    }
}
