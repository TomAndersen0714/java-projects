package algorithm.practice.leetcode;

/**
 * 200. Number of Islands: https://leetcode.com/problems/number-of-islands/
 * <p>
 * tags: medium, array, bfs
 *
 * @author TomAndersen
 */
public class LeetCode200 {
}

/**
 * DFS Recursion
 * TC: O(n), SC: O(n)
 */
class LeetCode200_1 {
    public int numIslands(char[][] grid) {
        // exclude boundary situation
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        // breadth first search
        int counter = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];


        // return
        return counter;
    }


    public static void main(String[] args) {

    }
}
