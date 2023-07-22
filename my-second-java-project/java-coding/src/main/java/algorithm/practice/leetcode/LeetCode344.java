package algorithm.practice.leetcode;

import java.util.Arrays;

/**
 * 344. Reverse String:
 * https://leetcode.com/problems/reverse-string/
 * <p>
 * tags: easy, string, two pointers
 *
 * @author TomAndersen
 */
public class LeetCode344 {
}

/**
 * Two pointers
 * TC:O(n), SC:O(1)
 */
class LeetCode344_1 {
    public void reverseString(char[] s) {
        // exclude boundary condition
        if (s == null || s.length <= 1) {
            return;
        }

        // handle
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left += 1;
            right -= 1;
        }

        // return
        return;
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        new LeetCode344_1().reverseString(s);
        System.out.println(Arrays.equals(s, new char[]{'o', 'l', 'l', 'e', 'h'}));

        s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        new LeetCode344_1().reverseString(s);
        System.out.println(Arrays.equals(s, new char[]{'h', 'a', 'n', 'n', 'a', 'H'}));
    }
}