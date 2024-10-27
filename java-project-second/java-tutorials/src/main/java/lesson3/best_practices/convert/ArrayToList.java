package lesson3.best_practices.convert;

import java.util.Arrays;
import java.util.List;

/**
 * @author TomAndersen
 */
public class ArrayToList {
    public static void main(String[] args) {
        // method1: Arrays.asList(T... a)
        List<int[]> ints = List.of(new int[][]{{1, 2, 3}, {1, 2, 3}});
        System.out.println("ints = " + ints);

        // method2: List.as()
    }
}
