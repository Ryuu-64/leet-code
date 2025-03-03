package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/jump-game/description/"></a>
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIdx) {
                return false;
            }

            int num = nums[i];
            maxIdx = Math.max(maxIdx, i + num);
            if (maxIdx < length - 1) {
                continue;
            }

            return true;
        }

        return false;
    }
}
