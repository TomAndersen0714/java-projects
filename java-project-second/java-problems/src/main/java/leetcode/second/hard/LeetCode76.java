package leetcode.second.hard;

import java.util.Objects;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * @author TomAndersen
 */
public class LeetCode76 {
    public static void main(String[] args) {
        String s, t, output;

        s = "ADOBECODEBANC";
        t = "ABC";
        output = "BANC";
        System.out.println(Objects.equals(new LeetCode76_1().minWindow(s, t), output));

        s = "a";
        t = "a";
        output = "a";
        System.out.println(Objects.equals(new LeetCode76_1().minWindow(s, t), output));

        s = "a";
        t = "aa";
        output = "";
        System.out.println(Objects.equals(new LeetCode76_1().minWindow(s, t), output));
    }
}


class LeetCode76_1 {
    public String minWindow(String s, String t) {
        // input
        if (s == null || s.isEmpty()) {
            return "";
        }

        // transform
        int windowsLeft = 0, windowsRight = 0, length = s.length();
        int minWindowsLeft = 0, minWindowsRight = length;

        // windowsLetterDiffCounters[i] means the difference value of character i count of s windows and t windows
        int[] windowsLetterDiffCounters = new int[128];
        int needLettersCounter = 0;

        for (char c : t.toCharArray()) {
            if (windowsLetterDiffCounters[c] == 0) {
                needLettersCounter += 1;
            }
            windowsLetterDiffCounters[c] += 1;
        }

        while (windowsRight < length) {
            char c = s.charAt(windowsRight);

            windowsLetterDiffCounters[c] -= 1;
            if (windowsLetterDiffCounters[c] == 0) {
                needLettersCounter -= 1;
            }

            // when included all target characters
            while (needLettersCounter == 0 && windowsLeft <= windowsRight) {
                // try to update minimum boundary of windows
                if (windowsRight - windowsLeft < minWindowsRight - minWindowsLeft) {
                    minWindowsLeft = windowsLeft;
                    minWindowsRight = windowsRight;
                }

                //  then move the left pointer
                c = s.charAt(windowsLeft);
                windowsLeft += 1;
                if (windowsLetterDiffCounters[c] == 0) {
                    needLettersCounter += 1;
                }
                windowsLetterDiffCounters[c] += 1;
            }

            // move the right pointer of windows
            windowsRight += 1;
        }

        // output
        return minWindowsRight - minWindowsLeft != length ? s.substring(minWindowsLeft, minWindowsRight + 1) : "";
    }
}
