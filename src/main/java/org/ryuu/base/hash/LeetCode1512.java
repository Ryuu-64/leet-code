package org.ryuu.base.hash;

/**
 * <a href="https://leetcode.cn/problems/number-of-good-pairs/description/">1512. 好数对的数目</a>
 */
public class LeetCode1512 {
    public static class Solution {
        public int numIdenticalPairs(int[] nums) {
            int ans = 0;
            int[] countMap = new int[101];
            for (int num : nums) {
                ans += countMap[num];
                countMap[num]++;
            }

            return ans;
        }
    }
}
