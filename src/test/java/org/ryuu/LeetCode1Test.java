package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode1Test {

    @Test
    void twoSum() {
        LeetCode1 leetCode1 = new LeetCode1();

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {0, 1};
        assertArrayEquals(leetCode1.twoSum(nums1, target1), expected1);

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] expected2 = {1, 2};
        assertArrayEquals(leetCode1.twoSum(nums2, target2), expected2);

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] expected3 = {0, 1};
        assertArrayEquals(leetCode1.twoSum(nums3, target3), expected3);
    }
}