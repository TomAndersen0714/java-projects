package api.java.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * {@link java.util.Arrays}
 */
public class ArraysAPI {
    public static void main(String[] args) {

        // toString()
        System.out.println("Arrays.toString(): ");
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        // Arrays.toString only support to concat one dimension array

        // deepToString()
        System.out.println("Arrays.deepToString(): ");
        int[][] nums1 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(nums1));
        int[][][] nums2 = new int[][][]{{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}}};
        System.out.println(Arrays.deepToString(nums2));
        // Arrays.deepToString support to print multi-dimension array, but not single dimension array


        // sort()
        System.out.println("Arrays.sort(): ");
        nums = new int[]{1, 3, 2, 4};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        // copy()
        System.out.println("Arrays.copy(): ");
        int[] a = Arrays.copyOf(nums, 2);
        System.out.println(Arrays.toString(a));
        a = Arrays.copyOfRange(nums, 1, 2);
        System.out.println(Arrays.toString(a));

        // search()
        System.out.println("Arrays.search(): ");
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 4}, 3));

        // fill()
        System.out.println("Arrays.fill(): ");
        nums = new int[10];
        Arrays.fill(nums, 2);
        Arrays.fill(nums, 1, 2, 1); // not include the end index
        System.out.println(Arrays.toString(nums));

        // compare()
        System.out.println("Arrays.compare(): ");
        System.out.println(Arrays.equals(nums, new int[]{1, 2, 3, 4}));
        nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.equals(nums, new int[]{1, 2, 3, 4}));

        // equals()
        System.out.println("Arrays.equals(): ");
        System.out.println(Arrays.equals(new int[]{1, 2, 3}, new int[]{1, 2, 3}));

        // deepEquals()
        System.out.println("Arrays.deepEquals(): ");
        System.out.println(
            Arrays.deepEquals(new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{1, 2, 3}, {4, 5, 6}})
        );

        // setAll()
        System.out.println("Arrays.setAll(): ");
        Arrays.setAll(nums, (i) -> i + 3);
        System.out.println(Arrays.toString(nums));

        // hashCode()
        System.out.println("Arrays.hashCode(): ");
        System.out.println(Arrays.hashCode(new int[]{1, 2, 3}));

        // asList()
        System.out.println("Arrays.asList(): ");
        List<Integer> numList = Arrays.asList(1, 2, 3, 4);
        System.out.println(numList);

        // convert variable from int[] type into Integer[]
        Integer[] integers = new Integer[nums.length];
        final int[] finalNums = nums;
        Arrays.setAll(integers, (i) -> finalNums[i]);


    }
}
