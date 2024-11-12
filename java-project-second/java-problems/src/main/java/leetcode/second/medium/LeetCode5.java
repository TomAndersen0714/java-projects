package leetcode.second.medium;

/**
 * 5. Longest Palindromic Substring, 最长回文子串
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @author TomAndersen
 */
public class LeetCode5 {
    public static void main(String[] args) {
        String input;
        String output;

        input = "babad";
        output = "bab";
        System.out.println(new LeetCode5_1().longestPalindrome(input).equals(output));

        input = "cbbd";
        output = "bb";
        System.out.println(new LeetCode5_1().longestPalindrome(input).equals(output));

        input = "babad";
        output = "aba";
        System.out.println(new LeetCode5_2().longestPalindrome(input).equals(output));

        input = "cbbd";
        output = "bb";
        System.out.println(new LeetCode5_2().longestPalindrome(input).equals(output));

        input = "ccc";
        output = "ccc";
        System.out.println(new LeetCode5_2().longestPalindrome(input).equals(output));
    }
}

/**
 * Brute Force
 */
class LeetCode5_1 {
    public String longestPalindrome(String s) {
        // input
        if (s == null || s.length() <= 1) {
            return s;
        }

        // transform
        int length = s.length();
        int start = 0, end = 0;
        int left, right;

        for (int i = 0; i < length; i++) {
            // odd
            left = i;
            right = i;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left -= 1;
                right += 1;
            }
            if ((right - 1) - (left + 1) > end - start) {
                start = left + 1;
                end = right - 1;
            }

            // even
            left = i;
            right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left -= 1;
                right += 1;
            }
            if ((right - 1) - (left + 1) > end - start) {
                start = left + 1;
                end = right - 1;
            }
        }

        // output
        return s.substring(start, end + 1);
    }
}

/**
 * Dynamic Programming
 * 当前子问题实际上是不重叠的, 适合用遍历+分治DC算法, 而不适用于动态规划DP算法, 因为后者在计算时缓存的中间结果, 实际上只使用了一次
 */
class LeetCode5_2 {
    public String longestPalindrome(String s) {
        // input
        if (s == null || s.length() <= 1) {
            return s;
        }

        // transform
        // 将查找最长回文字符串, 转换为查找长度为n(dp[i][j])的子串是否是回文字符串, 并建立递推公式
        // dp[i][j] = s.chatAt(i) == s.charAt(j) && dp[i+1][j-1], j>i
        boolean[][] dp = new boolean[s.length()][s.length()];
        int left = 0, right = 0;

        // init dp array
        // 后续需要按照子串的长度从小到大的方向进行遍历
        // 初始化dp数组, 初始化子串长度为1和2的情况, 即边界情况的解
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;

            int j = i + 1;
            if (j < dp.length && s.charAt(i) == s.charAt(j)) {
                dp[i][j] = true;
                left = i;
                right = j;
            }
        }

        // solve the question
        // 按照子串的长度从小到大的方向进行遍历
        for (int interval = 2; interval < s.length(); interval += 1) {
            for (int i = 0; i < dp.length; i++) {
                int j = i + interval;
                if (j < dp.length && dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    left = i;
                    right = j;
                }
            }
        }

        // output
        return s.substring(left, right + 1);
    }
}
