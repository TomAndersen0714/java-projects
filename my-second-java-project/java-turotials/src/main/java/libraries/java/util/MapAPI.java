package libraries.java.util;


import java.util.HashMap;
import java.util.Map;

/**
 * @author TomAndersen
 */
public interface MapAPI {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>(4);

        // note: class method
        // of()
        System.out.println("Map.of(\"Tom\", 1, \"Alise\", 2) = " + Map.of("Tom", 1, "Alise", 2));
        // ofEntries()
        // ...

        // note: instance method
        // put
        // Return the previous value associated with key, or null if there was no mapping for key.
        System.out.println("wordCount.put(\"Hello\", 12) = " + wordCount.put("Hello", 12));
        // putAll
        wordCount.putAll(Map.of("Jim", 3, "John", 4));
        System.out.println("wordCount.putAll() = " + wordCount);
        // putIfAbsent()
        // If the specified key is not already associated with a value (or is mapped to null) associates it
        // with the given value and returns null, else returns the current value.
        System.out.println("wordCount.putIfAbsent(\"Tom\", 12) = " + wordCount.putIfAbsent("Tom", 12));
        System.out.println("wordCount.putIfAbsent(\"Tom\", 13) = " + wordCount.putIfAbsent("Tom", 13));
        System.out.println(wordCount);

    }
}
