package basic

/**
 * @author TomAndersen
 */
class ClassDemo {
    // scala中类字段field必须要初始化
    var age = 0 // scala中没有public关键字, class field默认是公有的public
    private var value = 0 // 只有private需要显式声明


    // Unit 关键字代表当前方法无返回值, Unit 是个空对象
    def increment(): Unit = {
        value += 1
    }

    def current(): Int = value

    // 自定义 setter 和 getter 方法
    def otherAge: Int = this.age

    def otherAge_=(newAge: Int): Unit = {
        this.age = Math.min(100, newAge)
    }
}

object ClassDemo {
    def main(args: Array[String]): Unit = {
        // Class Demo
        val classDemo = new ClassDemo()

        classDemo.increment()
        println(classDemo.current())

        // scala 中针对每个field都有 setter 和 getter 方法
        classDemo.age_=(123) // 调用 setter 方法 age_=
        classDemo.age = 123 // 调用 setter 方法 age_=
        println(classDemo.age) // 调用 getter 方法 age

        classDemo.otherAge = 123 // 调用 setter 方法 otherAge_=
        println(s"classDemo.otherAge = ${classDemo.otherAge}") // 调用 getter 方法 otherAge
    }
}
