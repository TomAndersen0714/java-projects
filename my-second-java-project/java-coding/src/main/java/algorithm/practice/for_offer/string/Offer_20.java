package algorithm.practice.for_offer.string;

/**
 * https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 *
 * @author TomAndersen
 */
public class Offer_20 {
    public boolean isNumber(String s) {
        // boundary condition
        if (s == null || s.length() == 0) {
            return false;
        }

        // handle
        String foo = s.trim().toUpperCase();
        int len = foo.length();
        int idx = foo.indexOf('E');
        boolean res;

        if (len == 0) {
            return false;
        }

        if (idx >= 0) {
            res = (isInt(foo, 0, idx - 1) || isFloat(foo, 0, idx - 1))
                && isInt(foo, idx + 1, len - 1);
        }
        else {
            res = isInt(foo, 0, len - 1) || isFloat(foo, 0, len - 1);
        }

        // output
        return res;
    }


    private static boolean isNums(String nums, int start, int end) {
        if (start > end) {
            return false;
        }

        for (int i = start; i <= end; i++) {
            if (nums.charAt(i) < '0' || nums.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean isInt(String nums, int start, int end) {
        if (start > end) {
            return false;
        }

        char leading = nums.charAt(start);
        if (leading == '-' || leading == '+') {
            start += 1;
        }

        return isNums(nums, start, end);
    }

    private static boolean isFloat(String nums, int start, int end) {
        if (start > end) {
            return false;
        }

        char leading = nums.charAt(start);
        if (leading == '-' || leading == '+') {
            start += 1;
        }

        String foo = nums.substring(start, end + 1);
        int idx = foo.indexOf('.'), len = foo.length();
        if (idx < 0) {
            return false;
        }
        else if (idx == 0) {
            return isNums(foo, 1, len - 1);
        }
        else if (idx == len - 1) {
            return isNums(foo, 0, len - 2);
        }
        else {
            return isNums(foo, 0, idx - 1)
                && isNums(foo, idx + 1, len - 1);
        }
    }

    public static void main(String[] args) {
        // System.out.println(new Offer_20().isNumber("0"));
        // System.out.println(new Offer_20().isNumber("e"));
        // System.out.println(new Offer_20().isNumber("."));
        // System.out.println(new Offer_20().isNumber("    .1  "));
        // System.out.println(new Offer_20().isNumber("2e0"));
        System.out.println(new Offer_20().isNumber("0e"));
    }
}
