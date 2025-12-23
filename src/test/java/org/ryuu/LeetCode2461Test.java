package org.ryuu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ryuu.slidingwindow.fixedsize.LeetCode2461;

class LeetCode2461Test {
    @Test
    public void maximumSubarraySum() {
        LeetCode2461.Solution solution = new LeetCode2461.Solution();
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        long sum = solution.maximumSubarraySum(nums, k);
        Assertions.assertEquals(15, sum);
    }
}
