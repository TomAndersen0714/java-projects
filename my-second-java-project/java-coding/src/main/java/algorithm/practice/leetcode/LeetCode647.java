package algorithm.practice.leetcode;

/**
 * 647. https://leetcode.com/problems/palindromic-substrings/
 * tags: medium, string, dynamic programming
 *
 * @author TomAndersen
 */
public class LeetCode647 {
}

/**
 * Dynamic programming
 * TC: O(n*n), SC: O(n)
 */
class LeetCode647_1 {
    public int countSubstrings(String s) {
        // exclude boundary situation
        if (s == null || s.length() == 0) {
            return 0;
        }

        // build transfer equation and state cache
        // if s.substring(i,j) is palindromic, dp[i][j] = true
        int length = s.length();
        boolean[][] stateCache = new boolean[length][length];
        int palindromonCount = 0;

        // solve boundary problem
        for (int i = 0; i < length; i += 1) {
            stateCache[i][i] = true;
            palindromonCount += 1;
        }
        for (int i = 0; i + 1 < length; i += 1) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                stateCache[i][i + 1] = true;
                palindromonCount += 1;
            }
        }

        // solve other problem
        for (int interval = 2; interval <= length - 1; interval += 1) {
            for (int i = 0; i + interval < length; i += 1) {
                int j = i + interval;
                if (stateCache[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    stateCache[i][j] = true;
                    palindromonCount += 1;
                }
            }
        }

        // return
        return palindromonCount;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode647_1().countSubstrings("abc") == 3);
        System.out.println(new LeetCode647_1().countSubstrings("aaa") == 6);
    }
}

/**
 * Iterate all palindromic substring by expanding from center
 * TC:O(n*n), SC:O(1)
 */
class LeetCode647_2 {
    public int countSubstrings(String s) {
        // exclude boundary situation
        if (s == null || s.length() == 0) {
            return 0;
        }

        // iterate all palindromic substring
        int res = 0, length = s.length();
        for (int i = 0; i < length; i++) {
            // one element as center
            int left = i, right = i;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                res += 1;
                left -= 1;
                right += 1;
            }

            // two element as center
            left = i;
            right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                res += 1;
                left -= 1;
                right += 1;
            }
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode647_2().countSubstrings("abc") == 3);
        System.out.println(new LeetCode647_2().countSubstrings("aaa") == 6);
    }
}
