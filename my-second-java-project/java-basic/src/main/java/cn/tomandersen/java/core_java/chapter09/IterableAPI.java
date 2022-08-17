package cn.tomandersen.java.core_java.chapter09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;

public class IterableAPI {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");

        // Iterator()
        Iterator<String> it = names.iterator();

        // forEach()
        names.forEach((name) -> {
            System.out.print(name);
            System.out.println(" ");
        });

        // spliterator()
        Spliterator<String> spliterator = names.spliterator();
        spliterator.forEachRemaining((name) -> {
            System.out.print(name);
            System.out.println(" ");
        });
    }
}
