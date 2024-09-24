package leetcode.one;

/**
 * 209. Minimum Size Subarray Sum: https://leetcode.com/problems/minimum-size-subarray-sum/
 * <p>
 * tags: medium, array，two pointers
 *
 * @author TomAndersen
 */
public class LeetCode209 {
}

/**
 * Brute force and little pruning: 18 / 21 testcases passed
 * TC: O(n*n), SC: O(1)
 */
class LeetCode209_1 {
    public int minSubArrayLen(int target, int[] nums) {
        // exclude boundary situation
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // iterate and pruning
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];

            // if current element is greater than or equal to target
            if (sum >= target) {
                minLen = 1;
                break;
            }

            // add next elements into subarray
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }

        // return
        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode209_1().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) == 2);
        System.out.println(new LeetCode209_1().minSubArrayLen(4, new int[]{1, 4, 4}) == 1);
        System.out.println(new LeetCode209_1().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}) == 0);
    }
}


/**
 * Two pointers, left as the cursor
 * TC: O(n), SC: O(1)
 */
class LeetCode209_2 {
    public int minSubArrayLen(int target, int[] nums) {
        // exclude boundary situation
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // two pointers
        // left point to the first element of subarray as a cursor, right point to the last
        // element of subarray
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = nums[right];
        while (left <= right && right < nums.length) {
            // if found an alternative subarray, then try to update
            if (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);

                // go to next iteration
                sum -= nums[left];
                left += 1;
            }
            else {
                right += 1;
                if (right < nums.length) {
                    sum += nums[right];
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        // return
        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode209_2().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) == 2);
        System.out.println(new LeetCode209_2().minSubArrayLen(4, new int[]{1, 4, 4}) == 1);
        System.out.println(new LeetCode209_2().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}) == 0);
    }

}

/**
 * Two pointers, right as the cursor
 * TC: O(n), SC: O(1)
 */
class LeetCode209_3 {
    public int minSubArrayLen(int target, int[] nums) {
        // exclude boundary situation
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // two pointers
        // left point to the first element, and right point to the last element
        // right is the cursor
        int minLen = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int right = 0; right < nums.length; right += 1) {
            sum += nums[right];

            // move left point continuously
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left += 1;
            }
        }

        // return
        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode209_3().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) == 2);
        System.out.println(new LeetCode209_3().minSubArrayLen(4, new int[]{1, 4, 4}) == 1);
        System.out.println(new LeetCode209_3().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}) == 0);
    }
}