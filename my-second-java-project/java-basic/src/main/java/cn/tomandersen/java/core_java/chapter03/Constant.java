package cn.tomandersen.java.core_java.chapter03;

public class Constant {
    static final String a = "Hello, i am a!"; // static 表示此变量能够在同一个 Class 的多个方法中使用
    public static final String b = "Hello, i am b!"; // public 表示此变量能够在不同包不同 Class 任意位置访问

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(Constant.a);
        System.out.println(b);
        System.out.println(Constant.b);
    }
}
