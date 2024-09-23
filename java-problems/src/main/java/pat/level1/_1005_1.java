package pat.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.nowcoder.com/pat/6/problem/4041

/**
 * N, L, H
 * <p>
 * a,b
 * <p>
 * a,b >= H, sort (a+b DESC, a DESC, num ASC)
 * <p>
 * a>=H, b<H, sort (a+b DESC, a DESC, num ASC)
 * <p>
 * a<H, b<H, a<=b, sort (a+b DESC, a DESC, num ASC)
 * <p>
 * a>=L || b>=L, sort (a+b DESC, a DESC, num ASC)
 *
 * @author TomAndersen
 */
public class _1005_1 {
    public static void main(String[] args) throws IOException {
        // input, filter, and store
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        short N = Short.parseShort(inputs[0]);
        short L = Short.parseShort(inputs[1]);
        short H = Short.parseShort(inputs[2]);

        int[][] members = new int[N][];
        int count = 0;

        for (int i = 0; i < N; i++) {
            inputs = bf.readLine().split(" ");
            int number = Integer.parseInt(inputs[0]);
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);

            if (a >= L && b >= L) {
                members[count++] = new int[]{number, a, b};
            }
        }

        // sort
        Arrays.sort(members, 0, count, (x, y) -> {
            int levelX = level(x, H);
            int levelY = level(y, H);
            if (levelX != levelY) {
                return levelY - levelX;
            }

            int sumX = x[1] + x[2], sumY = y[1] + y[2];
            if (sumX != sumY) {
                return sumY - sumX;
            }
            else if (x[1] != y[1]) {
                return y[1] - x[1];
            }
            else {
                return x[0] - y[0];
            }
        });

        // print
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(members[i][0] + " " + members[i][1] + " " + members[i][2]);
        }
    }

    private static int level(int[] a, int h) {
        if (a[1] >= h && a[2] >= h) return 4;
        else if (a[1] >= h) return 3;
        else if (a[1] >= a[2]) return 2;
        else return 1;
    }
}
