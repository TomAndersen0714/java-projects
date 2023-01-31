package syntactic_sugar;

// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class TryWithResources {
    public static void main(String[] args) throws IOException {
        // 打印用户路径, 默认是 Java MyClass 命令的执行路径
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);

        // 写文件
        String fileName = "java-basic/src/main/resources/test.txt";
        Path path = Path.of(userDir, fileName);
        String absFileName = path.toString();

        // try-with-Resources, since Java 7
        try (
            PrintWriter writer = new PrintWriter(absFileName, StandardCharsets.UTF_8);
        ) {
            System.out.println("writing " + absFileName);
            writer.println("This is a warning!");
        } catch (IOException e) {
            System.out.println("catch block");
            throw e;
        } finally {
            System.out.println("finally block");
        }
        System.out.println();
        // 在 try-with-Resources 语法中, try 代码块执行完成之后, 便会执行 resources 的 close 方法
        // 即 resources 类必须实现 AutoCloseable 或 Closeable 接口, 以及对应的 close 方法
        // 而之前的 try-catch-finally 语句, 必须在 finally 中手动调用 resource 的 close 方法来
        // 释放资源, 如果 close 方法可能抛出检查型异常(checked exception), 则还需要嵌套一层 try-catch

        // try-with-Resources
        try (
            Scanner scanner = new Scanner(path, StandardCharsets.UTF_8)
        ) {
            System.out.println("reading " + absFileName);
            String line = scanner.nextLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("catch block");
            throw e;
        } finally {
            System.out.println("finally block");
        }
    }
}