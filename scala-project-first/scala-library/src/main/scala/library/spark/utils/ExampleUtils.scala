package library.spark.utils

import org.apache.spark.sql.SparkSession

/**
 * @author TomAndersen
 */
private[spark] object ExampleUtils {
    def withSpark(func: SparkSession => Unit): Unit = {
        // 创建 SparkSession
        val session = SparkSession.builder()
            .master("local")
            .appName("test")
            .config("spark.ui.enabled", "false")
            .getOrCreate()

        session.sparkContext.setCheckpointDir(System.getProperty("java.io.tmpdir"))

        try {
            func(session)
        } finally {
            session.stop()
            System.clearProperty("spark.driver.port")
        }
    }
}
