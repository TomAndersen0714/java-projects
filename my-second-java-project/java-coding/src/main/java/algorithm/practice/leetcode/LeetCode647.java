package algorithm.practice.leetcode;

/**
 * 647. https://leetcode.com/problems/palindromic-substrings/
 * tags: medium, string
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
        // exclude boundary condition
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
 * Expanding from center
 * TC:O(n*n), SC:O(1)
 */
class LeetCode647_2 {

}
