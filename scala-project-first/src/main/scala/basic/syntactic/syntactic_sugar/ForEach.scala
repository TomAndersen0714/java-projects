package basic.syntactic.syntactic_sugar

/**
 * @author TomAndersen
 */
object ForEach {
    def main(args: Array[String]): Unit = {
        val nums: Seq[Int] = Seq(1, 2, 3)

        // foreach statement
        for (elem <- nums) {
            println(s"foreach statement: elem*2 = ${elem * 2}")
        }

        // foreach method
        nums.foreach(elem => println(s"foreach method: elem*2 = ${elem * 2}"))
    }
}
