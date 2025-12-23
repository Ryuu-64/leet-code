package org.ryuu.slidingwindow.fixedsize;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/k-radius-subarray-averages/description/">2090. 半径为 k 的子数组平均值</a>
 */
public class LeetCode2090 {
    public static class Solution1For {
        public int[] getAverages(int[] nums, int k) {
            int n = nums.length;
            int[] avg = new int[n];
            Arrays.fill(avg, -1);
            if (n <= k * 2) {
                return avg;
            }

            long s = 0;
            for (int i = 0; i < n; i++) {
                s += nums[i];
                if (i < 2 * k) {
                    continue;
                }

                avg[i - k] = (int) (s / (2 * k + 1));
                int left = i - 2 * k;
                s -= nums[left];
            }
            return avg;
        }
    }

    public static class Solution2For {
        public int[] getAverages(int[] nums, int k) {
            int n = nums.length;
            int[] avg = new int[n];
            Arrays.fill(avg, -1);
            if (n <= k * 2) {
                return avg;
            }

            long s = 0;

            for (int i = 0; i < 2 * k; i++) {
                s += nums[i];
            }

            int range = 2 * k + 1;
            for (int i = k; i < n - k; i++) {
                s += nums[i + k];
                avg[i] = (int) (s / range);
                s -= nums[i - k];
            }

            return avg;
        }
    }
}
