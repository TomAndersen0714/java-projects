package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author TomAndersen
 */
class _LeetCode_2348_1Test {

    @Test
    void zeroFilledSubarray() {
        int[] nums = new int[]{1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println(new LeetCode2348_1().zeroFilledSubarray(nums));
    }
}