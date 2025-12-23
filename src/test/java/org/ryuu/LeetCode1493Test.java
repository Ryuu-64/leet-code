package org.ryuu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ryuu.slidingwindow.variablesize.LeetCode1493;

class LeetCode1493Test {
    @Test
    void test() {
        LeetCode1493.Solution solution = new LeetCode1493.Solution();
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int longest = solution.longestSubarray(nums);
        Assertions.assertEquals(5, longest);
    }
}
