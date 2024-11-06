package leetcode.second.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static leetcode.common.Util.compareList;
import static leetcode.common.Util.strToListList;

/**
 * 15. 3Sum: https://leetcode.com/problems/3sum/
 * <p>
 * tags: medium, array, two pointers
 *
 * @author TomAndersen
 */
public class LeetCode15 {

    public static void main(String[] args) {
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        String expect = "[[-1,-1,2],[-1,0,1]]";

        System.out.println(compareList(new LeetCode15_1().threeSum(input), strToListList(expect)));

        input = new int[]{0, 1, 1};
        expect = "[]";
        System.out.println(compareList(new LeetCode15_1().threeSum(input), strToListList(expect)));

        input = new int[]{0, 0, 0};
        expect = "[[0,0,0]]";
        System.out.println(compareList(new LeetCode15_1().threeSum(input), strToListList(expect)));
    }
}

/**
 * Reduce dimension + two pointers
 */
class LeetCode15_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        // input
        LinkedList<List<Integer>> res = new LinkedList<>();
        // exclude boundary situation
        if (nums == null || nums.length < 3) {
            return res;
        }

        // transform
        // simplify the problems, T: O(log_2_N)
        Arrays.sort(nums);
        int cursor = 0, left, right, twoSumTarget;
        while (cursor < nums.length - 2) {
            left = cursor + 1;
            right = nums.length - 1;
            twoSumTarget = -nums[cursor];
            while (left < right) {

                int twoSum = nums[left] + nums[right];
                if (twoSum == twoSumTarget) {
                    res.add(List.of(nums[cursor], nums[left], nums[right]));
                    left += 1;
                    right -= 1;

                    // skip duplicate combination, i.e. if next value is same with previous, skip it
                    while (left < right && nums[left] == nums[left - 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right -= 1;
                    }
                }
                else if (twoSum < twoSumTarget) {
                    left += 1;
                }
                else {
                    right -= 1;
                }
            }

            // skip duplicate combinations
            cursor += 1;
            while (cursor < nums.length - 2 && nums[cursor] == nums[cursor - 1]) {
                cursor += 1;
            }
        }

        // output
        return res;
    }
}
