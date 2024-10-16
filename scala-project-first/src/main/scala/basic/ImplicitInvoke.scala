package basic

/**
 * @author TomAndersen
 */
object ImplicitInvoke {
    def main(args: Array[String]): Unit = {
        // IDEA 中可以通过Scala plugin的x-ray mode功能显示文件的隐式调用, 默认快捷键为双击Ctrl并保持按压
        implicit val defaultPerson: Person = Person("John Doe")

        def greet(implicit person: Person): String = s"Hello, ${person.name}!"

        println(greet) // 调用当前作用域中的隐式值 defaultPerson
    }

    private case class Person(name: String)
}
