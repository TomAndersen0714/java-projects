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
        /* boundary condition */
        if (s == null || p == null) {
            return false;
        }


        /* Build a DFA status-transform array based on the regexp. */
        ArrayList<int[]> statusArrays = new ArrayList<>();

        int len = p.length();
        for (int i = 0; i < len; i++) {
            char c = p.charAt(i);
        }

        /* Matching the string using the status-transform array. */

    }


    public static void main(String[] args) {
        // System.out.println(new LeetCode10().isMatch("aa", "a"));
        // System.out.println(new LeetCode10().isMatch("aa", "a*"));
        // System.out.println(new LeetCode10().isMatch("ab", ".*"));
        System.out.println(new LeetCode10().isMatch("aab", "c*a*b"));
    }
}
