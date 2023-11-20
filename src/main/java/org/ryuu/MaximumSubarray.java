package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/">53. 最大子数组和</a>
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int prev = 0;
        int curr = nums[0];
        for (int num : nums) {
            prev = Math.max(prev + num, num);
            curr = Math.max(curr, prev);
        }
        return curr;
    }
}
