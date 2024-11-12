package leetcode.second.easy;

/**
 * @author TomAndersen
 */
public class LeetCode70 {
    public static void main(String[] args) {
        int input, output;

        input = 2;
        output = 2;
        System.out.println(new LeetCode70_1().climbStairs(input) == output);

        input = 3;
        output = 3;
        System.out.println(new LeetCode70_1().climbStairs(input) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode70_1 {
    public int climbStairs(int n) {
        // input
        if (n <= 3) {
            return n;
        }

        // transform
        // state transform equation, dp[i] = dp[i-1] + dp[i-2]
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // output
        return dp[n];
    }
}
