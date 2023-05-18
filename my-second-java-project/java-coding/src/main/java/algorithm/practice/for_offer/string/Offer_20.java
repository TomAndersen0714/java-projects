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
        boolean res = true;

        int idx = foo.indexOf('E'), len = foo.length();
        if (idx >= 0) {
            res = (isInt(foo, 0, idx) || isFloat(foo, 0, idx))
                && isInt(foo, idx + 1, len - 1);
        }
        else {
            res = isInt(foo, 0, len - 1) || isFloat(foo, 0, len - 1);
        }

        // output
        return res;
    }


    private static boolean isNums(String nums, int start, int end) {
        if (start <= end) {
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
        char leading = nums.charAt(start);
        if (leading == '-' || leading == '+') {
            start += 1;
        }

        if (start == end) {
            return false;
        }

        return isNums(nums, start, end);
    }

    private static boolean isFloat(String nums, int start, int end) {
        char leading = nums.charAt(start);
        if (leading == '-' || leading == '+') {
            start += 1;
        }

        String foo = nums.substring(start, end + 1);
        int idx = foo.indexOf('.'), len = foo.length();
        if (idx <= 0) {
            return false;
        }
        else if (idx == 0) {
            return isNums(foo, 1, len - 1);
        }
        else if (idx == len - 1) {
            // TODO
            return isNums(foo, 0, idx - 1);
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
