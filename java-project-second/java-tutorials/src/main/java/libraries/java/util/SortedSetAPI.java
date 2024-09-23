package libraries.java.util;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author TomAndersen
 * @see java.util.Set
 * @see java.util.SortedSet
 * @see java.util.TreeSet
 */
public interface SortedSetAPI {
    /**
     * SortedSet is a kind of red-black tree.
     *
     * @param args
     * @see libraries.java.util.SetAPI
     */
    public static void main(String[] args) {
        // sortedSet()
        SortedSet<String> sortedSet = new TreeSet<>(Set.of("Tom", "Alise", "Jim", "Bob"));
        // sortedSet(Comparator<? super E> comparator)
        SortedSet<String> sortedSet1 = new TreeSet<>(Collections.reverseOrder());

        // toString()
        System.out.println("sortedSet = " + sortedSet);

        // first()
        System.out.println("sortedSet.first() = " + sortedSet.first());

        // headSet()
        System.out.println("sortedSet.headSet(\"Tom\") = " + sortedSet.headSet("Tom"));

        // last()
        System.out.println("sortedSet.last() = " + sortedSet.last());

        // tailSet()
        System.out.println("sortedSet.tailSet(\"Jim\") = " + sortedSet.tailSet("Jim"));

        // subSet()
        System.out.println("sortedSet.subSet(\"Bob\",\"Jim\") = " + sortedSet.subSet("Bob", "Jim"));

    }
}
