package leetcode.second.medium;

import leetcode.common.Util;

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/description
 *
 * @author TomAndersen
 */
public class LeetCode63 {
    public static void main(String[] args) {
        int[][] input;
        int output;

        input = Util.strToArrayArray("[[0,0,0],[0,1,0],[0,0,0]]");
        output = 2;
        System.out.println(new LeetCode63_1().uniquePathsWithObstacles(input) == output);

        input = Util.strToArrayArray("[[0,1],[0,0]]");
        output = 1;
        System.out.println(new LeetCode63_1().uniquePathsWithObstacles(input) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode63_1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // input
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // transform
        int res = 0;
        // state transform equation, dp[i][j] = dp[i+1][j] if grid[i+1][j]!=1 + dp[i][j+1] if grid[i][j+1]!=1
        int rows = obstacleGrid.length, columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];

        // initialize dp array in boundary situations
        dp[rows - 1][columns - 1] = 1 - obstacleGrid[rows - 1][columns - 1];
        for (int j = columns - 2; j >= 0; j -= 1) {
            dp[rows - 1][j] = (1 - obstacleGrid[rows - 1][j]) * dp[rows - 1][j + 1];
        }
        for (int i = rows - 2; i >= 0; i -= 1) {
            dp[i][columns - 1] = (1 - obstacleGrid[i][columns - 1]) * dp[i + 1][columns - 1];
        }

        // iterate and fill dp array
        for (int i = rows - 2; i >= 0; i -= 1) {
            for (int j = columns - 2; j >= 0; j -= 1) {
                dp[i][j] = (1 - obstacleGrid[i][j]) * (dp[i + 1][j] + dp[i][j + 1]);
            }
        }

        // output
        res = dp[0][0];
        return res;
    }
}
