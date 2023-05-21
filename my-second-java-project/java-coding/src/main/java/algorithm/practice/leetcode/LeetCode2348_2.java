package algorithm.practice.leetcode;

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
