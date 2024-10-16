package basic.syntactic.imports

/**
 * @author TomAndersen
 * @see
 */
object Import {
    def main(args: Array[String]): Unit = {
        // 导入包内所有成员
        import scala.collection._
        // 导入类
        import scala.collection.Seq
        // 导入类内指定成员
        import scala.collection.Seq.{newBuilder, canBuildFrom}
        // 导入类内所有成员
        import scala.collection.Seq._
    }
}
