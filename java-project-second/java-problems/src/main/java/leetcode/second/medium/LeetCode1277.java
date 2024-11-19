package leetcode.second.medium;

import leetcode.common.Util;

/**
 * 1277. Count Square Submatrices with All Ones, 统计所有正方形个数
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
 */
public class LeetCode1277 {
    public static void main(String[] args) {
        int[][] matrix;
        int output;

        matrix = Util.strToArrayArray("[[0,1,1,1],[1,1,1,1],[0,1,1,1]]");
        output = 15;
        System.out.println(new LeetCode1277_1().countSquares(matrix) == output);

        matrix = Util.strToArrayArray("[[1,0,1],[1,1,0],[1,1,0]]");
        output = 7;
        System.out.println(new LeetCode1277_1().countSquares(matrix) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode1277_1 {
    public int countSquares(int[][] matrix) {
        // input
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        // transform
        int count = 0;

        // state array, dp[i][j] means the length of side when [i][j] is the right bottom corner of the square, and dp[i][j] also represent the number of squares when [i][j] is the right bottom corner.
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];

        // state transform equation, dp[i][j]
        for (int i = 0; i < row; i += 1) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                count += 1;
            }
        }
        // watch out here, j start from 1 to avoid duplicate count
        for (int j = 1; j < col; j += 1) {
            if (matrix[0][j] == 1) {
                dp[0][j] = 1;
                count += 1;
            }
        }

        // iterate and fill state array
        for (int i = 1; i < row; i += 1) {
            for (int j = 1; j < col; j += 1) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    count += dp[i][j];
                }
            }
        }

        // output
        return count;
    }
}
