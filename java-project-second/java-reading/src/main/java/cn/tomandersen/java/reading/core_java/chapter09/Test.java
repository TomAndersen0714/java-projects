package cn.tomandersen.java.reading.core_java.chapter09;

import cn.tomandersen.java.reading.utils.Utils;

import java.util.UUID;

/**
 * @author TomAndersen
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}
