package algorithm.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum:
 * https://leetcode.com/problems/two-sum/
 * <p>
 * tags: easy, array, two pointers
 *
 * @author TomAndersen
 */
public class LeetCode1 {
}

class LeetCode1_1 {
    // brute force
    public int[] twoSum(int[] nums, int target) {
        // exclude boundary condition
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        // handle
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode1_1().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new LeetCode1_1().twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(new LeetCode1_1().twoSum(new int[]{3, 3}, 6)));
    }
}

class LeetCode1_2 {
    // hashMap
    public int[] twoSum(int[] nums, int target) {
        // exclude boundary condition
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        // handle
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int least = target - nums[i];
            if (!map.containsKey(least)) {
                map.put(nums[i], i);
            }
            else {
                return new int[]{map.get(least), i};
            }
        }

        // handle exception
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new LeetCode1_2().twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}));
        System.out.println(Arrays.equals(new LeetCode1_2().twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        System.out.println(Arrays.equals(new LeetCode1_2().twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
    }
}
