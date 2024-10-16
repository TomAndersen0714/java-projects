package library.spark.dataframe

import library.spark.utils.ExampleUtils.withSpark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.expr

/**
 * @author TomAndersen
 */
object DataFrameExmaple {
    def main(args: Array[String]): Unit = {

        withSpark {
            spark => {
                // 处理输入
                val dataFilePath = "."

                // 定义 UDF
                def SomeUDF(input: String): String = {
                    input.toUpperCase
                }

                // 注册 UDF
                spark.udf.register("myUDF", SomeUDF(_: String): String)
                val df = spark.read.json(dataFilePath)
                df.groupBy(expr("myUDF(group)")).sum().collect()
                    .foreach(x => println(x))
            }
        }
    }
}
