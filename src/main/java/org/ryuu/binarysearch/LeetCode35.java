package org.ryuu.binarysearch;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/description/">35. 搜索插入位置</a>
 */
public class LeetCode35 {
    public static class Solution {
        public int searchInsert(int[] nums, int target) {
            return lowerBound(nums, target);
        }

        /**
         * 最小的满足 nums[i] >= target 的 i，如果不存在返回数组长度。
         */
        private static int lowerBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            // nums[left - 1] < target
            // nums[right] >= target
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
