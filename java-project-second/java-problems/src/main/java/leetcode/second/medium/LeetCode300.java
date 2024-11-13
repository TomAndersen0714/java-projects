package leetcode.second.medium;

import leetcode.common.Util;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence, 最长递增子序列
 * https://leetcode.com/problems/longest-increasing-subsequence/description
 * https://leetcode.cn/problems/longest-increasing-subsequence/solutions/147667/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti
 *
 * @author TomAndersen
 */
public class LeetCode300 {
    public static void main(String[] args) {
        int[] nums;
        int output;

        nums = Util.strToArray("[10,9,2,5,3,7,101,18]");
        output = 4;
        System.out.println(new LeetCode300_1().lengthOfLIS(nums) == output);

        nums = Util.strToArray("[0,1,0,3,2,3]");
        output = 4;
        System.out.println(new LeetCode300_1().lengthOfLIS(nums) == output);

        nums = Util.strToArray("[7,7,7,7,7,7,7]");
        output = 1;
        System.out.println(new LeetCode300_1().lengthOfLIS(nums) == output);

        nums = Util.strToArray("[1,3,6,7,9,4,10,5,6]");
        output = 6;
        System.out.println(new LeetCode300_1().lengthOfLIS(nums) == output);


        // nums = Util.strToArray("[10,9,2,5,3,7,101,18]");
        // output = 4;
        // System.out.println(new LeetCode300_2().lengthOfLIS(nums) == output);
        //
        // nums = Util.strToArray("[0,1,0,3,2,3]");
        // output = 4;
        // System.out.println(new LeetCode300_2().lengthOfLIS(nums) == output);
        //
        // nums = Util.strToArray("[7,7,7,7,7,7,7]");
        // output = 1;
        // System.out.println(new LeetCode300_2().lengthOfLIS(nums) == output);
        //
        // nums = Util.strToArray("[1,3,6,7,9,4,10,5,6]");
        // output = 6;
        // System.out.println(new LeetCode300_2().lengthOfLIS(nums) == output);
        //
        // nums = Util.strToArray("[3,5,6,2,5,4,19,5,6,7,12]");
        // output = 6;
        // System.out.println(new LeetCode300_2().lengthOfLIS(nums) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode300_1 {
    public int lengthOfLIS(int[] nums) {
        // input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // transform
        int res = 1;
        // 定义 dp[i] 代表，以nums[i]为结尾时的最长递增子序列长度, 则状态转换方程为
        // state transform equation, dp[i] = max { dp[j] if nums[i] < nums[j] for j<i}
        // 而原问题则转换为求解 dp 数组中的最大值
        int[] dp = new int[nums.length];

        // initialize state array
        Arrays.fill(dp, 1);

        // iterate and fill state array
        for (int i = 1; i < nums.length; i += 1) {
            for (int j = 0; j < i; j += 1) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        // output
        return res;
    }
}

/**
 * Greedy + Binary Search
 */
class LeetCode300_2 {
}
