package org.ryuu.binarysearch;

/**
 * <a href="https://leetcode.cn/problems/binary-search/description/">704. 二分查找</a>
 */
public class LeetCode704 {
    public static class Solution {
        public int search(int[] nums, int target) {
            int index = lowerBound(nums, target);
            return index < nums.length && nums[index] == target ? index : -1;
        }

        /**
         * 最小的满足 nums[i] >= target 的 i，如果不存在返回数组长度。
         */
        private static int lowerBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    // [mid + 1, right)
                    left = mid + 1;
                } else {
                    // [left, mid)
                    right = mid;
                }
            }
            return left;
        }
    }
}
