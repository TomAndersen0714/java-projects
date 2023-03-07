package libraries.java.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author TomAndersen
 */
public class LinkedHashMapAPI {

    /**
     * @see libraries.java.util.MapAPI
     */
    public static void main(String[] args) {
        // construct
        // 1. Constructs an empty insertion-ordered LinkedHashMap instance with the
        // default initial capacity (16) and load factor (0.75)
        // Note: 默认情况下, 元素依据insertion order排列, 后续的插入也不会影响其元素的排列顺序
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("Tom", 1);
        map.put("John", 2);
        map.put("Alise", 3);
        map.get("Tom");
        System.out.println("map = " + map);
        map.put("Tom", 4);
        System.out.println("map = " + map);


        // 2. Constructs an empty insertion-ordered LinkedHashMap instance with the
        // specified initial capacity and a default load factor (0.75).
        Map<String, Integer> map1 = new LinkedHashMap<>(16);


        // 3. Constructs an empty insertion-ordered LinkedHashMap instance with the
        // specified initial capacity and load factor.
        Map<String, Integer> map2 = new LinkedHashMap<>(16, 0.75f);

        // 4. Constructs an empty LinkedHashMap instance with the specified initial
        // capacity, load factor and ordering mode.
        // Note: 通过在构造时设置accessOrder为true, LinkedHashMap可以被用作LRU Cache结构
        //  即每次访问后, 将被访问的元素置于队尾
        Map<String, Integer> map3 = new LinkedHashMap<>(16, 0.75f, true);
        map3.put("Tom", 1);
        map3.put("Jim", 2);
        map3.put("John", 3);
        map3.get("Tom");
        System.out.println("map3 = " + map3);

    }
}
