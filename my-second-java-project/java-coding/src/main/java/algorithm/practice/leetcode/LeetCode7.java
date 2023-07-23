package algorithm.practice.leetcode;

import java.math.BigInteger;

/**
 * 7. Reverse Integer: https://leetcode.com/problems/reverse-integer/
 * <p>
 * tags: medium, string, math
 *
 * @author TomAndersen
 */
public class LeetCode7 {
}

/**
 * Brute force
 * TC:O(n), SC: O(n)
 */
class LeetCode7_1 {
    public int reverse(int x) {
        // exclude boundary condition
        if (x == 0) {
            return x;
        }

        // handle
        // reverse the digits of input value
        char[] valueDigits;
        boolean sign = (x >= 0);
        if (sign) {
            valueDigits = Integer.toString(x).toCharArray();
        }
        else {
            valueDigits = Integer.toString(x).substring(1).toCharArray();
        }

        int left = 0, right = valueDigits.length - 1;
        while (left < right) {
            char tmp = valueDigits[left];
            valueDigits[left] = valueDigits[right];
            valueDigits[right] = tmp;

            left += 1;
            right -= 1;
        }

        // if positive
        int value = 0;
        String positiveLimit = Integer.toString(Integer.MAX_VALUE);
        String negativeLimit = Integer.toString(Integer.MIN_VALUE).substring(1);
        String valueString = new String(valueDigits);


        if (sign) {
            if (!(valueString.length() == positiveLimit.length() && valueString.compareTo(positiveLimit) > 0)) {
                value = Integer.parseInt(valueString);
            }

        }
        else {
            if (!(valueString.length() == negativeLimit.length() && valueString.compareTo(negativeLimit) > 0)) {
                value = -Integer.parseInt(valueString);
            }
        }

        // return
        return value;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode7_1().reverse(123) == 321);
        System.out.println(new LeetCode7_1().reverse(-123) == -321);
        System.out.println(new LeetCode7_1().reverse(120) == 21);
        System.out.println(new LeetCode7_1().reverse(0) == 0);
        System.out.println(new LeetCode7_1().reverse(-2147483648) == 0);
    }
}

/**
 * BigInteger
 * TC:O(n), SC: O(n)
 */
class LeetCode7_2 {
    public int reverse(int x) {
        // exclude boundary condition
        if (x == 0) {
            return x;
        }

        // handle
        // reverse the digits of input value
        char[] valueDigits = Integer.toString(x).toCharArray();
        int left = 0, right = valueDigits.length - 1;

        // skip the negative sign
        if (x < 0) {
            left += 1;
        }
        while (left < right) {
            char tmp = valueDigits[left];
            valueDigits[left] = valueDigits[right];
            valueDigits[right] = tmp;

            left += 1;
            right -= 1;
        }

        // compare the boundary value
        BigInteger bigValue = new BigInteger(new String(valueDigits));
        int value = 0;

        if (bigValue.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0 && bigValue.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0) {
            value = Integer.parseInt(new String(valueDigits));
        }


        // return
        return value;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode7_2().reverse(123) == 321);
        System.out.println(new LeetCode7_2().reverse(-123) == -321);
        System.out.println(new LeetCode7_2().reverse(120) == 21);
        System.out.println(new LeetCode7_2().reverse(0) == 0);
        System.out.println(new LeetCode7_2().reverse(-2147483648) == 0);
    }
}

/**
 * math
 * TC:O(n), SC: O(1)
 */
class LeetCode7_3 {
    public int reverse(int x) {
        // exclude boundary condition
        if (x == 0) {
            return x;
        }

        // handle
        // reserve the sign bit to simplify situations
        int sign = x >= 0 ? 1 : -1;
        int reversedValue = 0, value = x >= 0 ? x : -x;

        while (value != 0) {
            int remainder = value % 10;
            value /= 10;

            // shift number in 10-radix, and check precision overflow
            if (reversedValue <= Integer.MAX_VALUE / 10) {
                reversedValue *= 10;
            }
            else {
                reversedValue = 0;
                break;
            }

            // set the lowest digit, and check precision overflow
            if (reversedValue <= Integer.MAX_VALUE - remainder) {
                reversedValue += remainder;
            }
            else {
                reversedValue = 0;
                break;
            }
        }


        // return
        return reversedValue * sign;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode7_3().reverse(123) == 321);
        System.out.println(new LeetCode7_3().reverse(-123) == -321);
        System.out.println(new LeetCode7_3().reverse(120) == 21);
        System.out.println(new LeetCode7_2().reverse(0) == 0);
        System.out.println(new LeetCode7_2().reverse(-2147483648) == 0);
    }
}
