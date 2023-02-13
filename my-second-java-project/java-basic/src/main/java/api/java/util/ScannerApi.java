package api.java.util;

import java.util.Scanner;

/**
 * @author TomAndersen
 */
public class ScannerApi {

    public static void main(String[] args) {

        // constructor
        Scanner sc = new Scanner(System.in);

        // next*方法: 将输入流的下一个(以空白符作为分隔)单词, 从字符串类型转换为指定类型并返回其值
        // nextInt
        System.out.println("sc.nextInt() = " + sc.nextInt());
        // nextLong
        System.out.println("sc.nextLong() = " + sc.nextLong());
        // nextBoolean
        System.out.println("sc.nextBoolean() = " + sc.nextBoolean());
    }
}
