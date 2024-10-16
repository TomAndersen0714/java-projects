package library.util;

import java.util.Random;

/**
 * {@link java.util.Random}
 */
public class RandomAPI {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        // nextInt
        System.out.println(randomGenerator.nextInt());
        // nextInt(int bound), range from 1 to bound
        System.out.println(randomGenerator.nextInt(100));

        // nextDouble
        System.out.println(randomGenerator.nextDouble());
    }
}
