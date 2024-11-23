package leetcode.second.medium;

import leetcode.common.Util;

/**
 * 55. Jump Game, 跳跃游戏
 * https://leetcode.com/problems/jump-game/description/?envType=problem-list-v2&envId=greedy
 */
public class LeetCode55 {
    public static void main(String[] args) {
        int[] nums;
        boolean output;

        nums = Util.strToArray("[2,3,1,1,4]");
        output = true;
        System.out.println(new LeetCode55_1().canJump(nums) == output);

        nums = Util.strToArray("[3,2,1,0,4]");
        output = false;
        System.out.println(new LeetCode55_1().canJump(nums) == output);

        nums = Util.strToArray("[2,3,1,1,4]");
        output = true;
        System.out.println(new LeetCode55_2().canJump(nums) == output);

        nums = Util.strToArray("[3,2,1,0,4]");
        output = false;
        System.out.println(new LeetCode55_2().canJump(nums) == output);

        nums = Util.strToArray("[2,0,0]");
        output = true;
        System.out.println(new LeetCode55_2().canJump(nums) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode55_1 {
    public boolean canJump(int[] nums) {
        // input
        if (nums == null) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }

        // transform
        boolean res = false;
        // state array, dp[i] means if nums[i] can reach the nums[length-1]
        boolean[] dp = new boolean[nums.length];
        // state equation, dp[i] = any { dp[i+j] for 0<j<dp[i] }
        // initialize the state array
        dp[nums.length - 1] = true;

        // iterate and fill state array
        for (int i = nums.length - 2; i >= 0; i -= 1) {
            int step = Math.min(nums[i], nums.length - 1 - i);

            for (int j = 1; j <= step; j += 1) {
                if (dp[i]) {
                    break;
                }
                else {
                    dp[i] = dp[i + j];
                }
            }
        }

        // output
        res = dp[0];
        return res;
    }
}

/**
 * Greedy Cursor
 */
class LeetCode55_2 {
    public boolean canJump(int[] nums) {
        // input
        if (nums == null) {
            return false;
        }
        if (nums.length <= 1) {
            return true;
        }

        // transform
        // state array, nextStepMaxAccess means the max access index from nums[0]
        boolean res = false;
        int nextStepMaxAccess = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            if (i > nextStepMaxAccess) {
                break;
            }
            else {
                nextStepMaxAccess = Math.max(nextStepMaxAccess, i + nums[i]);
                if (nextStepMaxAccess >= nums.length - 1) {
                    res = true;
                    break;
                }
            }
        }

        // output
        return res;
    }
}
