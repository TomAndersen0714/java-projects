package algorithm.practice.leetcode;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * @author TomAndersen
 */
public class LeetCode6_2 {
    public String convert(String s, int numRows) {
        // boundary
        if (s == null || s.length() == 0 || numRows == 0) {
            return null;
        }
        if (numRows == 1) {
            return s;
        }

        // handle
        StringBuilder sb = new StringBuilder();
        int cycle = numRows * 2 - 2, len = s.length();
        // first row
        for (int i = 0; i < len; i += cycle) {
            sb.append(s.charAt(i));
        }

        // middle row
        for (int row = 1; row < numRows - 1; row++) {
            int distance = 2 * (numRows - row - 1);

            for (int i = row; i < len; i += cycle) {
                int left = i;
                sb.append(s.charAt(left));

                int right = i + distance;
                if (right < len) {
                    sb.append(s.charAt(right));
                }
            }
        }

        // last row
        for (int i = numRows - 1; i < len; i += cycle) {
            sb.append(s.charAt(i));
        }

        // output
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode6_2().convert("PAYPALISHIRING", 4));
        System.out.println("PAHNAPLSIIGYIR".equals(new LeetCode6_2().convert("PAYPALISHIRING", 3)));
        System.out.println("PINALSIGYAHRPI".equals(new LeetCode6_2().convert("PAYPALISHIRING", 4)));
        System.out.println("A".equals(new LeetCode6_2().convert("A", 1)));
    }
}
