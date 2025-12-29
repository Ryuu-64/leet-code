package org.ryuu.slidingwindow.variablesize;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/">1658. 将 x 减到 0 的最小操作数</a>
 */
public class LeetCode1658 {
    public static class Solution {
        public int minOperations(int[] nums, int x) {
            int target = -x;
            for (int num : nums) {
                target += num;
            }

            // 即使移除全部元素也无法满足减到0
            if (target < 0) {
                return -1;
            }

            int length = nums.length;
            int sum = 0;
            int left = 0;
            int result = -1;
            for (int right = 0; right < length; right++) {
                int rightNum = nums[right];
                sum += rightNum;
                while (sum > target) {
                    int leftNum = nums[left];
                    sum -= leftNum;
                    left++;
                }
                if (sum == target) {
                    result = Math.max(right - left + 1, result);
                }
            }

            return result < 0 ? -1 : length - result;
        }
    }
}
