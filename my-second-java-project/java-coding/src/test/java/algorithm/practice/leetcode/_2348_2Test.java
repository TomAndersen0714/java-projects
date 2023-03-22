package algorithm.practice.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author TomAndersen
 */
class _2348_2Test {

    @Test
    void zeroFilledSubarray() {
        int[] nums = new int[]{1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println(new _2348_2().zeroFilledSubarray(nums));
    }
}