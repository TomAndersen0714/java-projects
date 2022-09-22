package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 * Spliterator(splitable iterator) is a kind of iterator designed for parallel iteration.
 * {@link java.util.Spliterator}
 */
public class SpliteratorAPI {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");

        // get instance of Spliterator
        Spliterator<String> arrayListSpliterator = names.spliterator();

        // 1. tryAdvance
        // if a remaining element exists, performs the given action on it, returning true;
        // else returns false
        arrayListSpliterator.tryAdvance((x) -> {
            System.out.println(x);
        });

    }
}
