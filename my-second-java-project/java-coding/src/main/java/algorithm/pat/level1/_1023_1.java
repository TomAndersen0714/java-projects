package algorithm.pat.level1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// https://www.nowcoder.com/pat/6/problem/4059

/**
 * @author TomAndersen
 */
public class _1023_1 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] brokenKeys = bf.readLine().toCharArray();
        char[] pressedKeys = bf.readLine().toCharArray();

        // build assistant array
        boolean[] isBroken = new boolean[256];
        for (int i = 0; i < brokenKeys.length; i++) {
            char c = brokenKeys[i];
            isBroken[c] = true;
            if (c >= 'A' && c <= 'Z') {
                isBroken[c - 'A' + 'a'] = true;
            }
            else if (c >= 'a' && c <= 'z') {
                isBroken[c - 'a' + 'A'] = true;
            }
        }
        boolean isShiftBroken = isBroken['+'];

        // concat
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pressedKeys.length; i++) {
            char c = pressedKeys[i];
            if (isBroken[c]) {
                continue;
            }
            if (isShiftBroken && (c >= 'A' && c <= 'Z')) {
                continue;
            }
            sb.append(c);
        }

        // print
        System.out.println(sb);

    }
}
