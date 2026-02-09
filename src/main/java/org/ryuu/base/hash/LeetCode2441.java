package org.ryuu.base.hash;

import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/description/">2441. 与对应负数同时存在的最大正整数</a>
 */
public class LeetCode2441 {
    public static class Solution {
        public int findMaxK(int[] nums) {
            int maxK = -1;
            var set = new HashSet<Integer>();
            for (int x : nums) {
                if (set.contains(-x)) {
                    maxK = Math.max(maxK, Math.abs(x));
                }
                set.add(x);
            }
            return maxK;
        }
    }
}
