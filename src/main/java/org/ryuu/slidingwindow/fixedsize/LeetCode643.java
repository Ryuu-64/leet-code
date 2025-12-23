package org.ryuu.slidingwindow.fixedsize;

/**
 * <a href="https://leetcode.cn/problems/maximum-average-subarray-i/description/">643. 子数组最大平均数 I</a>
 */
public class LeetCode643 {
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        for (int right = 0; right < nums.length; right++) {
            currMax += nums[right];
            if (right < k - 1) {
                continue;
            }

            max = Math.max(currMax, max);

            int left = right - k + 1;
            int leftNum = nums[left];
            currMax -= leftNum;
        }

        return (double) max / k;
    }
}
