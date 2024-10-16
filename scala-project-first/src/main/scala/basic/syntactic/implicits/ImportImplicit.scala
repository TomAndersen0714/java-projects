package basic.syntactic.implicits

/**
 * @author TomAndersen
 */
object ImportImplicit {
    trait Show[T] {
        def show(value: T): String
    }

    object ShowInstances {
        // using lambda expression to implement trait
        implicit val intShow: Show[Int] = (value: Int) => s"Int: $value"

        implicit val stringShow: Show[String] = new Show[String] {
            def show(value: String): String = s"String: $value"
        }
    }

    object ShowSyntax {
        implicit class ShowOps[T](value: T) {
            def show(implicit s: Show[T]): String = s.show(value)
        }
    }
}

object Example {

    import basic.syntactic.implicits.ImportImplicit.ShowInstances._
    import basic.syntactic.implicits.ImportImplicit.ShowSyntax._

    def main(args: Array[String]): Unit = {
        println(123.show) // 使用隐式参数
        println("Hello".show) // 使用隐式参数
    }
}
