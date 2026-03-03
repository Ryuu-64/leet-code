package org.ryuu.base.array;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-distance-in-arrays/description/">624. 数组列表中的最大距离</a>
 */
public class LeetCode624 {
    public static class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            int ans = 0;
            // 防溢出
            int lastMin = Integer.MAX_VALUE / 2;
            int lastMax = Integer.MIN_VALUE / 2;
            for (List<Integer> array : arrays) {
                int currMin = array.getFirst();
                int currMax = array.getLast();
                ans = Math.max(Math.max(currMax - lastMin, lastMax - currMin), ans);
                lastMin = Math.min(currMin, lastMin);
                lastMax = Math.max(currMax, lastMax);
            }
            return ans;
        }
    }
}
