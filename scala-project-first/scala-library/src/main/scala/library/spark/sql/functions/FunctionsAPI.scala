package library.spark.sql.functions

import library.spark.utils.ExampleUtils.withSpark
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions.col

/**
 * @author TomAndersen
 */
object FunctionsAPI {
  def main(args: Array[String]): Unit = {
    withSpark {
      spark => {
        // org.apache.spark.sql.functions.col
        // Returns a Column based on the given column name. 需要注意的是, 此方法会格式化列名, 当列名是复杂表达式时, 会导致列名和原始值存在出入
        val column: Column = col("SUM(IF(2>1,1,2))")
        println(s"column.toString = ${column.toString()}")
        println(s"column.expr.toString() = ${column.expr.toString()}")


      }
    }
  }
}
