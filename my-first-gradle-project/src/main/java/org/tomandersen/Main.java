package org.tomandersen;

/**
 * @author TomAndersen
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // 打印所有 Java Properties(包括 VM Options)
        System.out.println("System.getProperties() = " + System.getProperties());

        // 打印所有 classpath
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

    }
}