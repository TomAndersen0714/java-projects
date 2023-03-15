package libraries.java.util;

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
     * @see libraries.java.util.CollectionsAPI
     */
    public static void main(String[] args) {

        // of()
        Set<String> nameSet = Set.of("Tom", "Alise", "Jim");
        System.out.println("nameSet = " + nameSet);

        // copyOf()
        Set<String> stringSet = Set.copyOf(nameSet);
        System.out.println("stringSet = " + stringSet);

    }
}
