package cn.tomandersen.java.core_java.chapter09;

import java.util.LinkedHashMap;

public class CollectionDemo {
    static void linkedHashMapDemo() {
        LinkedHashMap<String, String> stringLinkedHashMap = new LinkedHashMap<>();
        stringLinkedHashMap.put("name", "Tom Andersen");
        stringLinkedHashMap.clear();
        System.out.println();
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        linkedHashMapDemo();
    }
}
