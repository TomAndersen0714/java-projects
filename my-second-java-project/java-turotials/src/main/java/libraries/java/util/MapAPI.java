package libraries.java.util;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author TomAndersen
 */
public interface MapAPI {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>(4);

        // note: class method
        // of()
        // Construct a immutable map
        System.out.println("Map.of(\"Tom\", 1, \"Alise\", 2) = " + Map.of("Tom", 1, "Alise", 2));
        // ofEntries()
        System.out.println("Map.ofEntries(Map.of(\"Tom\", 1, \"Alise\", 2).entrySet().toArray(new Map.Entry[0])) = " +
            Map.ofEntries(Map.of("Tom", 1, "Alise", 2).entrySet().toArray(new Map.Entry[0])));
        // copyOf()
        System.out.println("Map.copyOf(Map.of(\"Tom\",1,\"Alise\",3)) = " + Map.copyOf(Map.of("Tom", 1, "Alise", 3)));
        System.out.println();

        // note: instance method
        // put()
        // Return the previous value associated with key, or null if there was no mapping for key.
        System.out.println("wordCount.put(\"Hello\", 12) = " + wordCount.put("Hello", 12));
        // putIfAbsent()
        // If the specified key is not already associated with a value (or is mapped to null) associates it
        // with the given value and returns null, else returns the current value.
        System.out.println("wordCount.putIfAbsent(\"Tom\", 12) = " + wordCount.putIfAbsent("Tom", 12));
        System.out.println("wordCount.putIfAbsent(\"Tom\", 13) = " + wordCount.putIfAbsent("Tom", 13));
        System.out.println(wordCount);
        // putAll
        wordCount.putAll(Map.of("Jim", 3, "John", 4));
        System.out.println("wordCount.putAll() = " + wordCount);
        System.out.println();

        // get()
        // Return the value to which the specified key is mapped, or null if this map contains
        // no mapping for the key
        System.out.println("wordCount.get(\"Tom\") = " + wordCount.get("Tom"));
        System.out.println("wordCount.get(\"Andersen\") = " + wordCount.get("Andersen"));
        // getOrDefault()
        System.out.println("wordCount.getOrDefault(\"Andersen\",24) = " + wordCount.getOrDefault("Andersen", 24));
        System.out.println();

        // remove()
        System.out.println("wordCount.remove(\"Tom\") = " + wordCount.remove("Tom"));
        System.out.println("wordCount.remove(\"Tom\") = " + wordCount.remove("Tom"));
        System.out.println("wordCount = " + wordCount);
        System.out.println();

        // replace()
        // replace if exists
        System.out.println();
        System.out.println("wordCount.replace(\"Tom\", 3) = " + wordCount.replace("Tom", 3));
        System.out.println("wordCount.put(\"Tom\", 1) = " + wordCount.put("Tom", 1));
        System.out.println("wordCount.replace(\"Tom\", 3) = " + wordCount.replace("Tom", 3));
        System.out.println("wordCount = " + wordCount);
        // replaceAll()
        wordCount.replaceAll((key, oldValue) -> {
            Integer newValue = oldValue;
            if (key.startsWith("J")) {
                newValue = 1;
            }
            return newValue;
        });
        System.out.println(wordCount);
        System.out.println();


        // size()
        System.out.println("wordCount.size() = " + wordCount.size());
        System.out.println();


        // keySet()
        // Returns a Set view of the keys contained in this map
        System.out.println("wordCount.keySet() = " + wordCount.keySet());
        // values()
        // Returns a Collection view of the values contained in this map
        System.out.println("wordCount.values() = " + wordCount.values());
        System.out.println();

    }
}
