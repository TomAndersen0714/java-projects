package library.spark.rdd

import library.spark.utils.ExampleUtils.withSpark
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, Encoders, SparkSession}

/**
 * @author TomAndersen
 */
object RDDExample {
    def main(args: Array[String]): Unit = {
        rddPrimitiveExample()
        rddCaseClassExample()
    }

    private def rddPrimitiveExample(): Unit = {
        withSpark {
            spark: SparkSession => {
                println("rddPrimitiveExample:")

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

                // DataSet直接转换为 DataFrame
                val dataFrame1 = dataSet.toDF()
                dataFrame1.show()
            }
        }
    }

    private case class Item(id: String, name: String, value: Long)

    private def rddCaseClassExample(): Unit = {
        withSpark {
            spark: SparkSession => {
                println("rddCaseClassExample:")

                // using seq with case class to create RDD
                val rdd: RDD[Item] = spark.sparkContext.parallelize(Seq(
                    Item("1", "Tom", 123),
                    Item("2", "Alice", 110),
                    Item("3", "Jim", 101),
                    Item("4", "John", 121),
                ))

                val dataSet = spark.createDataset(rdd)(Encoders.product[Item])
                dataSet.show()

                val dataFrame = spark.createDataFrame(rdd)
                dataFrame.show()

                val dataFrame1 = dataSet.toDF()
                dataFrame1.show()
            }
        }
    }
}
