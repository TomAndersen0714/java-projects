package utils;

import java.util.Arrays;
import java.util.Random;

public class Utils {
    public static String getClassName(Object o) {
        return o.getClass().toString();
    }

    public static String getCurrentMethodName() {
        // the first element is getStackTrace method, second one is the current method,
        // and the third one is the caller
        return Thread.currentThread().getStackTrace()[2].getClassName()
            + ":" +
            Thread.currentThread().getStackTrace()[2].getMethodName()
            + "()";
    }

    /**
     * Generate a random int array with positive value.
     */
    public static int[] randomArrayInt(int len, int max) {
        if (len <= 0 || max <= 0) return null;

        int[] a = new int[len];
        Random randomGen = new Random();

        for (int i = 0; i < len; i++) {
            a[i] = randomGen.nextInt(max);
        }
        return a;
    }


    public static void main(String[] args) {
        // randomArrayInt
        int[] arrayInt = randomArrayInt(10, 50);
        System.out.println(Arrays.toString(arrayInt));
    }
}
