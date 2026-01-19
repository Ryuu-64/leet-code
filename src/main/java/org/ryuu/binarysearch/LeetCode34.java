package org.ryuu.binarysearch;

/**
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/">34. 在排序数组中查找元素的第一个和最后一个位置</a>
 */
public class LeetCode34 {
    public static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int start = lowerBound(nums, target);
            if (start == nums.length || nums[start] != target) {
                return new int[]{-1, -1};
            }

            // 寻找最后一个 >= target 等效于寻找 >= target + 1 然后将找到的 index - 1
            int end = lowerBound(nums, target + 1) - 1;
            return new int[]{start, end};
        }

        /**
         * 返回最小的满足 nums[i] >= target 的下标 i
         * 如果数组为空，或者所有数都 < target，则返回 nums.length
         */
        private int lowerBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            // nums[left - 1] < target
            // nums[right] >= target
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    // [left, mid)
                    right = mid;
                } else {
                    // [mid + 1, right)
                    left = mid + 1;
                }
            }

            // 循环结束时 left = right
            // 此时 nums[left - 1] < target 而 nums[left] = nums[right] >= target
            // 所以 left 是第一个 >= target 的元素下标
            return left;
        }
    }
}
