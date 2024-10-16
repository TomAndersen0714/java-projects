package library.spark.rdd

import library.spark.utils.ExampleUtils.withSpark

/**
 * @author TomAndersen
 */
object RDDExample {
    def main(args: Array[String]): Unit = {
        withSpark {
            spark => {
                println("Hello World!")
            }
        }
    }
}
