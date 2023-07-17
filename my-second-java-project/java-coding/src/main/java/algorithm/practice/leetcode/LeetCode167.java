package algorithm.practice.leetcode;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted:
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * tags: medium, array, two pointers
 *
 * @author TomAndersen
 * @see LeetCode1
 */
public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        // exclude boundary condition
        if (numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }

        // handle
        int[] res = new int[]{-1, -1};
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left += 1;
            }
            else if (sum > target) {
                right -= 1;
            }
            else {
                break;
            }
        }

        // return
        res[0] = left + 1;
        res[1] = right + 1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new LeetCode167().twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2}));
        System.out.println(Arrays.equals(new LeetCode167().twoSum(new int[]{2, 3, 4}, 6), new int[]{1, 3}));
        System.out.println(Arrays.equals(new LeetCode167().twoSum(new int[]{-1, 0}, -1), new int[]{1, 2}));
    }
}
