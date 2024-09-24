package leetcode.one;

/**
 * 695. Max Area of Island:
 * https://leetcode.com/problems/max-area-of-island/description/
 * <p>
 * tags: DFS, BFS, Graph
 *
 * @author TomAndersen
 */
public class LeetCode695 {
    public int maxAreaOfIsland(int[][] grid) {
        // boundary situations
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // traverse every point in the grid
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }

        // return
        return maxArea;
    }

    /**
     * return the length of path by depth-first-search
     *
     * @param access
     * @param x
     * @param y
     * @return
     */
    private int dfs(int[][] access, int x, int y) {
        // boundary situations
        if (x < 0 || y < 0 || x >= access.length || y >= access[x].length || access[x][y] == 0) {
            return 0;
        }

        // access
        access[x][y] = 0;

        // traverse adjacent element by depth-first-search
        return 1 + dfs(access, x + 1, y) + dfs(access, x - 1, y) + dfs(access, x, y + 1) + dfs(access, x, y - 1);
    }

}
