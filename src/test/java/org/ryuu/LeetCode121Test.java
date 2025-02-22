package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode121Test {
    @Test
    void maxProfit() {
        LeetCode121 leetCode121 = new LeetCode121();

        int[] nums1 = {7, 1, 5, 3, 6, 4};
        int expected1 = 5;
        assertEquals(expected1, leetCode121.maxProfit(nums1));

        int[] nums2 = {7, 6, 4, 3, 1};
        int expected2 = 0;
        assertEquals(expected2, leetCode121.maxProfit(nums2));
    }
}