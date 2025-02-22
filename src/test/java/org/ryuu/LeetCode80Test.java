package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode80Test {
    private final LeetCode80.DoublePointer doublePointer = new LeetCode80.DoublePointer();

    @Test
    void removeElement() {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int expected1 = 5;
        assertEquals(expected1, doublePointer.removeDuplicates(nums1));

        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int expected2 = 7;
        assertEquals(expected2, doublePointer.removeDuplicates(nums2));

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8};
        int expected3 = 8;
        assertEquals(expected3, doublePointer.removeDuplicates(nums3));
    }
}