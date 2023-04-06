package lesson3.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * @author TomAndersen
 */
public class FileIODemo {
    static void fileOutputWriterDemo() throws IOException {
        // 打印用户路径, 默认是 Java MyClass 命令的执行路径
        String userDir = System.getProperty("user.dir");
        System.out.println("user.dir = " + userDir);

        // 写文件
        String fileName = "text/test.txt";
        Path path = Path.of(userDir, fileName);
        String absFileName = path.toString();

        try (PrintWriter writer = new PrintWriter(absFileName, StandardCharsets.UTF_8);) {
            System.out.println("writing " + absFileName);
            writer.println("This is a warning!");
        }
        catch (IOException e) {
            System.out.println("catch block");
            throw e;
        }
        finally {
            System.out.println("finally block");
        }
        System.out.println();

    }

    static void fileInputScannerDemo() throws IOException {
        // 打印用户路径, 默认是 Java MyClass 命令的执行路径
        String userDir = System.getProperty("user.dir");
        System.out.println("user.dir = " + userDir);

        String fileName = "text/test.txt";
        Path path = Path.of(userDir, fileName);
        String absFileName = path.toString();

        // 读文件
        try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8)) {
            System.out.println("reading file: " + absFileName);
            System.out.println("scanner.nextLine() = " + scanner.nextLine());
        }
        catch (IOException e) {
            System.out.println("catch block");
            throw e;
        }
        finally {
            System.out.println("finally block");
        }
    }

    static void fileIODemo() throws IOException {
        fileOutputWriterDemo();
        fileInputScannerDemo();
    }

    public static void main(String[] args) throws IOException {
        fileIODemo();
    }
}
