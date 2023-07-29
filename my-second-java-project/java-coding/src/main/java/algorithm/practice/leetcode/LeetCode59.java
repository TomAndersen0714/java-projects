package algorithm.practice.leetcode;

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
 * brute force + direction array + state cache
 */
class LeetCode59_1 {
    public int[][] generateMatrix(int n) {
        // exclude boundary situation
        if (n <= 0) {
            return new int[][]{};
        }

        // iterate using direction array and counter
        int[][] matrix = new int[n][n];

        // return
        return matrix;
    }
}
