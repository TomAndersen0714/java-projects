package leetcode.second.easy;

import leetcode.common.Util;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array, 有序数组的平方后排序
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */
public class LeetCode977 {
    public static void main(String[] args) {
        int[] nums;
        int[] output;

        nums = Util.strToArray("[-4,-1,0,3,10]");
        output = Util.strToArray("[0,1,9,16,100]");
        System.out.println(Arrays.equals(new LeetCode977_1().sortedSquares(nums), output));

        nums = Util.strToArray("[-7,-3,2,3,11]");
        output = Util.strToArray("[4,9,9,49,121]");
        System.out.println(Arrays.equals(new LeetCode977_1().sortedSquares(nums), output));
    }
}

/**
 * Two pointers
 */
class LeetCode977_1 {
    public int[] sortedSquares(int[] nums) {
        // input
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        // transform
        // find first non-negative number, i.e. the minimum square
        int cursor = 0, left, right;
        int[] res = new int[nums.length];
        while (cursor < nums.length && nums[cursor] < 0) {
            cursor += 1;
        }

        // if cursor exceed the boundary of nums, move it back
        if (cursor == nums.length) {
            cursor = nums.length - 1;
        }
        // two pointers
        left = cursor - 1;
        right = cursor;
        cursor = 0;

        while (cursor < nums.length) {
            // if right pointer meet the end of nums, then move left pointer
            if (right >= nums.length || (left >= 0 && Math.abs(nums[left]) <= Math.abs(nums[right]))) {
                res[cursor] = nums[left] * nums[left];
                left -= 1;
            }
            // else move the right pointer
            else {
                res[cursor] = nums[right] * nums[right];
                right += 1;
            }
            cursor += 1;
        }

        // output
        return res;
    }
}
