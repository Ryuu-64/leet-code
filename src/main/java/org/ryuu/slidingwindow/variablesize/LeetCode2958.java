package org.ryuu.slidingwindow.variablesize;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/description/">2958. 最多 K 个重复元素的最长子数组</a>
 */
public class LeetCode2958 {
    public static class Solution {
        public int maxSubarrayLength(int[] nums, int k) {
            int result = 0;
            int left = 0;
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (int right = 0, numsLength = nums.length; right < numsLength; right++) {
                int rightNum = nums[right];
                numCountMap.merge(rightNum, 1, Integer::sum);
                while (numCountMap.getOrDefault(rightNum, 0) > k) {
                    int leftNum = nums[left];
                    numCountMap.merge(leftNum, -1, Integer::sum);
                    left++;
                }

                result = Math.max(right - left + 1, result);
            }

            return result;
        }
    }
}
