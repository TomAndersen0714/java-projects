package libraries.java.util;


import java.util.HashMap;
import java.util.Map;

/**
 * @author TomAndersen
 * @see java.util.Map
 * @see java.util.HashMap
 */
public class HashMapAPI {
    /**
     * @param args
     * @see libraries.java.util.MapAPI
     */
    public static void main(String[] args) {
        // note: class method
        // HashMap()
        HashMap<String, Integer> map1 = new HashMap<>();

        // HashMap(int initialCapacity)
        HashMap<String, Integer> map2 = new HashMap<>(16);

        // HashMap(int initialCapacity, float loadFactor)
        HashMap<String, Integer> map3 = new HashMap<>(16, 0.25F);

        // HashMap(Map<? extends K, ? extends V> m)
        HashMap<String, Integer> wordCount = new HashMap<>(Map.of("Tom", 1, "Alise", 2));
        System.out.println("wordCount = " + wordCount);
    }
}
