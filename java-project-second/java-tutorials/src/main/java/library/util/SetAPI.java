package library.util;

import java.util.Arrays;
import java.util.Set;

/**
 * @author TomAndersen
 * @see java.util.Set
 * @see java.util.SortedSet
 * @see java.util.TreeSet
 * @see java.util.HashSet
 * @see java.util.LinkedHashSet
 */
public interface SetAPI {
    /**
     * @param args
     * @see CollectionAPI
     * @see SortedSetAPI
     */
    public static void main(String[] args) {

        // of()
        Set<String> nameSet = Set.of("Tom", "Alise", "Jim");
        System.out.println("nameSet = " + nameSet);

        // copyOf()
        Set<String> stringSet = Set.copyOf(nameSet);
        System.out.println("stringSet = " + stringSet);

        // toArray()
        System.out.println(Arrays.toString(stringSet.toArray()));
        // toArray(T[])
        String[] array = stringSet.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }
}
