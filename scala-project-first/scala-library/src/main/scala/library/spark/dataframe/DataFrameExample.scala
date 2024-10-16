package library.spark.dataframe

import library.spark.utils.ExampleUtils.withSpark
import org.apache.spark.sql.functions.expr

/**
 * @author TomAndersen
 */
object DataFrameExample {
    def main(args: Array[String]): Unit = {
        example()
    }

    private def example(): Unit = {
        withSpark {
            spark => {
                // 导入 spark 内置的隐式转换工具, 使用隐式类和隐式转换函数, 进而给 Seq 类新增方法, 即 toDF
                import spark.implicits._
                val df = List(
                    (1, 1, 1, 1, 3),
                    (2, 2, 3, 4, 4)
                ).toDF("colA", "colB", "colC", "colD", "colE")

                val myExpression = "colA<colC"

                df.withColumn(colName = myExpression, col = expr(myExpression)).show()
            }
        }
    }
}
