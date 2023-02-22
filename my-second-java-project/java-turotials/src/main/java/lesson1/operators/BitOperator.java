package lesson1.operators;

public class BitOperator {
    public static void main(String[] args) {
        // bit operator
        // and: &, or:|, xor: ^, not: ~
        System.out.println("(0b10 & 0b11) = " + (0b10 & 0b11));
        System.out.println("(0b10 | 0b11) = " + (0b10 | 0b11));
        System.out.println("(0b10 ^ 0b11) = " + (0b10 ^ 0b11));
        System.out.println("(~0b11) = " + (~0b11));

        // & 和 |, 与 && 和 || 的不同之处在于, 后者采用的是“短路”的方式进行运算, 而前者则是串联的方式进行运算
        // 即此二元表达式两边的结果都需要计算出来, 才会返回表达式的最终结果
        System.out.println("(true & false) = " + (true & false));
        System.out.println("(true | false) = " + (true | false));

        int n = 1234;
        int fourthBitFromRight = n & 0b1000;
        System.out.println("fourthBitFromRight = " + fourthBitFromRight);

        // <<, >>
        System.out.println("(1 << 3) = " + (1 << 3));
        // 2*2*2, 0x1p3

        // Java中负数是以补码的形式存储的, 因此在移位时, 是针对其补码进行移位
        // >> 移位运算符, 会用左操作数的符号位(正0, 负1), 填充其最高bit位
        System.out.println("(-0b1 >> 3) = " + (-0b1 >> 3));

        // >>>, 移位运算符, 会用0填充其最高bit位
        // PS: Java 不存在 <<< 运算符
        System.out.println("(0b1001 >>> 3) = " + (0b1001 >>> 3));
        System.out.println("(-0b1001 >>> 3) = " + (-0b1001 >>> 3));
    }
}
