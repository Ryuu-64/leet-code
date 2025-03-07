package org.ryuu;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/"></>
 * <a href="https://en.wikipedia.org/wiki/Prefix_sum"></a>
 */
public class LeetCode560 {
    /**
     * prefixSum(i, j) = k
     * k = prefixSum(j) - prefixSum(i), i < j
     * prefixSum(i) = prefixSum(j) - k
     */
    public static class Solution1 {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> prefixSumCountMap = new HashMap<>();
            // 考虑 [0, 0] 或类似的情况
            prefixSumCountMap.put(0, 1);
            int prefixSum = 0;
            int subarrayCount = 0;
            for (int num : nums) {
                prefixSum += num;
                int count = prefixSumCountMap.getOrDefault(prefixSum - k, 0);
                subarrayCount += count;
                prefixSumCountMap.put(prefixSum, prefixSumCountMap.getOrDefault(prefixSum, 0) + 1);
            }

            return subarrayCount;
        }
    }
}
