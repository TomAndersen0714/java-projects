package basic.syntactic.implicits

import scala.language.implicitConversions

/**
 * @author TomAndersen
 */
object ImplicitFunction {
    // 隐式转换方法 Implicit conversion function
    implicit def implicitIntToString(x: Int): String = s"implicit conversion from ${x}".trim

    // 普通方法
    private def explicitIntToString(x: Int): String = s"explicit conversion from ${x}".trim

    def main(args: Array[String]): Unit = {
        def printString(str: String): Unit = {
            println(s"str = ${str}")
        }

        val num = 120
        // 隐式调用
        printString(num)
        printString(explicitIntToString(num))
    }
}
