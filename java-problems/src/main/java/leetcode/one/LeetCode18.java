package leetcode.one;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum: https://leetcode.com/problems/4sum/
 * <p>
 * tags: medium, array
 *
 * @author TomAndersen
 */
public class LeetCode18 {
}

/**
 * Three pointers
 * TC:O(n*n*n), SC: O(n)
 */
class LeetCode18_1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // exclude boundary situation
        if (nums == null || nums.length <= 3) {
            return new ArrayList<>();
        }

        // sort the array and iterate using four pointers
        List<List<Integer>> combinations = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < length - 3; i++) {

            // skip duplicate elements in current position
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            // solve the three sum sub-problem in sorted subarray
            // to avoid integer overflow, using the long type to store target
            List<List<Integer>> lists = threeSum(nums, i + 1, (long) target - nums[i]);
            for (List<Integer> list : lists) {
                list.add(nums[i]);
                combinations.add(list);
            }
        }


        // return
        return combinations;
    }

    private List<List<Integer>> threeSum(int[] nums, int start, long threeSumTarget) {

        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = start; i < nums.length - 2; i++) {

            // skip duplicate elements in current position
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }

            // to avoid integer overflow, using the long type to store target
            long twoSumTarget = threeSumTarget - nums[i];
            int left = i + 1, right = nums.length - 1;

            // solve the two sum sub-problem
            while (left < right) {
                // skip duplicate elements in current position
                if (left > i + 1 && nums[left - 1] == nums[left]) {
                    left += 1;
                    continue;
                }

                int val = nums[left] + nums[right];
                if (val > twoSumTarget) {
                    right -= 1;
                }
                else if (val < twoSumTarget) {
                    left += 1;
                }
                else {
                    // add current combination into list
                    List<Integer> combination = new ArrayList<>();
                    combination.add(nums[i]);
                    combination.add(nums[left]);
                    combination.add(nums[right]);
                    combinations.add(combination);
                    left += 1;
                }
            }
        }

        return combinations;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode18_1().fourSum(new int[]{-2, -1, 0, 0, 1, 2}, 0));
        System.out.println(new LeetCode18_1().fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println(new LeetCode18_1().fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
        System.out.println(new LeetCode18_1().fourSum(new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000}, 294967296));
    }
}


/**
 * Two pointers
 * TC:O(n*n*n), SC: O(n)
 */
class LeetCode18_2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // exclude boundary situation
        if (nums == null || nums.length <= 3) {
            return new ArrayList<>();
        }

        // sort the array, and simplify the problem to multiple two sum sub-problem
        Arrays.sort(nums);
        List<List<Integer>> combinations = new ArrayList<>();
        int length = nums.length;

        for (int i = 0; i < length - 3; i += 1) {
            // skip duplicate elements in current position
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j += 1) {
                // skip duplicate elements in current position
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                // solve the two sum sub-problem
                // using longer type to avoid integer overflow
                long twoSum = (long) target - nums[i] - nums[j];
                int left = j + 1, right = length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > twoSum) {
                        right -= 1;
                    }
                    else if (nums[left] + nums[right] < twoSum) {
                        left += 1;
                    }
                    else {
                        // add the current combination, and move the left pointer forward
                        List<Integer> combination = new ArrayList<>();
                        combination.add(nums[i]);
                        combination.add(nums[j]);
                        combination.add(nums[left]);
                        combination.add(nums[right]);
                        combinations.add(combination);
                        left += 1;

                        // skip duplicate elements in current position
                        while (left < right && nums[left - 1] == nums[left]) {
                            left += 1;
                        }
                    }
                }
            }
        }

        // return
        return combinations;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode18_2().fourSum(new int[]{-2, -1, 0, 0, 1, 2}, 0));
        System.out.println(new LeetCode18_2().fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println(new LeetCode18_2().fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
        System.out.println(new LeetCode18_2().fourSum(new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000}, 294967296));
    }
}