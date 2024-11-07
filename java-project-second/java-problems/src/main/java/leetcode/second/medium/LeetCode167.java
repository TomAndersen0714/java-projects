package leetcode.second.medium;

import leetcode.common.Util;
import java.util.Arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * @author TomAndersen
 */
public class LeetCode167 {
    public static void main(String[] args) {
        int[] nums, expect;
        int target;

        nums = Util.strToArray("[2,7,11,15]");
        target = 9;
        expect = Util.strToArray("[1,2]");
        System.out.println(Arrays.equals(new LeetCode167_1().twoSum(nums, target), expect));

        nums = Util.strToArray("[2,3,4]");
        target = 6;
        expect = Util.strToArray("[1,3]");
        System.out.println(Arrays.equals(new LeetCode167_1().twoSum(nums, target), expect));

        nums = Util.strToArray("[-1,0]");
        target = -1;
        expect = Util.strToArray("[1,2]");
        System.out.println(Arrays.equals(new LeetCode167_1().twoSum(nums, target), expect));


        nums = Util.strToArray("[2,7,11,15]");
        target = 9;
        expect = Util.strToArray("[1,2]");
        System.out.println(Arrays.equals(new LeetCode167_2().twoSum(nums, target), expect));

        nums = Util.strToArray("[2,3,4]");
        target = 6;
        expect = Util.strToArray("[1,3]");
        System.out.println(Arrays.equals(new LeetCode167_2().twoSum(nums, target), expect));

        nums = Util.strToArray("[-1,0]");
        target = -1;
        expect = Util.strToArray("[1,2]");
        System.out.println(Arrays.equals(new LeetCode167_2().twoSum(nums, target), expect));
    }
}

/**
 * Two pointers.
 */
class LeetCode167_1 {
    public int[] twoSum(int[] numbers, int target) {
        // input
        // exclude boundary situations
        if (numbers == null || numbers.length < 2) {
            return new int[]{0, 0};
        }

        // transform
        int[] res = new int[]{0, 0};
        int left = 0, right = numbers.length - 1, curSum;
        while (left < right) {
            curSum = numbers[left] + numbers[right];
            if (curSum < target) {
                left += 1;
            }
            else if (curSum > target) {
                right -= 1;
            }
            else {
                // update the result and break out
                res[0] = left;
                res[1] = right;
                break;
            }
        }

        // output
        // cause the result is 1-indexed array, index need to start from 1
        res[0] += 1;
        res[1] += 1;
        return res;
    }
}

/**
 * Iterate + Binary Research
 */
class LeetCode167_2 {
    public int[] twoSum(int[] numbers, int target) {
        // input
        if (numbers == null || numbers.length < 2) {
            return new int[]{0, 0};
        }

        // transform
        int[] res = new int[2];
        int rightIdx;
        for (int i = 0; i < numbers.length; i++) {
            rightIdx = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);

            // update the result when find a solution, then break out
            if (rightIdx > 0) {
                res[0] = i;
                res[1] = rightIdx;
                break;
            }
        }

        // output
        res[0] += 1;
        res[1] += 1;
        return res;
    }
}
