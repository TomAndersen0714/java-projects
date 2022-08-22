package cn.tomandersen.java.core_java.chapter03;

/**
 * {@link java.lang.String}
 */
public class StringAPI {
    static void stingObj() {
        // String Object
        // Java 中的字符串对象(String)是不可变的(immutable)
        String a = "Java\u2122";
        System.out.println(a);

        // substring
        System.out.println(a.substring(0, 4));

        // concat string
        System.out.println("Hello" + " " + "World!");
    }

    static void stringAPI() {
        // String API
        String greeting = new String("\uD83D\uDE00Hello world!");
        System.out.println(greeting);
        System.out.println(greeting.charAt(0)); // return the code unit at index 0, 2 bytes

        System.out.println(greeting.compareTo("Hello world!") >= 0); // 按照字典计算字符串编码差值,
        // 如果返回负数, 则代表前者在后者之前; 如果返回正数, 则代表前者在后者之后; 如果返回0, 则代表两字符串内容完全相同
        System.out.println(greeting.equals("Hello world!")); // 判断两字符串内容是否相同
        System.out.println(greeting.equalsIgnoreCase("Hello world!")); // 判断两字符串内容是否相同, 忽略大小写

        System.out.println(greeting.startsWith("\uD83D\uDE00"));
        System.out.println(greeting.endsWith("world!"));

        System.out.println(greeting.isEmpty()); // 判断字符串是否为空
        System.out.println(greeting.isBlank()); // 判断字符串是否是由空格或空白符组成

        System.out.println(greeting.indexOf("Hello")); // 返回子串首次出现的位置
        System.out.println(greeting.lastIndexOf("Hello")); // 返回子串首次出现的位置

        System.out.println(greeting.length()); // 返回代码单元(code unit)的个数, 即char数组的长度
        // PS: 并不等价于Unicode字符的个数, 因为很多Unicode字符需要使用多个代码单元(code unit)来表示, 如 😀

        System.out.println(greeting.replace(" world", "")); // 返回一个新字符串, 并进行字符串替换
        System.out.println(greeting.substring(2)); // 返回一个新字符串, 并进行截取
        System.out.println(greeting.substring(2, 6));

        System.out.println(greeting.toLowerCase());
        System.out.println(greeting.toUpperCase());

        // 清除首尾的空白符
        System.out.println(greeting.strip());
        System.out.println(greeting.stripLeading());
        System.out.println(greeting.stripTrailing());

        // 使用指定字符, 拼接多个字符串
        System.out.println(String.join(", ", "Hello", "world!"));
        // 字符串重复指定次数
        System.out.println(greeting.repeat(3));

        // 基础数据类型转换为字符串
        System.out.println(String.valueOf(123L));
        System.out.println(String.valueOf(1.2D));
        System.out.println(String.valueOf(1.2F));
        System.out.println(String.valueOf(0x1.0p-3));
        System.out.println(String.valueOf(0x1F));
    }

    static void stringCompare() {
        // compare string
        String greeting = "Hello";
        System.out.println(greeting.equals("Hello"));
        System.out.println(greeting.compareTo("Hello") == 0);

        // never use '==' to compare string objects, which could return different result according to the specific JVM !
        greeting = new String("Hello");
        System.out.println(greeting.equals("Hello"));
        System.out.println(greeting == "Hello");

        // empty string and null
        if (greeting != null && greeting.length() > 0) {
            System.out.println(greeting);
        }
    }

    static void stringFormatDemo() {
        String name = "Tom Andersen";
        int age = 25;
        System.out.printf("Hello, %s. Next year, you'll be %d\n", name, age);

        double x = 10000.0 / 3.0;
        System.out.printf("%8.2f\n", x);
        System.out.printf("%8.2e\n", x);
    }

    static void stringBuilderDemo() {
        // StringBuilder, applied to single thread
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Hello");
        stringBuilder.append(" ");
        stringBuilder.append("World!");
        stringBuilder.insert(0, "Hi! ");
        stringBuilder.delete(0, 4);
        System.out.println(stringBuilder.toString());

    }

    static void StringBufferDemo() {
        // StringBuffer, applied to multiple thread, a safe Object
        // sample api as StringBuilder
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello");
        stringBuffer.append(" ");
        stringBuffer.append("World!");
        System.out.println(stringBuffer.toString());
    }

    public static void main(String[] args) {
//        stingObj();
//        stringAPI();
//        stringCompare();
        stringBuilderDemo();
        StringBufferDemo();
    }
}
