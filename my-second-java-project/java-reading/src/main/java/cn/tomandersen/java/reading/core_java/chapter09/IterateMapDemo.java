package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.*;

public class IterateMapDemo {
    static void iterateKeyValues() {
        Map<String, String> id_names = new HashMap<>();
        id_names.put("001", "Tom");
        id_names.put("002", "Alise");
        id_names.put("003", "John");

        // 1. entrySet()
        System.out.println("1. entrySet(): ");
        Set<Map.Entry<String, String>> entries = id_names.entrySet();
        // 1.1. using iterator
        Iterator<Map.Entry<String, String>> entryIterator = entries.iterator();
        System.out.println("1.1. using iterator: ");
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
        // 1.2. using for-each statement
        System.out.println("1.2. using for-each statement: ");
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
        // 1.3. using forEach() method of Iterable interface
        System.out.println("1.3. using forEach() method of Iterable interface: ");
        entries.forEach(entry -> {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        });

        // 2. keySet()
        // PS: do not recommend, because it would access twice for every element
        System.out.println("2. keySet(): ");
        Set<String> keySet = id_names.keySet();
        // 2.1. using iterator
        System.out.println("2.1. using iterator: ");
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String k = keyIterator.next();
            String v = id_names.get(k);
            System.out.println("key: " + k + ", value: " + v);
        }
        // 2.2. using for-each statement
        System.out.println("2.2. using for-each statement: ");
        for (String k : keySet) {
            System.out.println("key: " + k + ", value: " + id_names.get(k));
        }
        // 2.3 using forEach() method of Iterable interface
        System.out.println("3.2 using forEach() method of Iterable interface: ");
        keySet.forEach(
                key -> {
                    System.out.println("key: " + key + ", value: " + id_names.get(key));
                }
        );


        // 3. forEach() method with lambda expression
        System.out.println("3. forEach() method with lambda expression: ");
        id_names.forEach(
                (key, value) -> {
                    System.out.println("key: " + key + ", value: " + value);
                }
        );
    }

    static void iterateKeys() {
        Map<String, String> id_names = new HashMap<>();
        id_names.put("001", "Tom");
        id_names.put("002", "Alise");
        id_names.put("003", "John");

        Set<String> keySet = id_names.keySet();

        // 1. using iterator
        System.out.println("1. using iterator: ");
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            System.out.println("key: " + iterator.next());
        }

        // 2. using for-each statement
        System.out.println("2. using for-each statement: ");
        for (String key : keySet) {
            System.out.println("key: " + key);
        }

        // 3. using forEach() method of iterable interface
        System.out.println("3. using forEach() method of iterable interface: ");
        keySet.forEach(
                key -> {
                    System.out.println("key: " + key);
                }
        );

    }

    static void iterateValues() {
        Map<String, String> id_names = new HashMap<>();
        id_names.put("001", "Tom");
        id_names.put("002", "Alise");
        id_names.put("003", "John");
        Collection<String> values = id_names.values();

        // 1. using iterator
        System.out.println("1. using iterator:");
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println("value: " + iterator.next());
        }

        // 2. using for-each statement
        System.out.println("2. using for-each statement: ");
        for (String value : values) {
            System.out.println("value: " + value);
        }

        // 3. using forEach() method
        System.out.println("3. using forEach() method: ");
        values.forEach(
                value -> {
                    System.out.println("value: " + value);
                }
        );


    }

    public static void main(String[] args) {
//        iterateKeyValues();
        iterateKeys();
//        iterateValues();
    }
}
