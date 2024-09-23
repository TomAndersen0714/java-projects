package algorithm.practice.leetcode;

/**
 * 2348. Number of Zero-Filled Subarrays:
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/
 * <p>
 * tags: DP
 *
 * @author TomAndersen
 */
public class LeetCode2348 {

}

/**
 * 2348. Number of Zero-Filled Subarrays
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/
 * <p>
 * tags: DP
 *
 * @author TomAndersen
 */
class LeetCode2348_1 {
    public long zeroFilledSubarray(int[] nums) {
        // declare assistant variables
        long count = 0;
        long zeros = 0;

        // traverse the array
        for (int num : nums) {
            // count the continuous zero
            if (num == 0) {
                zeros += 1;
            }
            else {
                count += combinations(zeros);
                zeros = 0;
            }
        }
        // boundary
        count += combinations(zeros);

        // return
        return count;
    }

    private long combinations(long len) {
        long combine = 0;
        for (int i = 1; i <= len; i++) {
            combine += len - i + 1;
        }
        return combine;
    }
}

/**
 * @author TomAndersen
 */
class LeetCode2348_2 {
    /**
     * using recursion formula
     *
     * @param nums
     * @return
     */
    public long zeroFilledSubarray(int[] nums) {
        // declare assistant variables
        long count = 0;
        long zeros = 0;

        // traverse the array
        for (int num : nums) {
            // count the continuous zero
            if (num == 0) {
                zeros += 1;
            }
            else {
                count += combinations(zeros);
                zeros = 0;
            }
        }
        // boundary
        count += combinations(zeros);

        // return
        return count;
    }

    private long combinations(long n) {
        return n * (n + 1) / 2;
    }
}
