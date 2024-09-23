package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element: https://leetcode.com/problems/majority-element/
 * <p>
 * tags: easy, array, sort
 *
 * @author TomAndersen
 */
public class LeetCode169 {
}

/**
 * Sort + Iterate
 * TC: O(n*log_n), SC: O(1)
 */
class LeetCode169_1 {
    public int majorityElement(int[] nums) {
        // exclude boundary situation
        // if(nums == null || nums.length == 0){
        //     return 0;
        // }

        // sort
        Arrays.sort(nums);
        // iterate
        int res = nums[0], length = nums.length, target = length / 2;
        for (int i = 0; i < length; i++) {
            int cnt = 1;
            while (i + 1 < length && nums[i] == nums[i + 1]) {
                cnt += 1;
                i += 1;
            }

            // if target found
            if (cnt > target) {
                res = nums[i];
                break;
            }
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode169_1().majorityElement(new int[]{3, 2, 3}) == 3);
        System.out.println(new LeetCode169_1().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}) == 2);
    }
}

/**
 * HashMap
 * TC: O(n), SC: O(n)
 */
class LeetCode169_2 {
    public int majorityElement(int[] nums) {
        // exclude boundary situation
        // if(nums == null || nums.length == 0){
        //     return 0;
        // }

        // handle
        Map<Integer, Integer> counterMap = new HashMap<>();
        int target = nums.length / 2;
        int res = nums[0];


        for (int num : nums) {
            int cnt = counterMap.getOrDefault(num, 0);
            if (cnt + 1 > target) {
                res = num;
                break;
            }
            else {
                counterMap.put(num, cnt + 1);
            }
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode169_2().majorityElement(new int[]{3, 2, 3}) == 3);
        System.out.println(new LeetCode169_2().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}) == 2);
    }
}

/**
 * Sorting
 * TC: O(n*log_n), SC: O(1)
 */
class LeetCode169_3 {
    public int majorityElement(int[] nums) {
        // sorting
        Arrays.sort(nums);

        // return the majority element, the number of which beyond n/2
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode169_3().majorityElement(new int[]{3, 2, 3}) == 3);
        System.out.println(new LeetCode169_3().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}) == 2);
    }
}

/**
 * Moore's voting algorithm
 * TC: O(n), SC: O(1)
 */
class LeetCode169_4 {
    public int majorityElement(int[] nums) {
        // exclude boundary situation

        // iterate
        int vote = 1, target = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (vote == 0) {
                vote = 1;
                target = nums[i];
            }
            else if (nums[i] == target) {
                vote += 1;
            }
            else {
                vote -= 1;
            }
        }

        // return
        return target;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode169_4().majorityElement(new int[]{3, 2, 3}) == 3);
        System.out.println(new LeetCode169_4().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}) == 2);
    }
}