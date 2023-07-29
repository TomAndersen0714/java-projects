package algorithm.practice.leetcode;

import java.util.Arrays;

/**
 * 1099. Two Sum Less Than K:
 * https://leetcode.com/problems/two-sum-less-than-k/
 * https://wentao-shao.gitbook.io/leetcode/two-pointers/1099.two-sum-less-than-k
 * <p>
 * tags: easy, array, two pointers
 * <p>
 * Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: A = [34,23,1,24,75,33,54,8], K = 60
 * Output: 58
 * Explanation:
 * We can use 34 and 24 to sum 58 which is less than 60.
 * <p>
 * Example 2:
 * <p>
 * Input: A = [10,20,30], K = 15
 * Output: -1
 * Explanation:
 * In this case it's not possible to get a pair sum less that 15.
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i] <= 1000
 * 1 <= K <= 2000
 *
 * @author TomAndersen
 */
public class LeetCode1099 {
}


/**
 * Sort, Two pointers
 * TC: O(n*log_n), SC: O(1)
 */
class LeetCode1099_1 {
    public int twoSumLessThanK(int[] A, int K) {
        // exclude boundary situation
        if (A == null || A.length <= 1) {
            return -1;
        }

        // handle
        Arrays.sort(A);
        int res = -1;
        int left = 0, right = A.length - 1;

        // presume the left pointer is cursor
        while (left < right) {
            int curSum = A[left] + A[right];
            if (curSum < K) {
                // if current sum is closer, move the left pointer
                if (curSum > res) {
                    res = curSum;
                }

                left += 1;
            }
            else {
                right -= 1;
            }
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1099_1().twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60) == 58);
        System.out.println(new LeetCode1099_1().twoSumLessThanK(new int[]{10, 20, 30}, 15) == -1);
    }
}
