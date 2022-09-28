package cn.tomandersen.java.reading.core_java.chapter06;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorAPI {
    /**
     * {@link java.util.Comparator}
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 5, 1, 5};
        System.out.println("Arrays.sort(int[]): ");
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        // convert variable from int[] type into Integer[]
        Integer[] integers = new Integer[numbers.length];
        Arrays.setAll(integers, (i) -> numbers[i]);

        System.out.println("Arrays.sort(Integer[], Comparator): ");
        Arrays.sort(integers, new reverseOrder());
        System.out.println(Arrays.toString(integers));

    }
}

class reverseOrder implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
    }
}
