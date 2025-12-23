package org.ryuu.slidingwindow.fixedsize;

import java.util.HashMap;
import java.util.Map;

/**
 *<a href="https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/">2461. 长度为 K 子数组中的最大和</a>
 */
public class LeetCode2461 {
    public static class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            long maxSum = 0;
            long sum = 0;
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (int right = 0; right < nums.length; right++) {
                int rightNum = nums[right];
                sum += rightNum;
                numCountMap.merge(rightNum, 1, Integer::sum);
                int left = right - k + 1;
                if (left < 0) {
                    continue;
                }

                if (numCountMap.size() == k) {
                    maxSum = Math.max(sum, maxSum);
                }

                int leftNum = nums[left];
                sum -= leftNum;
                int count = numCountMap.getOrDefault(leftNum, 0);
                if (count > 1) {
                    numCountMap.put(leftNum, count - 1);
                } else {
                    numCountMap.remove(leftNum);
                }
            }

            return maxSum;
        }
    }
}
