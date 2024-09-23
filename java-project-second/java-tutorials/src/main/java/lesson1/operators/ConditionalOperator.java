package lesson1.operators;

/**
 * @author TomAndersen
 * @link <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html"> The Java™ Tutorials</a>
 */
public class ConditionalOperator {
    public static void main(String[] args) {

        // conditional operator
        // && and ||
        // && 和 || 采用的是“短路”的方式进行运算, 即运算符的前一个表达式已经能够确定此运算结果时, 便不会计算第二个表达式的值
        System.out.println("(1 == 1 && 2 == 1) = " + (1 == 1 && 2 == 1));
        System.out.println("(1 == 1 || 2 == 1) = " + (1 == 1 || 2 == 1));
        System.out.println("(!false) = " + (!false));


        // ?: conditional operator, or named Ternary conditional operator
        System.out.println("(1 == 2 ? 1 : 2) = " + (1 == 2 ? 1 : 2));
    }
}
