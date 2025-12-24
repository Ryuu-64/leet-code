package org.ryuu.slidingwindow.variablesize;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/maximum-erasure-value/description/">1695. 删除子数组的最大得分</a>
 */
public class LeetCode1695 {
    public static class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            Set<Integer> existsSet = new HashSet<>();
            int left = 0;
            int maxSum = 0;
            int sum = 0;
            for (int rightNum : nums) {
                while (existsSet.contains(rightNum)) {
                    int leftNum = nums[left];
                    existsSet.remove(leftNum);
                    sum -= leftNum;
                    left++;
                }

                existsSet.add(rightNum);
                sum += rightNum;
                maxSum = Math.max(sum, maxSum);
            }

            return maxSum;
        }
    }
}
