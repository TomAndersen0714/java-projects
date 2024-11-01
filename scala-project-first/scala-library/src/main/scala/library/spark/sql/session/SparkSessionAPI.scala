package library.spark.sql.session

import library.spark.utils.ExampleUtils.withSpark
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

/**
 * @author TomAndersen
 */
object SparkSessionAPI {
  def main(args: Array[String]): Unit = {
    // org.apache.spark.sql.SparkSession.builder
    // Creates a SparkSession.Builder for constructing a SparkSession.
    val builder: SparkSession.Builder = SparkSession.builder()

    withSpark {
      spark: SparkSession => {

        // org.apache.spark.sql.SparkSession.sql
        val functionExp = "IF(1 > 2, 1, 0)"
        val aggFunctionExp = "SUM(IF(1 < 2, 1, 0))"
        val dataFrame: DataFrame = spark.sql(
          s"select 1 as a, 2 as a, 3 as b, $functionExp, $aggFunctionExp"
        )
        dataFrame.show()

        // org.apache.spark.sql.SQLContext.sql
        dataFrame.sqlContext.sql("select 1 as a, 2 as a, 3 as b").show()

        dataFrame.foreach((row: Row) => {
          println(s"row = ${row}")
          println(s"a = ${row.getAs[Int]("a")}")
//          println(s"$functionExp = ${row.getAs(functionExp)}")
        })
      }
    }
  }
}
