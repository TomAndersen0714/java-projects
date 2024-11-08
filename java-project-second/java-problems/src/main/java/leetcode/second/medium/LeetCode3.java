package leetcode.second.medium;

import java.util.BitSet;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * @author TomAndersen
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String input;
        int expect;

        input = "abcabcbb";
        expect = 3;
        System.out.println(new LeetCode3_1().lengthOfLongestSubstring(input) == expect);

        input = "bbbbb";
        expect = 1;
        System.out.println(new LeetCode3_1().lengthOfLongestSubstring(input) == expect);

        input = "pwwkew";
        expect = 3;
        System.out.println(new LeetCode3_1().lengthOfLongestSubstring(input) == expect);

        input = " ";
        expect = 1;
        System.out.println(new LeetCode3_1().lengthOfLongestSubstring(input) == expect);

        input = "abcabcbb";
        expect = 3;
        System.out.println(new LeetCode3_2().lengthOfLongestSubstring(input) == expect);

        input = "bbbbb";
        expect = 1;
        System.out.println(new LeetCode3_2().lengthOfLongestSubstring(input) == expect);

        input = "pwwkew";
        expect = 3;
        System.out.println(new LeetCode3_2().lengthOfLongestSubstring(input) == expect);

        input = " ";
        expect = 1;
        System.out.println(new LeetCode3_2().lengthOfLongestSubstring(input) == expect);

    }
}

/**
 * Two pointers
 */
class LeetCode3_1 {
    public int lengthOfLongestSubstring(String s) {
        // input
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // transform
        boolean[] window = new boolean[256];
        int maxSubstrLen = 0, length = s.length();
        int left = 0, right = 0;

        while (right < length) {
            // if current character does not occur in previous windows, then append it and try to update the max length
            int rightChar = s.charAt(right);

            // try to move left pointer to remove duplicate character
            while (window[rightChar] && left < right) {
                window[s.charAt(left)] = false;
                left += 1;
            }

            // add new character into window
            window[rightChar] = true;
            maxSubstrLen = Math.max(maxSubstrLen, right - left + 1);

            // move right pointer
            right += 1;
        }

        // output
        return maxSubstrLen;
    }
}


class LeetCode3_2 {
    public int lengthOfLongestSubstring(String s) {
        // input
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // transform
        int maxSubstrLen = 0, length = s.length();
        BitSet window = new BitSet(256);
        int left = 0, right = 0, rightChar;

        while (right < length) {
            rightChar = s.charAt(right);
            // if current character exists in current window, remove all prefix characters until no duplicate character
            while ((window.get(rightChar))) {
                window.set(s.charAt(left), false);
                left += 1;
            }

            // add current character into window, and try to update the result
            window.set(rightChar, true);
            maxSubstrLen = Math.max(maxSubstrLen, right - left + 1);
            right += 1;
        }

        // output
        return maxSubstrLen;
    }
}
