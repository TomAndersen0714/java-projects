package leetcode.one;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II: https://leetcode.com/problems/spiral-matrix-ii/
 * <p>
 * tags: medium, array
 *
 * @author TomAndersen
 */
public class LeetCode59 {
}

/**
 * brute force + direction array + state cache + counter
 * TC: O(n), SC: O(n)
 */
class LeetCode59_1 {
    public int[][] generateMatrix(int n) {
        // exclude boundary situation
        if (n <= 0) {
            return new int[][]{};
        }

        // iterate using direction array, counter and state cache
        int[][] matrix = new int[n][n];
        int counter = 1;
        // initial position and direction array
        int x = 0, y = -1;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] isVisited = new boolean[n][n];

        while (counter <= n * n) {
            for (int[] direction : directions) {
                int p = x + direction[0], q = y + direction[1];
                // if next step is satisfied, then move and update
                while (p >= 0 && p < n && q >= 0 && q < n && !isVisited[p][q]) {
                    x = p;
                    y = q;
                    matrix[x][y] = counter;
                    isVisited[x][y] = true;

                    counter += 1;
                    p = x + direction[0];
                    q = y + direction[1];
                }
            }
        }


        // return
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepEquals(new LeetCode59_1().generateMatrix(3), new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));
        System.out.println(Arrays.deepEquals(new LeetCode59_1().generateMatrix(1), new int[][]{{1}}));

    }
}
