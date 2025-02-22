package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode169Test {
    private final LeetCode169.BoyerMooreVoting boyerMooreVoting = new LeetCode169.BoyerMooreVoting();

    @Test
    void majorityElement() {
        int[] nums1 = {3, 2, 3};
        int expected1 = 3;
        assertEquals(expected1, boyerMooreVoting.majorityElement(nums1));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int expected2 = 2;
        assertEquals(expected2, boyerMooreVoting.majorityElement(nums2));
    }
}