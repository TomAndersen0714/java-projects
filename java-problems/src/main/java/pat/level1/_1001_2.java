package pat.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 此方法的关键点在于, 通过缓存区进行批量IO, 大幅度减少IO次数, 以及IO带来的性能开销.
 *
 * @author TomAndersen
 */
public class _1001_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> ans = new ArrayList<>();
        int time = Integer.parseInt(br.readLine());
        for (int i = 0; i < time; i++) {
            String[] values = br.readLine().split(" ");
            // 1 8 3 282866 999000 6
            long n = Long.parseLong(values[0]);
            long m = Long.parseLong(values[1]);
            long t = Long.parseLong(values[2]);
            if (n + m > t) {
                ans.add("Case #" + (i + 1) + ": true");
            }
            else {
                ans.add("Case #" + (i + 1) + ": false");
            }
        }
        for (int i = 0; i < time; i++) {
            System.out.println(ans.get(i));
        }
    }
}
