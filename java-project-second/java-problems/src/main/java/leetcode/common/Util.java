package leetcode.common;

import java.util.Arrays;
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

    public static void main(String[] args) {
        int[] randomIntArray = randomIntArray(4);
        System.out.println(Arrays.toString(randomIntArray));
    }
}
