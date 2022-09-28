package cn.tomandersen.java.reading.core_java.chapter06;

import java.math.BigDecimal;

public class ComparableAPI {
    public static void main(String[] args) {
        BigDecimal m = new BigDecimal("1.0");
        BigDecimal n = new BigDecimal("1.00");
        System.out.println("BigDecimal.equals(): ");
        System.out.println(m.equals(n));
        System.out.println("BigDecimal.compareTo(): ");
        System.out.println(m.compareTo(n));

        String x = "aaa";
        String y = "bbb";
        System.out.println("String.compareTo(): ");
        System.out.println(x.compareTo(y));

        Integer a = 12; // auto boxing
        Integer b = 33;
        System.out.println("Integer.compare(): ");
        System.out.println(Integer.compare(a, b));
    }
}
