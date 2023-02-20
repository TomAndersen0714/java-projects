package libraries.java.lang;

import java.util.Arrays;
import java.util.Date;

/**
 * {@link java.lang.String}
 */
public class StringAPI {

    public static void main(String[] args) {

        // String Object
        // Java 中的字符串对象(String)是不可变的(immutable)
        String a = "Java\u2122";
        System.out.println(a);

        // String Object API
        // new
        String greeting = new String("\uD83D\uDE00Hello world!");
        System.out.println(greeting);

        // compareTo
        // 按照字典计算字符串编码差值, 如果返回负数, 则代表前者在后者之前;
        // 如果返回正数, 则代表前者在后者之后; 如果返回0, 则代表两字符串内容完全相同
        System.out.println(greeting.compareTo("Hello world!") >= 0);
        // equals
        // 判断两字符串内容是否相同
        System.out.println(greeting.equals("Hello world!"));
        // equalsIgnoreCase
        // 判断两字符串内容是否相同, 忽略大小写
        System.out.println(greeting.equalsIgnoreCase("Hello world!"));

        // startsWith
        System.out.println(greeting.startsWith("\uD83D\uDE00"));
        // endsWith
        System.out.println(greeting.endsWith("world!"));

        // isEmpty
        // 判断字符串是否为空
        System.out.println(greeting.isEmpty());
        // isBlank
        // 判断字符串是否是由空格或空白符组成
        System.out.println(greeting.isBlank());

        // indexOf
        // 返回子串首次出现的位置
        System.out.println(greeting.indexOf("Hello"));
        // lastIndexOf
        // 返回子串首次出现的位置
        System.out.println(greeting.lastIndexOf("Hello"));
        // charAt
        // return the code unit at index 0, 2 bytes
        System.out.println(greeting.charAt(0));

        // length
        // 返回代码单元(code unit)的个数, 即char数组的长度
        System.out.println(greeting.length());
        // PS: 并不等价于Unicode字符的个数, 因为很多Unicode字符需要使用多个代码单元(code unit)来表示, 如 😀

        // replace
        // 返回一个新字符串, 并进行字符串替换
        System.out.println(greeting.replace(" world", ""));
        // substring
        // 返回一个新字符串, 并进行截取
        System.out.println(greeting.substring(2));
        System.out.println(greeting.substring(2, 6));

        // toLowerCase
        System.out.println(greeting.toLowerCase());
        // toUpperCase
        System.out.println(greeting.toUpperCase());

        // strip
        // 清除首尾的空白符
        System.out.println(greeting.strip());
        // stripLeading
        System.out.println(greeting.stripLeading());
        // stripTrailing
        System.out.println(greeting.stripTrailing());

        // repeat
        // 字符串重复指定次数
        System.out.println(greeting.repeat(3));

        // String.valueOf, 基础数据类型转换为字符串
        System.out.println(String.valueOf(123L));
        System.out.println(String.valueOf(1.2D));
        System.out.println(String.valueOf(1.2F));
        System.out.println(String.valueOf(0x1.0p-3));
        System.out.println(String.valueOf(0x1F));

        System.out.println(Arrays.toString("Hello, world".split(" ")));

        // String Class API
        // String.format, 和 printf 功能类似
        // 格式化生成字符串
        double f = 0.9 + 0.1;
        System.out.println(String.format("%.2f", f)); // 格式化数值
        Date date = new Date();
        System.out.println(String.format("%tF", date)); // 格式化日期

        // String.join
        // 使用指定字符串, 拼接多个字符串
        System.out.println(String.join(", ", "Hello", "world!"));

        // String.copyValueOf
        // 复制字符数组, 生成对应字符串
        System.out.println(String.copyValueOf("Hello world".toCharArray(), 0, 5));

    }

}
