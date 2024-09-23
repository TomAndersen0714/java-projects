package lesson3.io.io_stream;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author TomAndersen
 */
public class StdIODemo {

    static void stdinReaderDemo() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // read a line from stdin
        try {
            System.out.println("bufferedReader.readLine() = " + bufferedReader.readLine());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void stdinScannerDemo() {
        Scanner input = new Scanner(System.in);

        // get first input
        System.out.println("What is your name? ");
        String name = input.nextLine();

        // get second input
        System.out.println("How old are you? ");
        // 将输入的下一个单词(以空白符作为分隔)字符串, 转换为 int 类型
        int age = input.nextInt();

        // print the input on console
        System.out.println("Hello " + name + ". Next year, you'll be " + (age + 1) + ". ");

        // 判断后续是否还有内容
        // 此方法会阻塞, 直到 Scanner 中出现新的内容, 然后此方法会返回 true
        System.out.println(input.hasNext());

        // 此方法的执行过程, 并非 hasNext 的字面含义, 且不能用于判断 Scanner 是否为空, 建议永远不要使用此方法
        // 建议用 hasNext(String str), 依靠特殊字符, 来标识 Scanner 停止输入
        String sign = "#";
        System.out.println(input.hasNext(sign));
        while (!input.hasNext(sign)) {
            System.out.println(input.next());
        }
    }

    static void stdinConsoleDemo() {
        // 能否调用成功, 取决于对应的系统是否支持控制台窗口, 如果不支持, 则会抛出异常
        Console cons = System.console();
        String username = cons.readLine("Please input your username: ");
        char[] password = cons.readPassword("Password: ");
        System.out.println("username: " + username + "password: " + password);
    }

    static void stdinDemo() {
        stdinReaderDemo();
        stdinScannerDemo();
        stdinConsoleDemo();
    }

    static void stdoutDemo() {
        String name = "TomAndersen";
        int age = 25;
        System.out.printf("Hello, %s. Next year, you'll be %d\n", name, age);

        double x = 10000.0 / 3.0;
        // %最后的字母f, 代表输出格式为定点浮点数, 小数点前代表输出位数, 小数点后代表精度
        System.out.printf("%8.2f\n", x);
        // %最后的字母e, 代表输出格式为定点浮点数
        System.out.printf("%8.2e\n", x);
        // %最后的字母s, 代表输出格式为字符串
        // 可以使用 %s 模式格式化任意对象, 会优先调用输入对象的 Formattable 接口的 formatTo 方法
        // 否则直接调用输入对象的 toString 方法
        System.out.printf("%s\n", x);

        System.out.println("Hello world! I am back from the Hell!");
    }


    public static void main(String[] args) {
        stdinDemo();
        stdoutDemo();
    }
}

