package library.spark.rdd

import library.spark.utils.ExampleUtils.withSpark
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, Encoders, SparkSession}

/**
 * @author TomAndersen
 */
object RDDExample {
    def main(args: Array[String]): Unit = {
        ConvertExample()
    }

    private def ConvertExample(): Unit = {
        withSpark {
            spark: SparkSession => {
                println("ConvertExample:")

                // org.apache.spark.SparkContext.parallelize
                // Seq => RDD
                val data: Seq[Int] = Seq(1, 2, 3, 4, 5)
                val rdd = spark.sparkContext.parallelize(data)

                // 导入 spark 内置的隐式转换工具, 即 spark.implicits 所有命名空间下的所有类
                import spark.implicits._

                // org.apache.spark.sql.DatasetHolder.toDS
                // RDD 通过隐式转换函数转换为 DataSet
                // RDD => DatasetHolder => DataSet
                val dataSet: Dataset[Int] = rdd.toDS()
                /**
                 * 上述代码等价于下列显式调用, 即 RDD -> DataSet -> DatasetHolder -> DataSet
                 * val dataSet: Dataset[Int] = rddToDatasetHolder(rdd)(newIntEncoder).toDS()
                 * */
                // org.apache.spark.sql.Dataset.show
                dataSet.show()

                // org.apache.spark.sql.DatasetHolder.toDF
                // RDD 通过隐式转换函数转换为 DataFrame
                // RDD => DatasetHolder => DataFrame
                val dataFrame = rdd.toDF("numbers")
                /**
                 * 上述代码等价于下列显式调用, 即 RDD -> DataSet -> DatasetHolder -> DataFrame
                 * val dataFrame = rddToDatasetHolder(rdd)(newIntEncoder).toDF("numbers")
                */
                dataFrame.show()

                // DataSet直接转换为 DataFrame
                // org.apache.spark.sql.Dataset.toDF
                // DataSet => DataFrame
                val dataFrame1 = dataSet.toDF()
                dataFrame1.show()
            }
        }
    }

    private case class Item(id: String, name: String, value: Long)
}
