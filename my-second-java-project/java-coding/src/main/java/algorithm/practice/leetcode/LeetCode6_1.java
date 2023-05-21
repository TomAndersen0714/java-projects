package algorithm.practice.leetcode;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * @author TomAndersen
 */
public class LeetCode6_1 {
    public String convert(String s, int numRows) {
        // boundary condition
        if (s == null || s.length() == 0 || numRows == 0) {
            return null;
        }
        if (numRows == 1) {
            return s;
        }

        // handle
        StringBuilder sb = new StringBuilder();
        int len = s.length(), radix = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                int idx = j % radix;
                int lineNum = Math.min(idx, radix - idx);
                if (lineNum == i) {
                    sb.append(s.charAt(j));
                }
            }
        }

        // output
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("PAHNAPLSIIGYIR".equals(new LeetCode6_1().convert("PAYPALISHIRING", 3)));
        System.out.println("PINALSIGYAHRPI".equals(new LeetCode6_1().convert("PAYPALISHIRING", 4)));
        System.out.println("A".equals(new LeetCode6_1().convert("A", 1)));
    }

}
