package org.ryuu.slidingwindow.variablesize;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones-iii/description/">1004. 最大连续1的个数 III</a>
 */
public class LeetCode1004 {
    public static class Solution {
        public int longestOnes(int[] nums, int k) {
            int result = 0;
            int count0 = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                int rightNum = nums[right];
                if (rightNum == 0) {
                    count0++;
                }

                while (count0 > k) {
                    int leftNum = nums[left];
                    if (leftNum == 0) {
                        count0--;
                    }
                    left++;
                }

                result = Math.max(right - left + 1, result);
            }
            return result;
        }
    }
}
