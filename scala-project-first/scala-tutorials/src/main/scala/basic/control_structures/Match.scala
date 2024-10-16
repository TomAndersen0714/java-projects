package basic.control_structures

/**
 * @author TomAndersen
 */
object Match {
    def main(args: Array[String]): Unit = {
        // Primitive Type 基础类型模式匹配
        var sign: Int = 0
        val ch: Char = 'b' // Char 变量不能为空字符

        ch match {
            case 'c' => sign = 'c' - 'a'
            case 'b' => sign = 'b' + 'a'
            case _ => sign = 0
        }

        println(s"sign = ${sign}")

        // Case Class 样例类模式匹配
    }
}
