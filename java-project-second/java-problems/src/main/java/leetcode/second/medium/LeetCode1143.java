package leetcode.second.medium;

public class LeetCode1143 {
    public static void main(String[] args) {
        String text1, text2;
        int output;

        text1 = "abcde";
        text2 = "ace";
        output = 3;
        System.out.println(new LeetCode1143_1().longestCommonSubsequence(text1, text2) == output);

        text1 = "abc";
        text2 = "abc";
        output = 3;
        System.out.println(new LeetCode1143_1().longestCommonSubsequence(text1, text2) == output);

        text1 = "abc";
        text2 = "def";
        output = 0;
        System.out.println(new LeetCode1143_1().longestCommonSubsequence(text1, text2) == output);

        text1 = "bl";
        text2 = "yby";
        output = 1;
        System.out.println(new LeetCode1143_1().longestCommonSubsequence(text1, text2) == output);

        text1 = "abcde";
        text2 = "ace";
        output = 3;
        System.out.println(new LeetCode1143_2().longestCommonSubsequence(text1, text2) == output);

        text1 = "abc";
        text2 = "abc";
        output = 3;
        System.out.println(new LeetCode1143_2().longestCommonSubsequence(text1, text2) == output);

        text1 = "abc";
        text2 = "def";
        output = 0;
        System.out.println(new LeetCode1143_2().longestCommonSubsequence(text1, text2) == output);

        text1 = "bl";
        text2 = "yby";
        output = 1;
        System.out.println(new LeetCode1143_2().longestCommonSubsequence(text1, text2) == output);
    }
}


class LeetCode1143_1 {
    public int longestCommonSubsequence(String text1, String text2) {
        // input
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        // transform
        int res = 0;
        // state array, dp[i][j] means the length of longest common subsequence
        // state equation, dp[i][j] = dp[i-1][j-1]+1 if text1.charAt(i) == text2.charAt(j), dp[i][j] = max { dp[i-1][j], dp[i][j-1]}
        int row = text1.length(), col = text2.length();
        int[][] dp = new int[row][col];

        // initialize the state array
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < row; i += 1) {
            if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
            }
            else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < col; j += 1) {
            if (text1.charAt(0) == text2.charAt(j)) {
                dp[0][j] = 1;
            }
            else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // iterate and fill the array
        for (int i = 1; i < row; i += 1) {
            for (int j = 1; j < col; j += 1) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // output
        res = dp[row - 1][col - 1];
        return res;
    }
}


class LeetCode1143_2 {
    public int longestCommonSubsequence(String text1, String text2) {
        // input
        if (text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        // transform
        // state equation, dp[i][j] means the length of longest subsequence of first i and j characters
        int row = text1.length(), col = text2.length();
        int[][] dp = new int[row + 1][col + 1];

        // iterate and fill state array
        for (int i = 1; i <= row; i += 1) {
            for (int j = 1; j <= col; j += 1) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // output
        return dp[row][col];
    }
}
