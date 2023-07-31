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
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // dfs recursion
        int counter = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    counter += 1;
                    dfsRecursionVisit(grid, isVisited, i, j);
                }
            }
        }

        // return
        return counter;
    }

    private void dfsRecursionVisit(char[][] grid, boolean[][] isVisited, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
            && !isVisited[i][j] && grid[i][j] == '1') {
            isVisited[i][j] = true;

            dfsRecursionVisit(grid, isVisited, i + 1, j);
            dfsRecursionVisit(grid, isVisited, i, j + 1);
            dfsRecursionVisit(grid, isVisited, i - 1, j);
            dfsRecursionVisit(grid, isVisited, i, j - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode200_1().numIslands(new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        }) == 1);
        System.out.println(new LeetCode200_1().numIslands(new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        }) == 3);
    }
}
