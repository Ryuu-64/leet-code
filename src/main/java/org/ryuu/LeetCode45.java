package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/jump-game-ii/description/"></a>
 * <a href="https://en.wikipedia.org/wiki/Greedy_algorithm"></a>
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        int res = 0;
        int curr = 0;
        int next = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            next = Math.max(next, i + nums[i]);
            if (i == curr) {
                curr = next;
                res++;
            }
        }

        return res;
    }
}
