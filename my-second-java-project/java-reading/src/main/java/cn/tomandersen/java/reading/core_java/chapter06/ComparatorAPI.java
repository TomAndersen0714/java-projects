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
        Arrays.sort(integers, new IntReverseOrderComparator());
        System.out.println(Arrays.toString(integers));


        System.out.println("Arrays.sort(String[], Comparator): ");
        String[] strs = new String[3];
        strs[0] = "Tom";
        strs[1] = "Jim";
        strs[2] = "Alise";
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        Arrays.sort(strs, new StrLengthComparator());
        System.out.println(Arrays.toString(strs));

    }
}

class IntReverseOrderComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
//        return Integer.compare(o2, o1);
        return o2.compareTo(o1);
    }
}

class StrLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
