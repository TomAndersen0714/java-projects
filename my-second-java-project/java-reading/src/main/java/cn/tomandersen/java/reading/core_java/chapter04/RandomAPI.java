package cn.tomandersen.java.reading.core_java.chapter04;

import java.util.Random;

/**
 * {@link java.util.Random}
 */
public class RandomAPI {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        // nextInt
        System.out.println(randomGenerator.nextInt());
        System.out.println(randomGenerator.nextInt(100));

        // nextDouble
        System.out.println(randomGenerator.nextDouble());
    }
}
