package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class CollectionDemo {
    static void linkedHashMapDemo() {
        LinkedHashMap<String, String> stringLinkedHashMap = new LinkedHashMap<>();
        stringLinkedHashMap.put("name", "TomAndersen");
        stringLinkedHashMap.clear();

        System.out.println();
        System.out.println("Hello");
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (var element : stackTraceElements) {
            System.out.println(element.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        linkedHashMapDemo();
    }
}
