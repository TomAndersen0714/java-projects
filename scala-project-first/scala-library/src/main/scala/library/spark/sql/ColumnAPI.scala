package library.spark.sql

import org.apache.spark.sql.functions.col

/**
 * @author TomAndersen
 */
object ColumnAPI {
  def main(args: Array[String]): Unit = {
    // org.apache.spark.sql.Column.alias
    print(col("SUM(IF(2>1,1,2))").alias("sum").toString()) // SUM(IF(2>1,1,2)) AS `sum`
    print(col("SUM(IF(2>1,1,2))").alias("sum").alias("sum2").toString())
  }
}
