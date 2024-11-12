package leetcode.second.medium;

import leetcode.common.Util;

/**
 * 198. House Robber, 抢劫房子
 * https://leetcode.com/problems/house-robber/description
 *
 * @author TomAndersen
 */
public class LeetCode198 {
    public static void main(String[] args) {
        int[] input;
        int output;

        input = Util.strToArray("[1,2,3,1]");
        output = 4;
        System.out.println(new LeetCode198_1().rob(input) == output);

        input = Util.strToArray("[2,7,9,3,1]");
        output = 12;
        System.out.println(new LeetCode198_1().rob(input) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode198_1 {
    public int rob(int[] nums) {
        // input
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // transform
        int res = 0;
        // state transform equation, dp[i] = max{dp[i-1], dp[i-2] + array[i]}
        int[] dp = new int[nums.length];

        // initialize the dp array
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        // iterate dp array and fill array
        for (int i = 2; i < nums.length; i += 1) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // output
        res = dp[nums.length - 1];
        return res;
    }
}
