package leetcode.first.easy;

import java.util.HashSet;

/**
 * 3. Longest Substring Without Repeating Characters: https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * @author TomAndersen
 */
public class LeetCode3 {
}

/**
 * Two pointers (sliding window) + HashSet
 * TC: O(n), SC: O(n)
 */
class LeetCode3_1 {
    public int lengthOfLongestSubstring(String s) {
        // exclude boundary situation
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // solve problem
        int length = s.length();
        int left = 0, maxSubstrLen = 1;
        HashSet<Character> subStrChars = new HashSet<>();
        subStrChars.add(s.charAt(left));

        for (int right = left + 1; right < length; right += 1) {
            Character c = s.charAt(right);
            while (subStrChars.contains(c)) {
                subStrChars.remove(s.charAt(left));
                left += 1;
            }
            subStrChars.add(c);
            maxSubstrLen = Math.max(maxSubstrLen, right - left + 1);
        }

        // return
        return maxSubstrLen;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode3_1().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LeetCode3_1().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LeetCode3_1().lengthOfLongestSubstring("pwwkew"));
    }
}

/**
 * Two pointers (sliding window) + Array
 * TC: O(n), SC: O(1)
 */
class LeetCode3_2 {
    public int lengthOfLongestSubstring(String s) {
        // exclude boundary situation
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // solve problem
        int maxLen = 1;
        int length = s.length(), left = 0;
        boolean[] charCounter = new boolean[256];

        charCounter[s.charAt(left)] = true;
        for (int right = 1; right < length; right += 1) {
            char c = s.charAt(right);
            while (charCounter[c]) {
                charCounter[s.charAt(left)] = false;
                left += 1;
            }
            charCounter[c] = true;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // return
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode3_2().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LeetCode3_2().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LeetCode3_2().lengthOfLongestSubstring("pwwkew"));
    }
}
