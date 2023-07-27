package algorithm.practice.leetcode;

/**
 * 704. Binary Search: https://leetcode.com/problems/binary-search/
 * <p>
 * tags: easy, array, binary search
 *
 * @author TomAndersen
 */
public class LeetCode704 {
}

/**
 * Binary Search using two pointers
 */
class LeetCode704_1 {
    public int search(int[] nums, int target) {
        // exclude boundary condition
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return -1;
        }

        // binary search using two pointers
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            index = left + (right - left) / 2;
            if (nums[index] < target) {
                left = index + 1;
            }
            else if (nums[index] > target) {
                right = index - 1;
            }
            else break;
        }

        // if no found
        if (nums[index] != target) {
            index = -1;
        }

        // return
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode704_1().search(new int[]{-1, 0, 3, 5, 9, 12}, 9) == 4);
        System.out.println(new LeetCode704_1().search(new int[]{-1, 0, 3, 5, 9, 12}, 2) == -1);
    }
}
