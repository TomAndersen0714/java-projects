package leetcode.second.medium;

import java.util.Arrays;

import static leetcode.common.Util.strToArray;

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * @author TomAndersen
 */
public class LeetCode16 {
    public static void main(String[] args) {
        System.out.println(new LeetCode16_1().threeSumClosest(strToArray("[-1,2,1,-4]"), 1) == 2);
        System.out.println(new LeetCode16_1().threeSumClosest(strToArray("[0,0,0]"), 1) == 0);
        System.out.println(new LeetCode16_1().threeSumClosest(strToArray("[0,1,2]"), 3) == 3);
        System.out.println(new LeetCode16_1().threeSumClosest(strToArray("[1,1,1,0]"), 3) == 3);
        System.out.println(new LeetCode16_1().threeSumClosest(strToArray("[4,0,5,-5,3,3,0,-4,-5]"), -2) == -2);
    }
}

/**
 * Reduce dimension + two pointers
 */
class LeetCode16_1 {
    public int threeSumClosest(int[] nums, int target) {
        // input
        // exclude boundary situations
        if (nums == null || nums.length <= 2) {
            return 0;
        }

        // transform
        Arrays.sort(nums);
        int left, right;
        int res = nums[0] + nums[1] + nums[nums.length - 1], minDist = Math.abs(res - target);
        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length - 1;
            // try to converge by iteration all possible coordinates
            while (left < right) {
                // update the result when meet closer coordinates
                int curSum = nums[i] + nums[left] + nums[right];
                int curtDist = Math.abs(curSum - target);
                if (curtDist < minDist) {
                    res = curSum;
                    minDist = curtDist;
                }

                // try to find closer coordinates
                if (curSum < target) {
                    left += 1;
                }
                else if (curSum > target) {
                    right -= 1;
                }
                else {
                    return res;
                }
            }
        }

        // output
        return res;
    }
}
