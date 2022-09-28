package cn.tomandersen.java.reading.core_java.chapter03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * {@link java.util.Arrays}
 */
public class ArraysAPI {
    public static void main(String[] args) {

        // toString
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        // Arrays.toString only support to concat one dimension array

        // deepToString
        int[][] nums1 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(nums1));
        int[][][] nums2 = new int[][][]{{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}}};
        System.out.println(Arrays.deepToString(nums2));
        // Arrays.deepToString support to print multi-dimension array, but not single dimension array


        // sort
        nums = new int[]{1, 3, 2, 4};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        // copy
        int[] a = Arrays.copyOf(nums, 2);
        System.out.println(Arrays.toString(a));
        a = Arrays.copyOfRange(nums, 1, 2);
        System.out.println(Arrays.toString(a));

        // search
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 4}, 3));

        // fill
        nums = new int[10];
        Arrays.fill(nums, 2);
        Arrays.fill(nums, 1, 2, 1); // not include the end index
        System.out.println(Arrays.toString(nums));

        // compare
        System.out.println(Arrays.equals(nums, new int[]{1, 2, 3, 4}));
        nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.equals(nums, new int[]{1, 2, 3, 4}));

        // equals
        System.out.println(Arrays.equals(new int[]{1, 2, 3}, new int[]{1, 2, 3}));

        // deepEquals
        System.out.println(
                Arrays.deepEquals(new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{1, 2, 3}, {4, 5, 6}})
        );

        // convert variable from int[] type into Integer[]
        Integer[] integers = new Integer[nums.length];
        final int[] finalNums = nums;
        Arrays.setAll(integers, (i) -> finalNums[i]);

        // hashCode
        System.out.println(Arrays.hashCode(new int[]{1, 2, 3}));
    }
}
