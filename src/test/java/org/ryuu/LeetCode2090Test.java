package org.ryuu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ryuu.slidingwindow.fixedsize.LeetCode2090;

class LeetCode2090Test {
    @Test
    void getAverages() {
        LeetCode2090.Solution1For solution1For = new LeetCode2090.Solution1For();
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int k = 3;
        int[] actual = solution1For.getAverages(nums, k);
        int[] expected = {-1, -1, -1, 5, 4, 4, -1, -1, -1};
        Assertions.assertArrayEquals(expected, actual);
    }
}
