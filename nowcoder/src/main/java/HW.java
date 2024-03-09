/**
 * @author TomAndersen
 */
public class HW {
    public int landCount(int[][] matrix) {
        // exclude boundary situations
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        // handle
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !isVisited[i][j]) {
                    res += 1;
                    dfsMark(matrix, m, n, isVisited, i, j);
                }
            }
        }

        // return
        return res;
    }

    private void dfsMark(int[][] matrix, int m, int n, boolean[][] isVisited, int x, int y) {
        // exclude boundary situations
        if (x > m - 1 || x < 0 || y > n - 1 || y < 0 || matrix[x][y] != 1 || isVisited[x][y]) {
            return;
        }

        // mark
        isVisited[x][y] = true;

        // dfs recursion
        dfsMark(matrix, m, n, isVisited, x - 1, y);
        dfsMark(matrix, m, n, isVisited, x + 1, y);
        dfsMark(matrix, m, n, isVisited, x, y - 1);
        dfsMark(matrix, m, n, isVisited, x, y + 1);
    }

    public static void main(String[] args) {

    }
}
