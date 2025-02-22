package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode35Test {
    private final LeetCode35.BinarySearch binarySearch = new LeetCode35.BinarySearch();

    @Test
    void searchInsert() {
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 2;
        int expected1 = 1;
        assertEquals(expected1, binarySearch.searchInsert(nums1, target1));

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 7;
        int expected2 = 4;
        assertEquals(expected2, binarySearch.searchInsert(nums2, target2));
    }
}