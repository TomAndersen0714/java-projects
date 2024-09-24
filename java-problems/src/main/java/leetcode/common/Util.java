package leetcode.common;

import java.util.Random;

/**
 * @author TomAndersen
 */
public class Util {
    public static int[] randomIntArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        return array;
    }
}
