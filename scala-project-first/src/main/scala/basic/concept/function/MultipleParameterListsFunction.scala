package basic.concept.function

/**
 * @author TomAndersen
 * @see https://docs.scala-lang.org/tour/multiple-parameter-lists.html
 */
object MultipleParameterListsFunction {
    // 多参数列表, 也被称为 curried 柯里化
    def main(args: Array[String]): Unit = {
        val numbers: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val res = numbers.foldLeft(0)((m, n) => m + n)
        print(res) // 55
    }
}
