package leetcode;

import java.util.Arrays;

/**
 * 922. Sort Array By Parity II: https://leetcode.com/problems/sort-array-by-parity-ii/
 * <p>
 * tags: easy, array, sorting
 *
 * @author TomAndersen
 */
public class LeetCode922 {
}

/**
 * Two pointers
 * TC: O(n*n), SC: O(n)
 */
class LeetCode922_1 {
    public int[] sortArrayByParityII(int[] nums) {
        // exclude boundary situation
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        // two pointers
        int length = nums.length;
        int[] res = new int[length];
        int evenPointer = 0, oddPointer = 1;
        while (evenPointer < length || oddPointer < length) {
            // find all even number in even position, util meet first odd num in even position
            while (evenPointer < length && nums[evenPointer] % 2 == 0) {
                res[evenPointer] = nums[evenPointer];
                evenPointer += 2;
            }

            // find all odd number in odd position, util meet first even num in odd position
            while (oddPointer < length && nums[oddPointer] % 2 == 1) {
                res[oddPointer] = nums[oddPointer];
                oddPointer += 2;
            }

            if (evenPointer < length && oddPointer < length) {
                res[evenPointer] = nums[oddPointer];
                res[oddPointer] = nums[evenPointer];

                evenPointer += 2;
                oddPointer += 2;
            }
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode922_1().sortArrayByParityII(new int[]{4, 2, 5, 7})));
        System.out.println(Arrays.toString(new LeetCode922_1().sortArrayByParityII(new int[]{2, 3})));
        System.out.println(Arrays.toString(new LeetCode922_1().sortArrayByParityII(new int[]{1, 2})));
    }
}
