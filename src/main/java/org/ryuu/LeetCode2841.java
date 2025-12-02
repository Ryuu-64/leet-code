package org.ryuu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/description/">2841. 几乎唯一子数组的最大和</a>
 */
public class LeetCode2841 {
    public static final class Solution {
        public long maxSum(List<Integer> nums, int m, int k) {
            long maxSum = 0;
            long sum = 0;
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (int right = 0; right < nums.size(); right++) {
                int rightNum = nums.get(right);
                sum += rightNum;
                // num count ++
                numCountMap.merge(rightNum, 1, Integer::sum);

                int left = right - k + 1;
                if (left < 0) {
                    continue;
                }

                if (numCountMap.size() >= m) {
                    maxSum = Math.max(sum, maxSum);
                }

                int leftNum = nums.get(left);
                sum -= leftNum;
                int count = numCountMap.get(leftNum);
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
