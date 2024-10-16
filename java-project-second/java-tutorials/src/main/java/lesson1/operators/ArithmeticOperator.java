package lesson1.operators;

import library.Utils;

/**
 * @author TomAndersen
 */
public class ArithmeticOperator {
    public static void main(String[] args) {
        // arithmetic operator
        int a = 1;
        // System.out.println(a / 0); // java.lang.ArithmeticException: / by zero

        double double_a = 1.1;
        double double_b = -1.1;
        System.out.println("(double_a / 0) = " + (double_a / 0));
        System.out.println("(double_b / 0) = " + (double_b / 0));

        int b = 15, c = 2;
        // add
        System.out.println("(b + c) = " + (b + c));
        // subtract
        System.out.println("(b - c) = " + (b - c));
        // multiply
        System.out.println("(b * c) = " + (b * c));
        // divide
        System.out.println("(b / c) = " + (b / c));
        // modulus
        System.out.println("(b % c) = " + (b % c));

        // 如果算术运算符返回的结果数据类型, 与被赋值的变量不同, 则会发生强制类型转换
        // 即如果是向下强制转换, 则会出现溢出阶段
        a = 8;
        a += 2.1;
        System.out.println(Utils.getClassName(a) + ": " + a);
    }
}
