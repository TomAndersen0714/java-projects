package pat.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author TomAndersen
 */
public class PAT_1005_2 {
    public static void main(String[] args) throws IOException {
        // input, filter and store
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int l = Integer.parseInt(inputs[1]);
        int h = Integer.parseInt(inputs[2]);

        int[][] members = new int[n][];
        int count = 0;
        for (int i = 0; i < n; i++) {
            inputs = bf.readLine().split(" ");
            int num = Integer.parseInt(inputs[0]);
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);

            if (a >= l && b >= l) {
                members[count] = new int[]{num, a, b};
                count += 1;
            }
        }

        // sort
        Arrays.sort(members, 0, count, (x, y) -> {
            int scoreX = level(x[1], x[2], h) * 10000 + (x[1] + x[2]) * 100 + x[1];
            int scoreY = level(y[1], y[2], h) * 10000 + (y[1] + y[2]) * 100 + y[1];
            if (scoreX != scoreY) {
                return scoreY - scoreX;
            }
            else return x[0] - y[0];
        });

        // print
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(members[i][0] + " " + members[i][1] + " " + members[i][2]);
        }
    }

    private static int level(int x, int y, int h) {
        if (x >= h && y >= h) return 4;
        else if (x >= h) return 3;
        else if (x >= y) return 2;
        else return 1;
    }
}
