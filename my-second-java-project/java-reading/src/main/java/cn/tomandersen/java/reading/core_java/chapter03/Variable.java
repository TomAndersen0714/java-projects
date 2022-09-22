package cn.tomandersen.java.reading.core_java.chapter03;

import cn.tomandersen.java.reading.utils.Utils;

public class Variable {
    public static void main(String[] args) {
        // declare
        int a, b; // 虽然 Java 支持一行中声明多个变量, 但是并不推荐这种可读性较差的写法

        // initialize
        a = 1;
        b = 2;
        System.out.println(a); // 在 Java 中, 变量的声明, 要尽可能靠近第一次使用这个变量的地方, 常量除外
        System.out.println(b);

        // 自 Java10 开始, 如果可以从变量的初始值推断出其数据类型, 则可以不显式声明类型
        var int_a = 12;
        var long_a = 12L;
        System.out.println(Utils.getClassName(int_a) + ": " + int_a);
        System.out.println(Utils.getClassName(long_a) + ": " + long_a);


    }
}
