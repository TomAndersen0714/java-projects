package problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author TomAndersen
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // read stdin
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numsStr = bufferedReader.readLine().split(",");
        int m = Integer.parseInt(numsStr[0]);
        int n = Integer.parseInt(numsStr[1]);
        int x1 = Integer.parseInt(numsStr[2]);
        int y1 = Integer.parseInt(numsStr[3]);
        int x2 = Integer.parseInt(numsStr[4]);
        int y2 = Integer.parseInt(numsStr[5]);

        if (m <= 0 || n <= 0) {
            System.out.println(0);
            return;
        }

        // bfs iteration
        boolean[][] isVisited = new boolean[m][n];
        int counter = 0, size = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        // initialize queue and assistant array
        if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n) {
            queue.offer(new int[]{x1, y1});
            isVisited[x1][y1] = true;
        }
        if (x2 >= 0 && x2 < m && y2 >= 0 && y2 < n) {
            queue.offer(new int[]{x2, y2});
            isVisited[x2][y2] = true;
        }

        // bfs iterate using queue
        boolean isUpdated = false;
        size = queue.size();

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            // iterate next level
            for (int[] direction : directions) {
                int x = point[0] + direction[0];
                int y = point[1] + direction[1];

                if (x >= 0 && x < m && y >= 0 && y < n && !isVisited[x][y]) {
                    isVisited[x][y] = true;
                    queue.offer(new int[]{x, y});
                    isUpdated = true;
                }
            }

            size -= 1;
            // if current level is finished
            if (size == 0 && isUpdated) {
                counter += 1;
                size = queue.size();
                isUpdated = false;
            }
        }

        // output
        System.out.print(counter);
    }
}
