package leetcode.second.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 3Sum: https://leetcode.com/problems/3sum/
 * <p>
 * tags: medium, array, two pointers
 *
 * @author TomAndersen
 */
public class LeetCode15 {

    public static void main(String[] args) {
        int[] ints = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("new LeetCode15_1().threeSum(ints) = " + new LeetCode15_1().threeSum(ints));

        ints = new int[]{-2, 0, 0, 2, 2};
        System.out.println("new LeetCode15_1().threeSum(ints) = " + new LeetCode15_1().threeSum(ints));
    }
}

/**
 * Reduce dimension + two pointers
 */
class LeetCode15_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        // input
        // exclude boundary situation
        if (nums == null || nums.length < 3) {
            return null;
        }

        // solve
        List<List<Integer>> res = new LinkedList<>();
        // reduce dimension
        Arrays.sort(nums);
        int left, right, target;
        for (int cursor = 0; cursor < nums.length - 2; cursor++) {

            left = cursor + 1;
            right = nums.length - 1;
            target = -nums[cursor];

            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left += 1;
                }
                else if (nums[left] + nums[right] > target) {
                    right -= 1;
                }
                else {
                    // nums[left] + nums[right] == target and left < right
                    res.add(List.of(nums[cursor], nums[left], nums[right]));
                    left += 1;
                    right -= 1;

                    // if next value is same as previous, then skip
                    while (left < right && nums[left] == nums[left - 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right -= 1;
                    }
                }
            }

            // skip duplicate elements
            while (cursor + 1 < nums.length - 2 && nums[cursor + 1] == nums[cursor]) {
                cursor += 1;
            }
        }

        // output
        return res;
    }
}
