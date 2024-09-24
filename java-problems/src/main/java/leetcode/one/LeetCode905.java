package leetcode.one;

import java.util.Arrays;

/**
 * 905. Sort Array By Parity: https://leetcode.com/problems/sort-array-by-parity/
 * <p>
 * tags: easy, array, sorting
 *
 * @author TomAndersen
 */
public class LeetCode905 {
}


/**
 * Two pointers
 * TC: O(n), SC: O(n)
 */
class LeetCode905_1 {
    public int[] sortArrayByParity(int[] nums) {
        // exclude boundary situation
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        // two pointers
        int length = nums.length;
        int[] res = new int[length];
        int left = 0, right = nums.length - 1;

        // iterate all elements
        while (left <= right) {
            // find the first odd number from left
            while (nums[left] % 2 == 0 && left < right) {
                res[left] = nums[left];
                left += 1;
            }

            // find the first even number from right
            while (nums[right] % 2 == 1 && left < right) {
                res[right] = nums[right];
                right -= 1;
            }

            // put the nums on right place
            res[left] = nums[right];
            res[right] = nums[left];

            left += 1;
            right -= 1;
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode905_1().sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(new LeetCode905_1().sortArrayByParity(new int[]{0})));
    }
}