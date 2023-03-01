package algorithm.pat.level1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// https://www.nowcoder.com/pat/6/problem/4055
// PS: 此题坑点在于
// 1. 题目使用的测试用例存在问题, 可能出现输出字符不被包含在输入字符中的问题

/**
 * 双指针
 *
 * @author TomAndersen
 */
public class _1019_1 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = bf.readLine().toCharArray();
        char[] outputs = bf.readLine().toCharArray();

        // all characters in Unicode
        boolean[] occurs = new boolean[256];

        // match, and append
        StringBuilder sb = new StringBuilder();
        int m = inputs.length, n = outputs.length;

        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            char in = inputs[p1];
            char out = outputs[p2];

            if (in == out) {
                p1++;
                p2++;
            }
            else {
                // to upper if in lower
                if (in >= 'a' && in <= 'z') {
                    in = (char) (in - 'a' + 'A');
                }

                // if first occur then append
                if (!occurs[in]) {
                    sb.append(in);
                    occurs[in] = true;
                }

                p1++;
            }
        }

        while (p1 < m) {
            char in = inputs[p1];

            // to upper if in lower
            if (in >= 'a' && in <= 'z') {
                in = (char) (in - 'a' + 'A');
            }

            // if first occur then append
            if (!occurs[in]) {
                sb.append(in);
                occurs[in] = true;
            }

            p1++;
        }

        // output
        System.out.print(sb);
    }
}
