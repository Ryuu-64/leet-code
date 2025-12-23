package org.ryuu.slidingwindow.variablesize;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/minimum-removals-to-balance-array/description/">3634. 使数组平衡的最少移除数目</a>
 * <p>
 * 由于不要求数组的顺序，先进行升序排列，让数值从左到右变大
 * 此时平衡需要满足 nums[right] <= nums[left] * k
 * <p>
 * 该问题是一个变长滑窗问题
 * 我们可以通过这个平衡条件获取不需要移除的元素的长度
 */
public class LeetCode3634 {
    public static class Solution {
        public int minRemoval(int[] nums, int k) {
            Arrays.sort(nums);
            int maxSave = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] > (long) nums[left] * k) {
                    left++;
                }
                maxSave = Math.max(maxSave, right - left + 1);
            }
            return nums.length - maxSave;
        }
    }

    public static class Solution2 {
        public int minRemoval(int[] nums, int k) {
            Arrays.sort(nums);
            int maxSave = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] > (long) nums[left] * k) {
                    left++;
                }
                maxSave = Math.max(right - left + 1, maxSave);
            }

            return nums.length - maxSave;
        }
    }
}
