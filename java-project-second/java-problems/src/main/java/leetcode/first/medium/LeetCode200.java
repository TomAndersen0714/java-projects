package leetcode.first.medium;

import java.util.LinkedList;
import java.util.Queue;

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

        // iteration and visit all points
        int counter = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // depth first search by recursion, i.e. expanding from the boundary of island
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    counter += 1;
                    dfsRecursionVisit(grid, i, j, isVisited);
                }
            }

        }
        // return
        return counter;
    }

    private void dfsRecursionVisit(char[][] grid, int x, int y, boolean[][] isVisited) {
        // exclude boundary situation
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] != '1' || isVisited[x][y]) {
            return;
        }

        // visit specific point
        isVisited[x][y] = true;
        // visit surrounding points
        dfsRecursionVisit(grid, x - 1, y, isVisited);
        dfsRecursionVisit(grid, x + 1, y, isVisited);
        dfsRecursionVisit(grid, x, y - 1, isVisited);
        dfsRecursionVisit(grid, x, y + 1, isVisited);
    }


    public static void main(String[] args) {
        System.out.println(
            new LeetCode200_1().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
            }) == 1
        );
        System.out.println(
            new LeetCode200_1().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
            }) == 3
        );
    }
}


/**
 * BFS
 * TC: O(n), SC: O(n)
 */
class LeetCode200_2 {
    public int numIslands(char[][] grid) {
        // exclude boundary situation
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        // breadth first search
        int counter = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if current point is un-visited point of island
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    // add current point into queue
                    counter += 1;
                    queue.offer(new int[]{i, j});
                    // visit the adjacent points by BFS
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        int x = point[0], y = point[1];
                        if (
                            x >= 0 && x < m && y >= 0 && y < n
                                && !isVisited[x][y] && grid[x][y] == '1'
                        ) {
                            isVisited[x][y] = true;
                            queue.offer(new int[]{x - 1, y});
                            queue.offer(new int[]{x + 1, y});
                            queue.offer(new int[]{x, y - 1});
                            queue.offer(new int[]{x, y + 1});
                        }
                    }
                }
            }

        }

        // return
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(
            new LeetCode200_2().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
            }) == 1
        );
        System.out.println(
            new LeetCode200_2().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
            }) == 3
        );
    }
}
