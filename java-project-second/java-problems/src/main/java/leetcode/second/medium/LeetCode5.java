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
 * Dynamic Process
 */
class LeetCode5_2 {
    public String longestPalindrome(String s) {
        return null;
    }
}
