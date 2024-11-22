package leetcode.second.medium;

import leetcode.common.Util;

import java.util.Arrays;

/**
 * 45. Jump Game II，跳跃游戏2
 * https://leetcode.com/problems/jump-game-ii/description/?envType=problem-list-v2&envId=greedy
 * It's guaranteed that you can reach nums[n - 1].
 */
public class LeetCode45 {
    public static void main(String[] args) {
        int[] nums;
        int output;

        nums = Util.strToArray("[2,3,1,1,4]");
        output = 2;
        System.out.println(new LeetCode45_1().jump(nums) == output);

        nums = Util.strToArray("[2,3,0,1,4]");
        output = 2;
        System.out.println(new LeetCode45_1().jump(nums) == output);

        nums = Util.strToArray("[2,3,1,1,4]");
        output = 2;
        System.out.println(new LeetCode45_2().jump(nums) == output);

        nums = Util.strToArray("[2,3,0,1,4]");
        output = 2;
        System.out.println(new LeetCode45_2().jump(nums) == output);

        nums = Util.strToArray("[2,1]");
        output = 1;
        System.out.println(new LeetCode45_2().jump(nums) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode45_1 {
    public int jump(int[] nums) {
        // input
        if (nums == null) {
            return -1;
        }
        if (nums.length <= 1) {
            return 0;
        }

        // transform
        int minimum = 0;

        // state array, dp[i] means the minimum steps to the end index
        // state equation, dp[i] = min { dp[i+j] + 1 for 0<j<nums[i] }  if i + nums[i] < nums.length - 1, else dp[i] = 1;
        int[] dp = new int[nums.length];

        // initialize the state array
        // dp[nums.length - 1] = 0;
        Arrays.fill(dp, 0, nums.length - 1, Integer.MAX_VALUE - 1);

        // iterate and fill state array
        for (int i = nums.length - 2; i >= 0; i -= 1) {
            if (i + nums[i] >= nums.length - 1) {
                dp[i] = 1;
            }
            else {
                for (int j = 1; j <= nums[i]; j += 1) {
                    dp[i] = Math.min(dp[i], dp[i + j] + 1);
                }
            }
        }

        // output
        minimum = dp[0];
        return minimum;
    }
}


/**
 * Two pointers + Greedy
 */
class LeetCode45_2 {
    public int jump(int[] nums) {
        // input
        if (nums == null) {
            return -1;
        }
        if (nums.length <= 1) {
            return 0;
        }

        // transform
        // It's guaranteed that you can reach nums[n - 1].
        int curStepMaxAccess = nums[0], nextStepMaxAccess = 0;
        int minimumSteps = 1;
        for (int i = 1; i < nums.length - 1; i += 1) {
            nextStepMaxAccess = Math.max(nextStepMaxAccess, i + nums[i]);
            if (i == curStepMaxAccess) {
                minimumSteps += 1;
                curStepMaxAccess = nextStepMaxAccess;
            }
        }

        // output
        return minimumSteps;
    }
}
