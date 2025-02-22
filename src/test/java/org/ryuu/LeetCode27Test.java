package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode27Test {
    private final LeetCode27.DoublePointer doublePointer = new LeetCode27.DoublePointer();

    @Test
    void removeElement() {
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int expected1 = 2;
        assertEquals(expected1, doublePointer.removeElement(nums1, val1));

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int expected2 = 5;
        assertEquals(expected2, doublePointer.removeElement(nums2, val2));
    }
}