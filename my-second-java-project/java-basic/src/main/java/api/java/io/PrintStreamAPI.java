package api.java.io;

/**
 * Core Java, 12E, P59.
 *
 * @see
 * @author TomAndersen
 */
public class PrintStreamAPI {
    public static void main(String[] args) {
        // printf
        // 以百分号 % 开头的字符串被称为格式说明符(format specifiers)
        // 格式说明符的末尾字符, 即转换字符(conversion character), 用于指示要格式成为的数值类型
        String name = "Tom Andersen";
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
}
