package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode189Test {
    private final LeetCode189.ArrayFlip arrayFlip = new LeetCode189.ArrayFlip();

    @Test
    void rotate() {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] expected1 = {5, 6, 7, 1, 2, 3, 4};
        arrayFlip.rotate(nums1, k1);
        assertArrayEquals(expected1, nums1);

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        int[] expected2 = {3, 99, -1, -100};
        arrayFlip.rotate(nums2, k2);
        assertArrayEquals(expected2, nums2);
    }
}