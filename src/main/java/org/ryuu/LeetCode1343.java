package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/">1343. 大小为 K 且平均值大于等于阈值的子数组数目</a>
 */
public class LeetCode1343 {
    public static class Solution {
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int num = 0;
            int sum = 0;
            for (int right = 0; right < arr.length; right++) {
                sum += arr[right];
                if (right < k - 1) {
                    continue;
                }

                double average = (double) sum / k;
                if (average >= threshold) {
                    num++;
                }

                int left = right - k + 1;
                sum -= arr[left];
            }

            return num;
        }
    }
}
