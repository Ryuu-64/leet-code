package org.ryuu.binarysearch;

/**
 * <a href="https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/">2529. 正整数和负整数的最大计数</a>
 */
public class LeetCode2529 {
    public static class Solution {
        public int maximumCount(int[] nums) {
            int negCount = lowerBound(nums, 0);
            int posCount = nums.length - lowerBound(nums, 1);
            return Math.max(negCount, posCount);
        }

        /**
         * 寻找满足 nums[i] >= target 的最小的 i
         */
        private int lowerBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return right;
        }
    }
}
