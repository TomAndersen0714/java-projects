package cn.tomandersen.java.core_java.chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysAPI {

    /**
     * This program demonstrates array manipulation
     *
     * @author Tom Andersen
     */
    static void LotteryDrawing() {
        Scanner in = new Scanner(System.in);

        System.out.println("What is the biggest number you can draw? ");
        int n = in.nextInt();

        System.out.println("How many numbers do you need to draw? ");
        int k = in.nextInt();

        // create an array, and fill the array with numbers of a ascending sequence which start from 1
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        // draw k numbers and put them into a result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // generate a random index in [0, n-1)
            int idx = (int) (Math.random() * n);

            // pick the element at the random location
            result[i] = nums[idx];

            // move the last element into the random location
            nums[idx] = nums[n - 1];
            n--;
        }
        // print the result array
        Arrays.sort(result);
        System.out.println("Bet the following combination, it'll make you rich!");
//        for (int num : nums) {
//            System.out.println(num);
//        }
        System.out.println(Arrays.toString(nums));
    }

    static void ArrayAPIDemo() {
        // java.utils.Arrays API
        // toString
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        // Arrays.toString only support to concat one dimension array

        // deepToString
        // Arrays.deepToString can support to concat multi-dimension array, but not one dimension
        int[][] nums1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(Arrays.deepToString(nums1));
        int[][][] nums2 = new int[][][]{
                {{1, 2, 3}, {4, 5, 6}},
                {{7, 8, 9}}
        };
        System.out.println(Arrays.deepToString(nums2));


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
    }

    public static void main(String[] args) {
        ArrayAPIDemo();
//        LotteryDrawing();
    }
}
