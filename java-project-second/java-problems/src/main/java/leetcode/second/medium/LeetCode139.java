package leetcode.second.medium;

import java.util.HashSet;
import java.util.List;

/**
 * 139. Word Break, 单词分割
 * https://leetcode.com/problems/word-break/
 *
 * @author TomAndersen
 */
public class LeetCode139 {
    public static void main(String[] args) {
        String s;
        List<String> wordDict;
        boolean output;

        s = "leetcode";
        wordDict = List.of("leet", "code");
        output = true;
        System.out.println(new LeetCode139_1().wordBreak(s, wordDict) == output);

        s = "applepenapple";
        wordDict = List.of("apple", "pen");
        output = true;
        System.out.println(new LeetCode139_1().wordBreak(s, wordDict) == output);

        s = "catsandog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        output = false;
        System.out.println(new LeetCode139_1().wordBreak(s, wordDict) == output);

        s = "leetcode";
        wordDict = List.of("leet", "code");
        output = true;
        System.out.println(new LeetCode139_2().wordBreak(s, wordDict) == output);

        s = "applepenapple";
        wordDict = List.of("apple", "pen");
        output = true;
        System.out.println(new LeetCode139_2().wordBreak(s, wordDict) == output);

        s = "catsandog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        output = false;
        System.out.println(new LeetCode139_2().wordBreak(s, wordDict) == output);

        s = "leetcode";
        wordDict = List.of("leet", "code");
        output = true;
        System.out.println(new LeetCode139_3().wordBreak(s, wordDict) == output);

        s = "applepenapple";
        wordDict = List.of("apple", "pen");
        output = true;
        System.out.println(new LeetCode139_3().wordBreak(s, wordDict) == output);

        s = "catsandog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        output = false;
        System.out.println(new LeetCode139_3().wordBreak(s, wordDict) == output);
    }
}

/**
 * Dynamic Programming + HashTable
 */
class LeetCode139_1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // input
        if (wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        // transform
        // state transform equation
        // dp[i][j] = dp[i][n] + dp[n+1][j] (i<=n<=j), dp[i][j] 代表字符串 [i,j] 是否能拆分并匹配字典
        boolean res = true;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        // initialize dp array
        for (int offset = 0; offset < length; offset++) {
            for (int left = 0; left + offset < length; left++) {
                int right = left + offset;

                // match dictionary
                if (wordDict.contains(s.substring(left, right + 1))) {
                    dp[left][right] = true;
                }
                else {
                    // split and match
                    for (int cur = left; cur < right; cur++) {
                        if (dp[left][cur] && dp[cur + 1][right]) {
                            dp[left][right] = true;
                            break;
                        }
                    }
                }
            }
        }

        // output
        res = dp[0][length - 1];
        return res;
    }
}

/**
 * Dynamic Programming + HashTable
 */
class LeetCode139_2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // input
        if (wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        // transform
        boolean res = true;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        // build hash set to accelerate matching
        HashSet<String> dict = new HashSet<>(wordDict);

        // iterate and fill the dp array
        for (int offset = 0; offset < length; offset += 1) {
            for (int start = 0; start + offset < length; start += 1) {
                int end = start + offset;

                // if current substring match the directory, then continue
                if (dict.contains(s.substring(start, end + 1))) {
                    dp[start][end] = true;
                }
                // else split and match the substrings
                else {
                    for (int mid = start; mid < end; mid += 1) {
                        if (dp[start][mid] && dp[mid + 1][end]) {
                            dp[start][end] = true;
                            break;
                        }
                    }
                }
            }
        }

        // output
        res = dp[0][length - 1];
        return res;
    }
}

/**
 * Dynamic Programming + Recursive
 * 递归查询代替迭代的好处是, 不用遍历所有可能解, 实现 pruning
 */
class LeetCode139_3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // input
        if (wordDict == null || wordDict.isEmpty() || s == null || s.isEmpty()) {
            return false;
        }

        // transform
        // state transform equation, dp[i]=dp[i+n] && s.substring(0, n) in dictionary
        // initialize the dp array(skip)
        Boolean[] dp = new Boolean[s.length()];

        // solve recursively
        return wordBreak(s, wordDict, dp, 0);
    }

    private boolean wordBreak(
        String s, List<String> wordDict, Boolean[] dp, int offset
    ) {
        // when offset meet the boundary of input string
        if (offset == s.length()) {
            return true;
        }

        // if calculated before
        if (dp[offset] != null) {
            return dp[offset];
        }

        // else try to match the dictionary recursively
        dp[offset] = false;
        for (String word : wordDict) {
            if (s.startsWith(word, offset) && wordBreak(s, wordDict, dp, offset + word.length())) {
                dp[offset] = true;
                break;
            }
        }

        return dp[offset];
    }
}
