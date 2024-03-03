package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode53Test {
    @Test
    void maxSubArray() {
        LeetCode53 solution = new LeetCode53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = solution.maxSubArray(nums);
        assertEquals(6, res);
    }
}