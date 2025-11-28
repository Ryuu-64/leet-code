package org.ryuu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LeetCode209Test {

    @Test
    void minSubArrayLen() {
        LeetCode209 leetCode209 = new LeetCode209();
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int ans = leetCode209.minSubArrayLen(target, nums);
        Assertions.assertEquals(2, ans);

        target = 4;
        nums = new int[]{1, 4, 4};
        ans = leetCode209.minSubArrayLen(target, nums);
        Assertions.assertEquals(1, ans);

        target = 11;
        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        ans = leetCode209.minSubArrayLen(target, nums);
        Assertions.assertEquals(0, ans);
    }
}
