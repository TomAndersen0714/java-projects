package library.spark.sql

import org.apache.spark.sql.Row

/**
 * @author TomAndersen
 * @see [[org.apache.spark.sql.Row]]
 */
object RowAPI {
  def main(args: Array[String]): Unit = {
    // create a Row
    val row = Row(1, 2, 3, 4, 5)
    println(s"row = ${row}")

    // getValuesMap
    val map = row.getValuesMap(Seq("1", "2", "3", "4", "5"))
    map.foreach(println)
  }
}
