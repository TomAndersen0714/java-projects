package algorithm.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 15. 3Sum: https://leetcode.com/problems/3sum/
 * <p>
 * tags: medium, array, two pointers
 *
 * @author TomAndersen
 */
public class LeetCode15 {
}

/**
 * Sort, Binary Search
 * TC: O(n*n*log_n), SC: O(1)
 */
class LeetCode15_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        // exclude boundary condition
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        // handle
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = -(nums[i] + nums[j]);
                int idx = Arrays.binarySearch(nums, j + 1, nums.length, target);
                if (idx > 0) {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]);
                    tuple.add(nums[j]);
                    tuple.add(nums[idx]);
                    res.add(tuple);
                }

                // skip duplicate elements to avoid duplicate tuple
                while (j + 1 < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j += 1;
                }
            }

            // skip duplicate elements to avoid duplicate tuple
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i += 1;
            }
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode15_1().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new LeetCode15_1().threeSum(new int[]{0, 1, 1}));
        System.out.println(new LeetCode15_1().threeSum(new int[]{0, 0, 0}));
    }
}


/**
 * Sort, Two pointers
 * TC: O(n*n), SC: O(1)
 */
class LeetCode15_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        // exclude boundary condition
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        // handle
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left += 1;
                }
                else if (nums[left] + nums[right] > target) {
                    right -= 1;
                }
                else {
                    // List<Integer> tuple = new ArrayList<>();
                    // tuple.add(nums[i]);
                    // tuple.add(nums[left]);
                    // tuple.add(nums[right]);
                    // res.add(tuple);

                    // left memory but more runtime using Arrays.asList or List.of:
                    // Arrays.asList
                    // res.add(Arrays.asList(nums[i], nums[left],nums[right]));
                    // List.of
                    res.add(List.of(nums[i], nums[left], nums[right]));

                    // there might be multiple tuples
                    left += 1;
                    right -= 1;

                    // skip duplicate elements in second and third position to avoid duplicate tuple
                    while (left < right && nums[left] == nums[left - 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right -= 1;
                    }
                }
            }

            // skip duplicate elements in first position to avoid duplicate tuple
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i += 1;
            }
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode15_2().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new LeetCode15_2().threeSum(new int[]{0, 1, 1}));
        System.out.println(new LeetCode15_2().threeSum(new int[]{0, 0, 0}));
    }
}