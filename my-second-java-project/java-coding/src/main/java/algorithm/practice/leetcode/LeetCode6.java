package algorithm.practice.leetcode;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * @author TomAndersen
 */
public class LeetCode6 {
    public String convert(String s, int numRows) {
        // boundary condition
        if (s == null || s.length() == 0 || numRows < 0) {
            return null;
        }
        if (numRows == 1) {
            return s;
        }

        // handle
        int len = s.length(), num = numRows;
        int radix = num * 2 - 2;
        StringBuilder[] stringBuilders = new StringBuilder[num];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        for (int i = 0; i < len; i++) {
            int idx = i % radix;
            int left = idx, right = radix - idx;
            int line = Math.min(left, right);
            stringBuilders[line].append(s.charAt(i));
        }

        // output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringBuilders.length; i++) {
            sb.append(stringBuilders[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("PAHNAPLSIIGYIR".equals(new LeetCode6().convert("PAYPALISHIRING", 3)));
        System.out.println("PINALSIGYAHRPI".equals(new LeetCode6().convert("PAYPALISHIRING", 4)));
        System.out.println("A".equals(new LeetCode6().convert("A", 1)));
    }
}
