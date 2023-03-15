package libraries.java.util;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author TomAndersen
 * @see java.util.Set
 * @see java.util.SortedSet
 * @see java.util.TreeSet
 */
public interface SortedSetAPI {
    public static void main(String[] args) {
        // sortedSet()
        SortedSet<String> sortedSet = new TreeSet<>();
        // sortedSet(Comparator<? super E> comparator)
        SortedSet<String> sortedSet1 = new TreeSet<>(Collections.reverseOrder());

        //

    }
}
