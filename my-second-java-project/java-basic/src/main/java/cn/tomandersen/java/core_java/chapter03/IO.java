package cn.tomandersen.java.core_java.chapter03;

import java.util.Scanner;

public class IO {
    static void ScannerDemo() {
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.println("What is your name? ");
        String name = in.nextLine();

        // get second input
        System.out.println("How old are you? ");
        int age = in.nextInt(); // 将输入的下一个单词(以空白符作为分隔)字符串, 转换为 int 类型

        // print the input on console
        System.out.println("Hello " + name + ". Next year, you'll be " + (age + 1) + ". ");

        // 判断后续是否还有内容
        System.out.println(in.hasNext()); // 此方法会阻塞, 直到 Scanner 中出现新的内容, 然后此方法会返回 true
        // 此方法的执行过程, 并非 hasNext 的字面含义, 且不能用于判断 Scanner 是否为空

        System.out.println(in.hasNext("#")); // 建议用 hasNext(String str), 依靠特殊字符, 来标识 Scanner 停止输入
        while (!in.hasNext("#")) {
            System.out.println(in.next());
        }
    }

    public static void main(String[] args) {
        ScannerDemo();
    }
}
