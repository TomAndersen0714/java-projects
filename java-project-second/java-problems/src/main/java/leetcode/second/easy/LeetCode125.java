package leetcode.second.easy;

/**
 * 125. Valid Palindrome, 是否是有效回文字符串
 * https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author TomAndersen
 */
public class LeetCode125 {
    public static void main(String[] args) {
        String input;
        boolean expect;

        input = "A man, a plan, a canal: Panama";
        expect = true;
        System.out.println(new LeetCode125_1().isPalindrome(input) == expect);

        input = "race a car";
        expect = false;
        System.out.println(new LeetCode125_1().isPalindrome(input) == expect);

        input = " ";
        expect = true;
        System.out.println(new LeetCode125_1().isPalindrome(input) == expect);
    }
}

class LeetCode125_1 {
    public boolean isPalindrome(String s) {
        // input
        if (s == null) {
            return false;
        }

        // transform
        boolean res = true;
        int left = 0, right = s.length() - 1;
        char leftChar, rightChar;
        while (left < right) {
            leftChar = s.charAt(left);
            rightChar = s.charAt(right);

            if (!(Character.isAlphabetic(leftChar) || Character.isDigit(leftChar))) {
                left += 1;
            }
            else if (!(Character.isAlphabetic(rightChar) || Character.isDigit(rightChar))) {
                right -= 1;
            }
            else if (Character.toLowerCase(leftChar) == Character.toLowerCase(rightChar)) {
                left += 1;
                right -= 1;
            }
            else {
                res = false;
                break;
            }
        }

        // output
        return res;
    }
}
