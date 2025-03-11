package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/sum-of-beauty-in-the-array/description/"></a>
 */
public class LeetCode2012 {
    /**
     * 对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
     * nums[0, j] < num[i] < nums[i + 1, len - 1]
     * nums[0, j] 的最大值 prefixMax
     * nums[i + 1, len - 1] 的最小值 suffixMin
     */
    public static class Solution {
        public int sumOfBeauties(int[] nums) {
            int n = nums.length;
            int[] suffixMin = new int[n];
            suffixMin[n - 1] = nums[n - 1];

            for (int i = n - 2; i > 1; i--) {
                suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
            }

            int sum = 0;
            int prefixMax = nums[0];

            for (int i = 1; i < n - 1; i++) {
                int x = nums[i];
                if (prefixMax < x && x < suffixMin[i + 1]) {
                    sum += 2;
                } else if (nums[i - 1] < x && x < nums[i + 1]) {
                    sum++;
                }
                prefixMax = Math.max(prefixMax, x);
            }
            return sum;
        }
    }
}
