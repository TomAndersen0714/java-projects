package algorithm.practice.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/regular-expression-matching/
 *
 * @author TomAndersen
 */
public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        // boundary condition
        if (s == null || p == null) {
            return false;
        }

        // build DFA array based on the pattern
        ArrayList<int[]> arrays = new ArrayList<>();
        arrays.add(new int[]{}); // sentry element
        int len = p.length();
        int status = 1;

        for (int i = 0; i < len; i++) {
            char c = p.charAt(i);

            // if it's letter
            if (c >= 'a' && c <= 'z') {
                int[] array = new int[26];
                array[c - 'a'] = status + 1;
                arrays.add(array);

                status += 1;
            }
            // if it's a dot
            else if (c == '.') {
                int[] array = new int[26];
                Arrays.fill(array, status + 1);
                arrays.add(array);

                status += 1;
            }
            // if it's a start
            else {
                status -= 1;

                // look the previous character in pattern
                char pre = p.charAt(i - 1);
                int[] array = arrays.get(status);

                if (pre >= 'a' && pre <= 'z') {
                    array[pre - 'a'] = status;
                }
                else if (pre == '.') {
                    Arrays.fill(array, status);
                }
            }
        }

        // using the DFA array to verify input string
        len = s.length();
        status = 1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                
            }
        }

        // return
        return false;
    }


    public static void main(String[] args) {

    }
}
