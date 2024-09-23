package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetAPI {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        // add()
        hashSet.add("Alise");
        hashSet.add("Tom");
        hashSet.add("Tom"); // duplicate element will not be stored
        // toString()
        System.out.println(hashSet);

        // remove()
        hashSet.remove("Alise");
        System.out.println(hashSet);

        // size()
        System.out.println(hashSet.size());

        // iterator()
        Iterator<String> iter = hashSet.iterator();

        // forEach
        hashSet.forEach((x) -> {
            System.out.println(x);
        });


    }
}
