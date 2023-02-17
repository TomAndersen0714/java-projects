package lesson1.data_types;


import libraries.Utils;

public class PrimitiveType {

    static void integerDemo() {
        // integer type
        // int, 4 bytes
        int int_a = 1_000; // 使用下划线可以增强可读性, 编译器会自动删除数值字面量中的下划线
        int int_b = 0x1_000; // Hexadecimal, 16进制, 以0x或0X为前缀
        int int_c = 010; // Octal, 8进制, 以0为前缀
        int int_d = 0b10; // Binary, 2进制, 以0b或0B为前缀
        System.out.println(int_a);
        System.out.println(int_b);
        System.out.println(int_c);
        System.out.println(int_d);

        // long, 8 bytes
        long long_a = 1_000L; // 以L或l为后缀的整数字面量, 即为long类型, 否则皆为int类型
        // long long_b = 1_000l;
        System.out.println(long_a);
        // System.out.println(long_b);

        // short, 2 bytes
        short short_a = 1_000; // 整型字面量中没有 short 类型字面量
        System.out.println(short_a);
        // byte, 1 byte, first bit is the sign bit
        byte byte_a = -0b1001100; // 整型字面量中没有 byte 类型字面量
        System.out.println(byte_a);

        // 自 Java10 开始, 对于局部变量, 支持从其初始值来判断其数据类型, 而不需要声明
        // PS: 还是强烈建议, 通过显示声明的方式, 定义变量的类型, 以增强可读性
        var a = 1;
        var b = 1L;
        var c = 1f;
        var d = 0b1001;
        System.out.println(Utils.getClassName(a) + ": " + a);
        System.out.println(Utils.getClassName(a) + ": " + b);
        System.out.println(Utils.getClassName(a) + ": " + c);
        System.out.println(Utils.getClassName(a) + ": " + d);
    }

    static void floatDemo() {
        // float-point type
        // float, 4 bytes
        float f_a = 0.12f; // 以f或F为后缀的浮点数字面量为float类型, 否则则为double类型
        System.out.println(f_a);

        // double, 8 bytes
        double d_a = 0.1_23d; // 以d或D为后缀的浮点数字面量为double类型, 即便不加也默认为double类型
        System.out.println(d_a);
        // 可以使用16进制表示浮点数字面量
        double d_b = 0x1.0p-3; // p表示基数为2, -3为指数, 为十进制, 1.0为尾数, 为16进制
        System.out.println(d_b);

        // 三个特殊的浮点数值
        System.out.println(Double.POSITIVE_INFINITY); // 1.0/0.0
        System.out.println(Double.NaN); // 0.0/0.0
        System.out.println(Double.NEGATIVE_INFINITY); // -1.0/0.0

        System.out.println(Double.isNaN(0.0 / 0.0));
        System.out.println(Double.NaN == 0.0 / 0.0);
    }

    static void charDemo() {
        // char, 2 bytes, '\u0000'~'\uffff', utf-16
        // 整个文件的Unicode字符会在解析代码之前会被转换为对应的字符
        // 注释中的Unicode字符, 也会被转换, 在编译时, 可能会造成意外结果
        char char_a = '\u005B';
        char char_b = '\u005D';
        System.out.print(char_a);
        System.out.print(char_b);

        char char_c = '\n';
        System.out.print(char_c);

        char char_d = 'd';
        System.out.print(char_d);
    }

    static void booleanDemo() {
        // Boolean, 1 byte
        boolean boolean_a = true;
        System.out.println(boolean_a);
        System.out.println(boolean_a == true);

        boolean boolean_b = true;
        System.out.println(boolean_b = false);
        if (boolean_b = true) { // 赋值表达式的返回值为被赋值变量, 且其他类型变量无法直接转换为 boolean 类型
            System.out.println(boolean_b);
        }

//        int a = 1;
//        if (a = 2) { // 赋值表达式的返回值为被赋值变量, 且其他类型变量无法直接转换为 boolean 类型
//            System.out.println(a);
//        }
    }

    static void basicTypeCastDemo() {
        double x = 9.99;
        System.out.println((int) x); // 浮点型强制转换为整型时, 会截断10进制小数点后的数值

        // 二元运算符数据类型转换规则, 按先后排序
        // 1. 如果两个操作数, 其中一个是 double, 那么另外一个操作数会被强制转换为 double
        System.out.println(Utils.getClassName(1.0d + 2) + ": " + (1.0d + 2));
        // 2. 否则, 如果其中一个是 float, 另外一个会被强制转换为 float
        System.out.println(Utils.getClassName(1.0f + 2) + ": " + (1.0f + 2));
        // 在整型强制转换为浮点型时, 如果超出浮点型的可表示范围, 则会丢失精度, 如 int 转换为 float
        System.out.println(Utils.getClassName(1.0f + 123456789) + ": " + (1.0f + 123456789));
        // 3. 否则, 如果其中一个操作数是 long, 另外一个会被强制转换为 long 类型
        System.out.println(Utils.getClassName(1L + 2) + ": " + (1L + 2));
        // 4. 否则, 两个操作数都会被强制转换为 int 类型
        System.out.println(Utils.getClassName(1 + 0b10) + ": " + (1 + 0b10));
    }

    // 转义序列可以在字符或字符串字面量之外使用, 也是可以通过编译的, 但IDE无法识别语法
    // public static void main(String\u005B\u005D args){}
    public static void main(String[] args) {
//        integerDemo();
//        floatDemo();
//        charDemo();
//        booleanDemo();
        basicTypeCastDemo();
    }
}


