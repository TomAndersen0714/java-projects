package lesson1.operators;

/**
 * @author TomAndersen
 * @link <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html">The Java™ Tutorials</a>
 */
public class UnaryOperator {
    public static void main(String[] args) {
        // 1. 自增和自减运算符
        int x = 1, y = 2;
        // 自增/自减运算符放置在变量前, 其优先级最高, 优先计算
        System.out.println("(2 * ++x) = " + (2 * ++x));
        // 自增/自减运算符放置在变量后, 其优先级最低, 最后计算
        System.out.println("(2 * y++) = " + (2 * y++));

        // 2. 逻辑补运算符(logical complement operator)
        System.out.println("(!false) = " + (!false));
    }
}
