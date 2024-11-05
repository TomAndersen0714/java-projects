package library.spark.dataframe

import library.spark.utils.ExampleUtils.withSpark
import org.apache.spark.sql.catalyst.expressions.Alias
import org.apache.spark.sql.functions.{col, count, expr, lit}

import scala.util.{Success, Try}

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
          (1, 1, 1, 1, "3"),
          (2, 2, 3, 4, "4")
        ).toDF("colA", "colB", "colC", "colD", "colE")

        // org.apache.spark.sql.Dataset.select(scala.collection.Seq<org.apache.spark.sql.Column>)
        print("org.apache.spark.sql.Column.alias")
        df.select(col("colA").alias("a").alias("a1")).show()
        df.selectExpr("if(colE = '', 1, 2)").show()

        // org.apache.spark.sql.RelationalGroupedDataset.count
        print("org.apache.spark.sql.RelationalGroupedDataset.count")
        df.groupBy("colA").agg(count(lit(1)).alias("COUNT_COL")).show()

        // org.apache.spark.sql.Dataset.withColumn(java.lang.String, org.apache.spark.sql.Column)
        // add new column into dataframe
        val boolColumnExp = "colA<colC"
        val sumColumnExp = "colA+colC"
        val newDF = df.withColumn(colName = boolColumnExp, col = expr(boolColumnExp))
        newDF.show()

        // add new column into dataframe
        val sumDF = df.withColumn(sumColumnExp, expr(sumColumnExp))
        sumDF.select(col(sumColumnExp) + col("colA")).show()

        val aggFunctionExp = "SUM(IF((colA > 1),1,0))"
        val aggColumn = expr(aggFunctionExp)
        val prettyExp = aggColumn.toString()
        val aggColumnWithAlias = aggColumn.alias("res")
        val aggColumnWithAliasExp= expr(aggColumnWithAlias.toString())

        println(s"aggFunctionExp = ${aggFunctionExp}")
        println(s"expr(aggFunctionExp).toString() = ${aggColumn.toString()}")
        println(s"expr(aggFunctionExp).alias('sum').toString() = ${aggColumnWithAlias.toString()}")

        // org.apache.spark.sql.Dataset.agg
        val aggDF = newDF.agg(aggColumn)
        aggDF.show()

        // org.apache.spark.sql.Dataset.createOrReplaceTempView
        aggDF.createOrReplaceTempView("aggDF")
        spark.sql("select * from aggDF").show()

        // NOTE: 如何聚合完成之后, 获取聚合结果的列名
        // newDF.agg(aggColumnWithAlias).select(aggColumnWithAlias).show()

        // org.apache.spark.sql.Dataset.select 方法支持按照表达式获取列, 但必须是格式化后的列名
        // aggDF.select(aggFunctionExp).show() // error!
        aggDF.select(prettyExp).show()

        // org.apache.spark.sql.Row.getAs(java.lang.String) 方法仅支持格式化后的列名
        // 当 DataFrame 列名是复杂表达式时, 会和原始的字符串存在出入, 会将其格式化为类似于 `SUM(IF((colA > 1), 1, 0))` 的形式
//         println(s"aggDF.head().getAs(aggFunctionExp) = ${aggDF.head().getAs(col(aggFunctionExp).toString())}")
        println(s"aggDF.head().getAs(aggFunctionExp) = ${aggDF.head().getAs(aggColumn.toString())}")
        println(s"aggDF.head().getAs(SUM(IF((colA > 1),1,0))) = ${aggDF.head().getAs("SUM(IF((colA > 1), 1, 0))")}")

        // dataframe to Map
        val map = df.collect().map(row => {
          val colA = row.getAs[Int]("colA")
          val colB = row.getAs[Int]("colB")
          (colA, colB)
        }).toMap

      }
    }
  }
}
