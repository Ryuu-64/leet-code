package org.ryuu;

import org.junit.jupiter.api.Test;
import org.ryuu.LeetCode88.DoublePointer;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode88Test {
    private final DoublePointer doublePointer = new DoublePointer();

    @Test
    void merge() {
        int[] nums11 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums21 = {2, 5, 6};
        int n1 = 3;
        int[] expected1 = {1, 2, 2, 3, 5, 6};
        doublePointer.merge(nums11, m1, nums21, n1);
        assertArrayEquals(expected1, nums11);

        int[] nums12 = {1};
        int m2 = 1;
        int[] nums22 = {};
        int n2 = 0;
        int[] expected2 = {1};
        doublePointer.merge(nums12, m2, nums22, n2);
        assertArrayEquals(expected2, nums12);

        int[] nums13 = {0};
        int m3 = 0;
        int[] nums23 = {1};
        int n3 = 1;
        int[] expected3 = {1};
        doublePointer.merge(nums13, m3, nums23, n3);
        assertArrayEquals(expected3, nums13);
    }
}