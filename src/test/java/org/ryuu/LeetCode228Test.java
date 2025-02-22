package org.ryuu;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode228Test {
    private final LeetCode228 leetCode228 = new LeetCode228();

    @Test
    void summaryRanges() {
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        String[] expected1 = {"0->2", "4->5", "7"};
        String[] result1 = leetCode228.summaryRanges(nums1).toArray(new String[0]);
        assertArrayEquals(expected1, result1);

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        String[] expected2 = {"0", "2->4", "6", "8->9"};
        String[] result2 = leetCode228.summaryRanges(nums2).toArray(new String[0]);
        assertArrayEquals(expected2, result2);
    }
}