package cn.tomandersen.java.reading.core_java.chapter09;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * {@link java.util.Iterator}
 */
public class IteratorAPI {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Tom");
        names.add("Alise");
        names.add("John");

        // get iterator using Iterable interface API
        Iterator<String> arrayListIterator = names.iterator();

        // 1. hasNext()
        // returns true if the iteration has more elements
        System.out.println("java.util.Iterator.hasNext: " + arrayListIterator.hasNext());

        // 2. next()
        // returns the next element in the iteration
        System.out.println("java.util.Iterator.next: " + arrayListIterator.next());

        // 3. remove()
        // removes the last element returned by iterator#next() from the underlying collection
        System.out.println("java.util.Iterator.remove: ");
        arrayListIterator.remove();
        for (String name : names) {
            System.out.println(name);
        }

        // 4. forEachRemaining()
        System.out.println("java.util.Iterator.forEachRemaining: ");
        arrayListIterator.forEachRemaining(name -> {
            System.out.println(name);
        });
    }
}
