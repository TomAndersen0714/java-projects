package leetcode.second.easy;

import leetcode.common.Util;

import java.util.Arrays;

/**
 * 1099. Two Sum Less Than K
 * https://wentao-shao.gitbook.io/leetcode/two-pointers/1099.two-sum-less-than-k
 * https://leetcode.com/problems/two-sum-less-than-k/description/
 *
 * @author TomAndersen
 */
public class LeetCode1099 {
    public static void main(String[] args) {
        int[] nums;
        int k, expect;

        nums = Util.strToArray("[34,23,1,24,75,33,54,8]");
        k = 60;
        expect = 58;
        System.out.println(new LeetCode1099_1().twoSumLessThanK(nums, k) == expect);

        nums = Util.strToArray("[10,20,30]");
        k = 15;
        expect = -1;
        System.out.println(new LeetCode1099_1().twoSumLessThanK(nums, k) == expect);
    }
}

/**
 * Two pointers
 */
class LeetCode1099_1 {
    public int twoSumLessThanK(int[] a, int k) {
        // input
        if (a == null || a.length < 2) {
            return -1;
        }

        // transform
        Arrays.sort(a);
        int twoSum, left = 0, right = a.length - 1;
        int closestTwoSum = -1;

        while (left < right) {
            twoSum = a[left] + a[right];
            if (twoSum > k) {
                right -= 1;
            }
            else {
                closestTwoSum = Math.max(closestTwoSum, twoSum);
                left += 1;
            }
        }
        // output
        return closestTwoSum;
    }
}
