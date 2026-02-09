package org.ryuu.base.array;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock">2016. 增量元素之间的最大差值</a>
 */
public class LeetCode2016 {
    public static class Solution {
        public int maximumDifference(int[] nums) {
            int maxDiff = 0;
            int preMin = Integer.MAX_VALUE;
            for (int num : nums) {
                maxDiff = Math.max(num - preMin, maxDiff);
                preMin = Math.min(num, preMin);
            }
            return maxDiff > 0 ? maxDiff : -1;
        }
    }
}
