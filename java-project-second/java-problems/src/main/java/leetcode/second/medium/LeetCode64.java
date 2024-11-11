package leetcode.second.medium;

import leetcode.common.Util;

/**
 * 64. Minimum Path Sum, 矩阵左上到右下最小路径之和
 * https://leetcode.com/problems/minimum-path-sum/description
 *
 * @author TomAndersen
 */
public class LeetCode64 {
    public static void main(String[] args) {
        int[][] input;
        int output;

        input = Util.strToArrayArray("[[1,3,1],[1,5,1],[4,2,1]]");
        output = 7;
        System.out.println(new LeetCode64_1().minPathSum(input) == output);

        input = Util.strToArrayArray("[[1,2,3],[4,5,6]]");
        output = 12;
        System.out.println(new LeetCode64_1().minPathSum(input) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode64_1 {
    public int minPathSum(int[][] grid) {
        // input
        if (grid == null || grid.length <= 0) {
            return 0;
        }

        // transform
        int res = 0;
        // state transform equation, dp[i][j] = min{dp[i+1][j], dp[i][j+1]} + grid[i][j]
        int height = grid.length, width = grid[0].length;
        int[][] dp = new int[height][width];

        // initialize the state array in boundary situation
        dp[height - 1][width - 1] = grid[height - 1][width - 1];
        for (int i = height - 2; i >= 0; i -= 1) {
            dp[i][width - 1] = dp[i + 1][width - 1] + grid[i][width - 1];
        }
        for (int j = width - 2; j >= 0; j -= 1) {
            dp[height - 1][j] = dp[height - 1][j + 1] + grid[height - 1][j];
        }

        // iterate and file state array
        for (int i = height - 2; i >= 0; i -= 1) {
            for (int j = width - 2; j >= 0; j -= 1) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }

        // output
        res = dp[0][0];
        return res;
    }
}
