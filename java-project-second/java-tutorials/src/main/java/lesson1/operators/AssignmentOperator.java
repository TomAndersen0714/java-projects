package lesson1.operators;

/**
 * @author TomAndersen
 * @link <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html">The Java™ Tutorials</a>
 */
public class AssignmentOperator {
    public static void main(String[] args) {
        // assignment operator

        // a simple assignment operator
        int a = 8;

        // you can also combine the arithmetic operators with the simple assignment operator to
        // create compound assignments
        // 算术运算符可以与赋值符号一起使用, 实现简写
        a = 8;
        System.out.println("(a += 4) = " + (a += 4)); // equals to 'a = a + 4'
        a = 8;
        System.out.println("(a -= 4) = " + (a -= 4)); // equals to 'a = a - 4'
        a = 8;
        System.out.println("(a *= 4) = " + (a *= 4)); // equals to 'a = a * 4'
        a = 8;
        System.out.println("(a %= 4) = " + (a %= 4)); // equals to 'a = a % 4'
        a = 8;
        System.out.println("(a /= 4) = " + (a /= 4)); // equals to 'a = a / 4'

    }
}
