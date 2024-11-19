package leetcode.second.medium;

/**
 * 72. Edit Distance, 编辑距离（字符串转换最短次数）
 * https://leetcode.com/problems/edit-distance/description
 * https://leetcode.cn/problems/edit-distance/solutions/188223/bian-ji-ju-chi-by-leetcode-solution/
 * !!!
 */
public class LeetCode72 {
    public static void main(String[] args) {
        String word1, word2;
        int output;

        word1 = "horse";
        word2 = "ros";
        output = 3;
        System.out.println(new LeetCode72_1().minDistance(word1, word2) == output);

        word1 = "intention";
        word2 = "execution";
        output = 5;
        System.out.println(new LeetCode72_1().minDistance(word1, word2) == output);
    }
}


/**
 * Divide + Dynamic Programming
 */
class LeetCode72_1 {
    public int minDistance(String word1, String word2) {
        // input
        if (word1 == null || word2 == null) {
            return -1;
        }

        // transform
        int minOps = 0;
        // state transform equation, dp[i][j] means min distance from first i characters of word1 to first j characters of word2
        // then dp[i][j] = min{ dp[i-1][j-1], dp[i-1][j] + 1, dp[i][j-1] + 1 } if word1.charAt(i) == word2.charAt(j)
        // then dp[i][j] = min{ dp[i-1][j-1] + 1, dp[i-1][j] + 1, dp[i][j-1] + 1 } if word1.charAt(i) != word2.charAt(j)
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        // initialize the dp array
        // when the second word is empty, then min distance is the first of second word, i.e. remove all characters
        for (int i = 0; i <= len1; i += 1) {
            dp[i][0] = i;
        }
        // when the first word is empty, then min distance is the length of second word, i.e. add all characters
        for (int j = 0; j <= len2; j += 1) {
            dp[0][j] = j;
        }

        // iterate and fill state array
        for (int i = 1; i <= len1; i += 1) {
            for (int j = 1; j <= len2; j += 1) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        // output
        minOps = dp[len1][len2];
        return minOps;
    }
}
