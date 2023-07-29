package algorithm.practice.leetcode;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array:
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * <p>
 * tags: medium, array, two pointers, binary search
 *
 * @author TomAndersen
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        // exclude boundary situation
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        // binary search
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                break;
            }
        }

        // return result
        if (nums[mid] == target) {
            left = right = mid;
            while (left - 1 >= 0 && nums[left - 1] == target) {
                left -= 1;
            }
            while (right + 1 < nums.length && nums[right + 1] == target) {
                right += 1;

            }
            return new int[]{left, right};
        }
        else {
            return new int[]{-1, -1};
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new LeetCode34().searchRange(new int[]{}, 0)));
    }
}
