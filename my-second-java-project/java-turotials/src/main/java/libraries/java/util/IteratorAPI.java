package libraries.java.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TomAndersen
 */
public interface IteratorAPI {
    public static void main(String[] args) {
        // construct
        List<String> names = new LinkedList<>(List.of("Tom", "John", "Alise"));
        Iterator<String> iterator = names.iterator();
        System.out.println("names = " + names);

        // 1. hasNext()
        // returns true if the iteration has more elements
        System.out.println("java.util.Iterator.hasNext: " + iterator.hasNext());

        // 2. next()
        // returns the next element in the iteration
        System.out.println("java.util.Iterator.next: " + iterator.next());

        // 3. remove()
        // removes the last element returned by iterator#next() from the underlying collection
        System.out.println("java.util.Iterator.remove: ");
        iterator.remove();
        for (String name : names) {
            System.out.println(name);
        }

        // 4. forEachRemaining()
        System.out.println("java.util.Iterator.forEachRemaining: ");
        iterator.forEachRemaining(name -> {
            System.out.println(name);
        });
    }
}
