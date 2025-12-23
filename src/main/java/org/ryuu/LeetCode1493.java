package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/">1493. 删掉一个元素以后全为 1 的最长子数组</a>
 */
public class LeetCode1493 {
    public static class Solution {
        public int longestSubarray(int[] nums) {
            int count0 = 0;
            int left = 0;
            int longest = 0;
            for (int right = 0; right < nums.length; right++) {
                int rightNum = nums[right];
                if (rightNum == 0) {
                    count0++;
                }

                while (count0 > 1) {
                    int leftNum = nums[left];
                    if (leftNum == 0) {
                        count0--;
                    }
                    left++;
                }

                longest = Math.max(right - left, longest);
            }

            return longest;
        }
    }
}
