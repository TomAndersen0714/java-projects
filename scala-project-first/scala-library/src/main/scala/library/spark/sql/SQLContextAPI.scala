package library.spark.sql

import library.spark.utils.ExampleUtils.withSpark
import org.apache.spark.sql.SparkSession

/**
 * @author TomAndersen
 */
object SQLContextAPI {
  def main(args: Array[String]): Unit = {
    withSpark {
      spark: SparkSession => {
        spark.sql("select 1 as a, 2 as b, 3 as c").show()
      }
    }
  }
}
