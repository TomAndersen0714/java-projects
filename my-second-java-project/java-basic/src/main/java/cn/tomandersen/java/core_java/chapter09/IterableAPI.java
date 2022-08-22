package cn.tomandersen.java.core_java.chapter09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;

/**
 * {@link java.lang.Iterable}
 */
public class IterableAPI {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");

        // Iterator()
        Iterator<String> it = names.iterator();

        // spliterator(), since JDK 1.8
        Spliterator<String> spliterator = names.spliterator();
        spliterator.forEachRemaining((name) -> {
            System.out.print(name);
            System.out.println(" ");
        });

        // forEach(), since JDK 1.8
        names.forEach((name) -> {
            System.out.print(name);
            System.out.println(" ");
        });
    }
}
