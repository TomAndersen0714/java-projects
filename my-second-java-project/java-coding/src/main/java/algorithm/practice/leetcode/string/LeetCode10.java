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
        /*
        boundary condition
         */
        if (s == null || p == null) {
            return false;
        }

        /*
        build DFA state-transition table based on the regexp
         */
        ArrayList<int[]> arrays = new ArrayList<>();
        // sentry element
        arrays.add(new int[]{});

        int len = p.length();
        int status = 1, finalStatus = status;
        for (int i = 0; i < len; i++) {
            char c = p.charAt(i);

            // if it's english lowercase letter
            if (c >= 'a' && c <= 'z') {
                int nextStatus = status + 1;

                int[] stateTransformer = new int[26];
                stateTransformer[c - 'a'] = nextStatus;
                arrays.add(stateTransformer);

                status = nextStatus;
            }
            // if it's a dot
            else if (c == '.') {
                int nextStatus = status + 1;

                int[] stateTransformer = new int[26];
                Arrays.fill(stateTransformer, nextStatus);
                arrays.add(stateTransformer);

                status = nextStatus;
            }
            // if it's a start
            else {
                // roll the status back
                int previousStatus = status - 1;

                // look the previous character in pattern
                int[] stateTransformer = arrays.get(previousStatus);
                char pre = p.charAt(i - 1);

                // reset the previous status
                if (pre >= 'a' && pre <= 'z') {
                    stateTransformer[pre - 'a'] = previousStatus;
                }
                else if (pre == '.') {
                    Arrays.fill(stateTransformer, previousStatus);
                }
            }
        }

        // cause the letter in pattern is series connected, there must be a final status
        finalStatus = status;

        /*
        using the state-transition table to matching input string
         */
        len = s.length();
        status = 1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int[] stateTransformer = arrays.get(status);

            status = stateTransformer[c - 'a'];
            if (status == 0) {
                return false;
            }
        }

        // return
        return status == finalStatus;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode10().isMatch("aa", "a"));
        // System.out.println(new LeetCode10().isMatch("aa", "a*"));
        // System.out.println(new LeetCode10().isMatch("ab", ".*"));
    }
}
