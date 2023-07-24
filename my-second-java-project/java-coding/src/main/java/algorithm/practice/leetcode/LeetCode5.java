package algorithm.practice.leetcode;

/**
 * 5. Longest Palindromic Substring:
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p>
 * tags: medium, string
 *
 * @author TomAndersen
 */
public class LeetCode5 {
}

/**
 * Brute Force: expand from centers
 * TC:O(n*n), SC:O(1)
 */
class LeetCode5_1 {
    public String longestPalindrome(String s) {
        // exclude boundary condition
        if (s == null || s.length() <= 1) {
            return s;
        }

        // handle
        int len = s.length();
        int left = 0, right = 0, maxLen = 1;
        for (int i = 0; i < len; i++) {
            // check all odd substring
            int p = i, q = i;
            while (p >= 0 && q < len && s.charAt(p) == s.charAt(q)) {
                int interval = q - p + 1;

                // try to update the result
                if (interval > maxLen) {
                    maxLen = interval;
                    left = p;
                    right = q;
                }

                p -= 1;
                q += 1;
            }

            // check all even substring
            p = i;
            q = i + 1;
            while (p >= 0 && q < len && s.charAt(p) == s.charAt(q)) {
                int interval = q - p + 1;

                // try to update the result
                if (interval > maxLen) {
                    maxLen = interval;
                    left = p;
                    right = q;
                }

                p -= 1;
                q += 1;
            }
        }

        // return
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode5_1().longestPalindrome("babad").equals("bab"));
        System.out.println(new LeetCode5_1().longestPalindrome("cbbd").equals("bb"));
    }
}

/**
 * Dynamic Programming
 * TC:O(n*n), SC:O(n)
 */
class LeetCode5_2 {
    public static void main(String[] args) {

    }
}
