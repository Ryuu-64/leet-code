package org.ryuu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ryuu.slidingwindow.fixedsize.LeetCode2841;

import java.util.ArrayList;
import java.util.List;

class LeetCode2841Test {
    @Test
    void maxSum() {
        LeetCode2841.Solution solution = new LeetCode2841.Solution();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        int m = 1;
        int k = 1;
        long actual = solution.maxSum(nums, m, k);
        Assertions.assertEquals(1, actual);
    }
}
