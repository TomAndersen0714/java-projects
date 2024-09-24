package leetcode.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 229. Majority Element II: https://leetcode.com/problems/majority-element-ii/
 * <p>
 * tags: medium, array
 *
 * @author TomAndersen
 */
public class LeetCode229 {
}


/**
 * Sorting + Iterate
 * TC: O(n*log_n), SC: O(1)
 */
class LeetCode229_1 {
    public List<Integer> majorityElement(int[] nums) {
        // exclude boundary situation
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        // sort and iterate
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int condicate = nums[0], counter = 1, threshold = nums.length / 3;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == condicate) {
                counter += 1;
            }
            else {
                if (counter > threshold) {
                    res.add(condicate);
                }
                condicate = nums[i];
                counter = 1;
            }
        }

        if (counter > threshold) {
            res.add(condicate);
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new LeetCode229_1().majorityElement(new int[]{3, 2, 3}).toArray(), new Integer[]{3}));
        System.out.println(Arrays.equals(new LeetCode229_1().majorityElement(new int[]{1}).toArray(), new Integer[]{1}));
        System.out.println(Arrays.equals(new LeetCode229_1().majorityElement(new int[]{1, 2}).toArray(), new Integer[]{1, 2}));
    }
}

/**
 * HashMap
 * TC: O(n), SC: O(n)
 */
class LeetCode229_2 {
    // omit
}


/**
 * Boyer-Moore vote algorithm
 * TC: O(n), SC: O(1)
 */
class LeetCode229_3 {
    public List<Integer> majorityElement(int[] nums) {
        // exclude boundary situation
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        // Boyer-Moore vote algorithm
        List<Integer> candidates = new ArrayList<>();
        int candidate1 = nums[0], candidate2 = nums[0], counter1 = 0, counter2 = 0;

        // iterate and vote, find
        for (int num : nums) {
            // try to vote existed candidate first
            if (num == candidate1) {
                counter1 += 1;
            }
            else if (num == candidate2) {
                counter2 += 1;
            }
            // if no specific candidate, then try to become the candidate or remove
            else if (counter1 == 0) {
                candidate1 = num;
                counter1 = 1;
            }
            else if (counter2 == 0) {
                candidate2 = num;
                counter2 = 1;
            }
            // remove three distinct value
            else {
                counter1 -= 1;
                counter2 -= 1;
            }
        }

        // check the remaining elements counter
        counter1 = 0;
        counter2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                counter1 += 1;
            }
            else if (num == candidate2) {
                counter2 += 1;
            }
        }

        if (counter1 > nums.length / 3) {
            candidates.add(candidate1);
        }
        if (counter2 > nums.length / 3) {
            candidates.add(candidate2);
        }

        // return
        return candidates;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(new LeetCode229_3().majorityElement(new int[]{3, 2, 3}).toArray(), new Integer[]{3}));
        System.out.println(Arrays.equals(new LeetCode229_3().majorityElement(new int[]{1}).toArray(), new Integer[]{1}));
        System.out.println(Arrays.equals(new LeetCode229_3().majorityElement(new int[]{1, 2}).toArray(), new Integer[]{1, 2}));
        System.out.println(Arrays.equals(new LeetCode229_3().majorityElement(new int[]{2, 1, 1, 3, 1, 4, 5, 6}).toArray(), new Integer[]{1}));

    }
}
