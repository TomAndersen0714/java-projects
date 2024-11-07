package leetcode.second.easy;

import leetcode.common.Util;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/**
 * @author TomAndersen
 */
public class LeetCode1 {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(new LeetCode1_1().twoSum(Util.strToArray("[2,7,11,15]"), 9), Util.strToArray("[0,1]")));
        System.out.println(Arrays.equals(new LeetCode1_1().twoSum(Util.strToArray("[3,2,4]"), 6), Util.strToArray("[1,2]")));
        System.out.println(Arrays.equals(new LeetCode1_1().twoSum(Util.strToArray("[3,3]"), 6), Util.strToArray("[0,1]")));
    }
}

/**
 * HashMap + Brute Force
 */
class LeetCode1_1 {
    public int[] twoSum(int[] nums, int target) {
        // input
        // exclude boundary situations
        if (nums == null || nums.length < 2) {
            return new int[]{0, 0};
        }

        // transform
        int[] res = {0, 0};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if current value is satisfied, update the result
            int less = target - nums[i];
            if (map.containsKey(less)) {
                res[0] = map.get(less);
                res[1] = i;
                break;
            }
            // if current value is unsatisfied, put it into map
            else {
                map.put(nums[i], i);
            }
        }

        // output
        return res;
    }
}
