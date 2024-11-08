package leetcode.second.hard;

import leetcode.common.Util;

/**
 * 42. Trapping Rain Water, 接雨水
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * @author TomAndersen
 */
public class LeetCode42 {
    public static void main(String[] args) {
        int[] input;
        int expect;

        input = Util.strToArray("[0,1,0,2,1,0,1,3,2,1,2,1]");
        expect = 6;
        System.out.println(new LeetCode42_1().trap(input) == expect);

        input = Util.strToArray("[4,2,0,3,2,5]");
        expect = 9;
        System.out.println(new LeetCode42_1().trap(input) == expect);
    }
}

/**
 * Iterate triple times
 */
class LeetCode42_1 {
    public int trap(int[] height) {
        // input
        if (height == null || height.length <= 2) {
            return 0;
        }

        // transform
        int sum = 0, trap, length = height.length;
        int leftCurMax = 0, rightCurMax = 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        for (int i = 0; i < length; i++) {
            leftCurMax = Math.max(leftCurMax, height[i]);
            leftMax[i] = leftCurMax;

            int j = length - i - 1;
            rightCurMax = Math.max(rightCurMax, height[j]);
            rightMax[j] = rightCurMax;
        }

        // calculate
        for (int i = 0; i < length; i++) {
            trap = Math.min(leftMax[i], rightMax[i]);
            if (trap > height[i]) {
                sum += (trap - height[i]);
            }
        }

        // output
        return sum;
    }
}
