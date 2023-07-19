package algorithm.practice.leetcode;

import java.util.Arrays;

/**
 * 1099. Two Sum Less Than K:
 * https://leetcode.com/problems/two-sum-less-than-k/
 * https://wentao-shao.gitbook.io/leetcode/two-pointers/1099.two-sum-less-than-k
 * <p>
 * tags: easy, array, two pointers
 *
 * @author TomAndersen
 */
public class LeetCode1099 {
}


/**
 * Sort, Two pointers
 * TC: O(n), SC: O(1)
 */
class LeetCode1099_1 {
    public int twoSumLessThanK(int[] A, int K) {
        // exclude boundary condition
        if (A == null || A.length <= 1) {
            return -1;
        }

        // handle
        Arrays.sort(A);
        int res = -1;
        int left = 0, right = A.length - 1;

        while (left < right) {

        }


        // return
        return res;
    }

    public static void main(String[] args) {

    }
}
