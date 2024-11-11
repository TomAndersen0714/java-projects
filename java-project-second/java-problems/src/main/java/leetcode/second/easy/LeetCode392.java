package leetcode.second.easy;

/**
 * 392. Is Subsequence, 是否是子序列
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author TomAndersen
 */
public class LeetCode392 {
    public static void main(String[] args) {
        String inputS, inputT;
        boolean output;

        inputS = "abc";
        inputT = "ahbgdc";
        output = true;
        System.out.println(new LeetCode392_1().isSubsequence(inputS, inputT) == output);

        inputS = "axc";
        inputT = "ahbgdc";
        output = false;
        System.out.println(new LeetCode392_1().isSubsequence(inputS, inputT) == output);

        inputS = "aaaaaa";
        inputT = "bbaaaa";
        output = false;
        System.out.println(new LeetCode392_1().isSubsequence(inputS, inputT) == output);
    }
}

class LeetCode392_1 {
    public boolean isSubsequence(String s, String t) {
        // input
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }

        // transform
        boolean res = true;
        int pointerA = 0, pointerB = 0;
        int lengthA = s.length(), lengthB = t.length();
        while (pointerA < lengthA) {
            // if not hit, then move the right pointer
            while (pointerB < lengthB && t.charAt(pointerB) != s.charAt(pointerA)) {
                pointerB += 1;
            }

            // if hit, then move the left and right pointer
            if (pointerB < lengthB) {
                pointerA += 1;
                pointerB += 1;
            }
            // if there still is some characters left when right pointer meet the end, then false
            else {
                res = false;
                break;
            }
        }

        // output
        return res;
    }
}
