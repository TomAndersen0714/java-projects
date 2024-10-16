package library.spark.rdd

import library.spark.utils.ExampleUtils.withSpark
import org.apache.spark.sql.{Dataset, SparkSession}

/**
 * @author TomAndersen
 */
object RDDExample {
    def main(args: Array[String]): Unit = {
        withSpark {
            spark: SparkSession => {
                val data = Seq(1, 2, 3, 4, 5)
                val rdd = spark.sparkContext.parallelize(data)

                // 导入隐式转换函数
                import spark.implicits._

                // RDD 通过隐式转换函数转换为 DataSet
                val dataSet: Dataset[Int] = rdd.toDS()
                // 上述代码等价于下列显式调用, 即 RDD -> DataSet -> DatasetHolder -> DataSet
                // val dataSet: Dataset[Int] = rddToDatasetHolder(rdd)(newIntEncoder).toDS()
                dataSet.show()

                // RDD 通过隐式转换函数转换为 DataFrame
                val dataFrame = rdd.toDF("numbers")
                // 上述代码等价于下列显式调用, 即 RDD -> DataSet -> DatasetHolder -> DataFrame
                // val dataFrame = rddToDatasetHolder(rdd)(newIntEncoder).toDF("numbers")
                dataFrame.show()
            }
        }
    }
}
