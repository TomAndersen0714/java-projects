package algorithm.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. Spiral Matrix: https://leetcode.com/problems/spiral-matrix/description/
 * <p>
 * tags: medium, array, iterate
 *
 * @author TomAndersen
 */
public class LeetCode54 {
}

/**
 * brute force + direction array + state cache
 * TC: O(n), SC: O(n)
 */
class LeetCode54_1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // exclude boundary condition
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<Integer>();
        }

        // iterate
        int m = matrix.length, n = matrix[0].length, counter = m * n;
        boolean[][] isVisited = new boolean[m][n];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> path = new ArrayList<>();

        // initial position
        int i = 0, j = -1;
        while (counter > 0) {
            for (int[] direction : directions) {
                // next position in current direction
                int p = i + direction[0], q = j + direction[1];

                // if next position is not boundary and not visited, then move and record
                while (p >= 0 && p < m && q >= 0 && q < n && !isVisited[p][q]) {
                    i = p;
                    j = q;
                    isVisited[i][j] = true;
                    path.add(matrix[i][j]);
                    counter -= 1;

                    p = i + direction[0];
                    q = j + direction[1];
                }
            }
        }

        // return
        return path;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new LeetCode54_1().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).toArray(), new Integer[]{1, 2, 3, 6, 9, 8, 7, 4, 5}));
        System.out.println(Arrays.equals(new LeetCode54_1().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}).toArray(), new Integer[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}));
    }
}
