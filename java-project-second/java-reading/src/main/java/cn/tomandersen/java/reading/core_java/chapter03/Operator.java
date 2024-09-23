package cn.tomandersen.java.reading.core_java.chapter03;

import cn.tomandersen.java.reading.utils.Utils;

public class Operator {
    static void arithmeticOperator() {
        // arithmetic operator
        int a = 1;
        // System.out.println(a / 0); // java.lang.ArithmeticException: / by zero

        double double_a = 1.1;
        double double_b = -1.1;
        System.out.println(double_a / 0);
        System.out.println(double_b / 0);

        int b = 15, c = 2;
        System.out.println(b + c); // add
        System.out.println(b - c); // subtract
        System.out.println(b * c); // multiply
        System.out.println(b / c); // divide
        System.out.println(b % c); // modulus
    }

    static void assignmentOperator() {
        // assignment operator
        // 算术运算符可以与赋值符号一起使用, 实现简写
        int a;
        a = 8;
        System.out.println(a += 4); // equals to 'a = a + 4'
        a = 8;
        System.out.println(a *= 4); // equals to 'a = a + 4'
        a = 8;
        System.out.println(a %= 4); // equals to 'a = a % 4'
        a = 8;
        System.out.println(a /= 4); // equals to 'a = a / 4'

        // 如果二元运算符返回的结果数据类型, 与被赋值的变量不同, 则会发生强制类型转换, 可能出现丢失精度问题
        a = 8;
        a += 2.1;
        System.out.println(Utils.getClassName(a) + ": " + a);

        // 自增和自减运算符
        int x = 1, y = 2;
        System.out.println(2 * ++x); // 自增/自减运算符放置在变量前, 其优先级最高, 优先计算
        System.out.println(2 * y++); // 自增/自减运算符放置在变量后, 其优先级最低, 最后计算
    }

    static void booleanOperator() {
        // boolean operator
        System.out.println(1 >= 2); // false
        System.out.println(1 != 2); // true
        System.out.println(1 == 2); // false
        System.out.println(1 == 1 && 2 == 1); // false
        System.out.println(1 == 1 || 2 == 1); // true
        System.out.println(!false); // true
        // && 和 || 采用的是“短路”的方式进行运算, 即当此二元运算符的前一个表达式已经能够确定此运算结果时,
        // 则不会计算第二个表达式的值

    }

    static void conditionOperator() {
        // conditional operator
        System.out.println(1 == 2 ? 1 : 2);

        // switch block
        String type = "a";
        switch (type) {
            case "a":
                System.out.println("This is 'a',");
                break;
            case "b":
                System.out.println("This is 'b',");
                break;
            default:
                System.out.println("Unknown case!");
        }

    }

    static void bitOperator() {
        // bit operator
        // and: &, or:|, xor: ^, not: ~
        System.out.println(0b10 & 0b11);
        System.out.println(0b10 | 0b11);
        System.out.println(0b10 ^ 0b11);
        System.out.println(~0b11);

        // & 和 |, 与 && 和 || 的不同之处在于, 后者采用的是“短路”的方式进行运算, 而前者则是串联的方式进行运算
        // 即此二元表达式两边的结果都需要计算出来, 才会返回表达式的最终结果
        System.out.println(true & false);
        System.out.println(true | false);

        int n = 1234;
        int fourthBitFromRight = (n & 0b1000) / 0b1000;
        System.out.println(fourthBitFromRight);

        // <<, >>
        System.out.println(1 << 3); // 2*2*2, 0x1p3
        // Java中负数是以补码的形式存储的, 因此在移位时, 是针对其补码进行移位
        System.out.println(-0b1 >> 3); // >> 移位运算符, 会用左操作数的符号位(正0, 负1), 填充其最高bit位

        // >>>, 移位运算符, 会用0填充其最高bit位
        // NOTE: Java 不存在 <<< 运算符
        System.out.println(0b1001 >>> 3);
        System.out.println(-0b1001 >>> 3);
    }

    public static void main(String[] args) {
//        arithmeticOperator();
//        assignmentOperator();
//        booleanOperator();
//        conditionOperator();
        bitOperator();
    }
}
