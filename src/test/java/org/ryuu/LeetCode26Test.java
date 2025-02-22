package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode26Test {
    private final LeetCode26.FastSlowPointer fastSlowPointer = new LeetCode26.FastSlowPointer();

    @Test
    void removeDuplicates() {
        int[] nums1 = {1, 1, 2};
        int expected1 = 2;
        assertEquals(expected1, fastSlowPointer.removeDuplicates(nums1));

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int expected2 = 5;
        assertEquals(expected2, fastSlowPointer.removeDuplicates(nums2));
    }
}