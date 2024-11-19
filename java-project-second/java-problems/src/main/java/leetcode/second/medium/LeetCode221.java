package leetcode.second.medium;

/**
 * 221. Maximal Square, 最大正方形面积
 * https://leetcode.com/problems/maximal-square/description
 * !!!
 */
public class LeetCode221 {
    public static void main(String[] args) {
        char[][] matrix;
        int output;

        matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}};
        output = 4;
        System.out.println(new LeetCode221_1().maximalSquare(matrix) == output);

        matrix = new char[][]{{'0', '1'}, {'1', '0'}};
        output = 1;
        System.out.println(new LeetCode221_1().maximalSquare(matrix) == output);

        matrix = new char[][]{{'0'}};
        output = 0;
        System.out.println(new LeetCode221_1().maximalSquare(matrix) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode221_1 {
    public int maximalSquare(char[][] matrix) {
        // input
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        // transform
        int maxArea = 0;
        // state array, dp[i][j] means the length of the largest square when matrix[i][j] == '1' and it is the right and button corner of the square
        // state equation
        // dp[i][j] = min { dp[i-1][j],dp[i-1][j-1],dp[i][j-1] } + 1 if matrix[i][j] == '1' else 0
        // 通过图形法+穷举法，可以反证此公式，当 dp[i-1][j-1] 为 {dp[i-1][j-1], dp[i][j-1], dp[i-1][j]} 三者中的最小值时，{dp[i][j-1], dp[i-1][j]} 只能等于 dp[i-1][j-1]，或者 dp[i-1][j-1] + 1，而此时 dp[i][j] = dp[i-1][j-1] + 1，同理，当 {dp[i][j-1], dp[i-1][j]} 分别为最小值时，不论其他两个值如何变化，最终从图形上来看 dp[i][j] 都等于最小值+1
        // 图形法，最终也可以转换成方程式，来变成书面语言，只是通过图形来穷举，更形象一些
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];

        // initialize the state array
        for (int i = 0; i < row; i += 1) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxArea = 1;
            }
        }
        for (int j = 0; j < col; j += 1) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                maxArea = 1;
            }
        }

        // iterate and fill state array
        for (int i = 1; i < row; i += 1) {
            for (int j = 1; j < col; j += 1) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                else {
                    dp[i][j] = 0;
                }

                // update the max area
                maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
            }
        }

        // output
        return maxArea;
    }
}
