package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;

/**
 * {@link java.lang.Iterable}
 */
public class IterableAPI {
    static void IteratorDemo() {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");

        // Iterator
        Iterator<String> it = names.iterator();

    }

    static void IterationDemo() {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");

        // forEach, since JDK 1.8
        names.forEach((name) -> {
            System.out.print(name);
            System.out.println(" ");
        });
    }

    static void SpliteratorDemo() {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");

        // spliterator, since JDK 1.8
        Spliterator<String> spliterator = names.spliterator();
        spliterator.forEachRemaining((name) -> {
            System.out.print(name);
            System.out.println(" ");
        });
    }

    public static void main(String[] args) {
        IteratorDemo();
    }
}
