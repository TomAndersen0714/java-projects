package algorithm.pat.level1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// https://www.nowcoder.com/pat/6/problem/4042

/**
 * @author TomAndersen
 */
public class _1006_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        String a = inputs[0], b = inputs[2];
        char da = inputs[1].charAt(0), db = inputs[3].charAt(0);
        int countA = 0, countB = 0;


        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == da) countA += 1;
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == db) countB += 1;
        }

        long x = 0, y = 0;
        for (int i = 0; i < countA; i++) {
            x = x * 10 + da - '0';
        }
        for (int i = 0; i < countB; i++) {
            y = y * 10 + db - '0';
        }

        System.out.println(x + y);
    }

}
