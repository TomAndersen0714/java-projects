package cn.tomandersen.java.core_java.chapter09;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorAPI {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");

        // 1. for statement
        System.out.println("This is a for statement iteration demo: ");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // 2. using for-each
        System.out.println("This is a for-each statement iteration demo: ");
        for (String name : names) {
            System.out.println(name);
        }

        // 3. using forEachRemaining method with lambda expression (anonymous method)
        System.out.println("This is a 'forEachRemaining' method demo: ");
        Iterator<String> iterator = names.iterator();
        iterator.forEachRemaining(name -> {
            System.out.println(name);
        });
    }
}
