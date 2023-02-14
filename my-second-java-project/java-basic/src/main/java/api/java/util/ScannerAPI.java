package api.java.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author TomAndersen
 */
public class ScannerAPI {

    public static void main(String[] args) throws IOException {

        // constructor
        // Scanner(InputStream source)
        Scanner sc = new Scanner(System.in);

        // Scanner(Path source, Charset charset)
        String fileAbsPath = Objects.requireNonNull(ScannerAPI.class.getClassLoader()
            .getResource("test.txt")).getPath();
        System.out.println(fileAbsPath);
        Scanner fileScanner = new Scanner(
            Path.of(fileAbsPath), StandardCharsets.UTF_8
        );


        // next*: 将输入流的下一个(以空白符作为分隔)单词, 从字符串类型转换为指定类型并返回其值
        // nextInt
        System.out.println("sc.nextInt() = " + sc.nextInt());
        // nextLong
        System.out.println("sc.nextLong() = " + sc.nextLong());
        // nextBoolean
        System.out.println("sc.nextBoolean() = " + sc.nextBoolean());


        // hasNext
        System.out.println("sc.hasNext() = " + sc.hasNext());
        // hasNext*: 检测下一个字符序列是否能够转换为对应的值
        System.out.println("sc.hasNextInt() = " + sc.hasNextInt());
        System.out.println("sc.hasNextDouble() = " + sc.hasNextDouble());
    }
}
