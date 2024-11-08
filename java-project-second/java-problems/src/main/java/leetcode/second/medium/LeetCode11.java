package leetcode.second.medium;

import leetcode.common.Util;

/**
 * 11. Container With Most Water, 盛水最多的容器
 * https://leetcode.com/problems/container-with-most-water/
 *
 * @author TomAndersen
 */
public class LeetCode11 {
    public static void main(String[] args) {
        int[] input;
        int output;

        input = Util.strToArray("[1,1]");
        output = 1;
        System.out.println(new LeetCode11_1().maxArea(input) == output);

        input = Util.strToArray("[1,8,6]");
        output = 6;
        System.out.println(new LeetCode11_1().maxArea(input) == output);

        input = Util.strToArray("[1,8,6,2,5,4,8,3,7]");
        output = 49;
        System.out.println(new LeetCode11_1().maxArea(input) == output);

        input = Util.strToArray("[1,1]");
        output = 1;
        System.out.println(new LeetCode11_2().maxArea(input) == output);

        input = Util.strToArray("[1,8,6]");
        output = 6;
        System.out.println(new LeetCode11_2().maxArea(input) == output);

        input = Util.strToArray("[1,8,6,2,5,4,8,3,7]");
        output = 49;
        System.out.println(new LeetCode11_2().maxArea(input) == output);

        input = Util.strToArray("[1,1]");
        output = 1;
        System.out.println(new LeetCode11_3().maxArea(input) == output);

        input = Util.strToArray("[1,8,6]");
        output = 6;
        System.out.println(new LeetCode11_3().maxArea(input) == output);

        input = Util.strToArray("[1,8,6,2,5,4,8,3,7]");
        output = 49;
        System.out.println(new LeetCode11_3().maxArea(input) == output);
    }
}

/**
 * Iteration + Pruning
 */
class LeetCode11_1 {
    public int maxArea(int[] height) {
        // input
        if (height == null || height.length <= 1) {
            return 0;
        }

        // transform
        int max = 0;
        // max = Math.max(max, (right - left) * Math.min(height[left], height[right]));

        for (int left = 0; left < height.length; left += 1) {
            for (int right = height.length - 1; right > left; right -= 1) {
                max = Math.max(max, (right - left) * Math.min(height[left], height[right]));

                // skip impossible situations
                while (right - 1 > left && height[right - 1] < height[right]) {
                    right -= 1;
                }
            }

            // skip impossible situations
            while (left + 1 < height.length && height[left + 1] < height[left]) {
                left += 1;
            }
        }

        // output
        return max;
    }
}

/**
 * Iteration + Pruning
 */
class LeetCode11_2 {
    public int maxArea(int[] height) {
        // input
        if (height == null || height.length <= 1) {
            return 0;
        }

        // transform
        int max = 0;
        for (int left = 0; left < height.length; left += 1) {
            for (int right = height.length - 1; right > left; right -= 1) {
                max = Math.max(max, (right - left) * Math.min(height[left], height[right]));

                // skip impossible situations, i.e. do not effect the result
                while (right - 1 > left && (height[right - 1] < height[right] || height[right] > height[left])) {
                    right -= 1;
                }
            }

            // skip impossible situations
            while (left + 1 < height.length && (height[left + 1] < height[left])) {
                left += 1;
            }
        }

        // output
        return max;
    }
}

/**
 * Two pointers
 */
class LeetCode11_3 {
    public int maxArea(int[] height) {
        // input
        if (height == null || height.length <= 1) {
            return 0;
        }

        // transform
        int max = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left += 1;
            }
            else {
                right -= 1;
            }
        }

        // output
        return max;
    }
}
