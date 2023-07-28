package algorithm.practice.leetcode;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array: https://leetcode.com/problems/squares-of-a-sorted-array/
 * <p>
 * tags: easy, array
 *
 * @author TomAndersen
 */
public class LeetCode977 {
}

/**
 * Two pointers
 * TC:O(n), SC:O(n)
 */
class LeetCode977_1 {
    public int[] sortedSquares(int[] nums) {
        // exclude boundary condition
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        // handle
        int[] res = new int[nums.length];
        int cursor = nums.length - 1;
        int left = 0, right = nums.length - 1;

        while (cursor >= 0 && left <= right) {
            int leftAbs = Math.abs(nums[left]), rightAbs = Math.abs(nums[right]);
            if (leftAbs >= rightAbs) {
                res[cursor] = leftAbs * leftAbs;
                cursor -= 1;
                left += 1;
            }
            else {
                res[cursor] = rightAbs * rightAbs;
                cursor -= 1;
                right -= 1;
            }
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new LeetCode977_1().sortedSquares(new int[]{-4, -1, 0, 3, 10}), new int[]{0, 1, 9, 16, 100}));
        System.out.println(Arrays.equals(new LeetCode977_1().sortedSquares(new int[]{-7, -3, 2, 3, 11}), new int[]{4, 9, 9, 49, 121}));
    }
}
