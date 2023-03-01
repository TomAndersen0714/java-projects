package lesson2.data_structure;

// https://docs.oracle.com/javase/tutorial/java/data/index.html

import java.util.Arrays;

/**
 * @author TomAndersen
 */
public class Numbers {
    // todo, how to convert int array to Integer array?
    // todo, how to convert string array to Integer array?

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Arrays.stream(new String[]{"111", "222"}).mapToInt(Integer::parseInt).toArray()));
    }
}
