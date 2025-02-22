package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position">35. 搜索插入位置</a>
 */
public class LeetCode35 {
    static class BinarySearch {
        public int searchInsert(int[] nums, int target) {
            int length = nums.length;
            int left = 0;
            int right = length - 1;
            int position = length;
            while (left <= right) {
                int mid = ((right - left) >> 1) + left;
                if (target <= nums[mid]) {
                    position = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return position;
        }
    }
}
