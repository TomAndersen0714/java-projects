package library.spark.rdd

import library.spark.utils.ExampleUtils.withSpark
import org.apache.spark.sql.SparkSession

/**
 * @author TomAndersen
 */
object RDDExample {
    def main(args: Array[String]): Unit = {
        withSpark {
            spark: SparkSession => {
                val data = Seq(1, 2, 3, 4, 5)
                val rdd = spark.sparkContext.parallelize(data)

                // 导入隐式转换
                import spark.implicits._
                val dataFrame = rdd.toDF("numbers")
                // 上述代码等价于下列显式调用
                // val dataFrame = rddToDatasetHolder(rdd)(newIntEncoder).toDF("numbers")

                println("Hello World!")
            }
        }
    }
}
