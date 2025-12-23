package org.ryuu.slidingwindow.fixedsize;

/**
 * <a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/">2379. 得到 K 个黑块的最少涂色次数</a>
 */
public class LeetCode2379 {
    public static final class Solution {
        public int minimumRecolors(String blocks, int k) {
            int minToBlackCount = Integer.MAX_VALUE;
            int toBlackCount = 0;
            int n = blocks.length();
            for (int right = 0; right < k - 1; right++) {
                if (blocks.charAt(right) == 'W') {
                    toBlackCount++;
                }
            }

            for (int right = k - 1; right < n; right++) {
                if (blocks.charAt(right) == 'W') {
                    toBlackCount++;
                }
                minToBlackCount = Math.min(toBlackCount, minToBlackCount);
                int left = right - k + 1;
                if (blocks.charAt(left) == 'W') {
                    toBlackCount--;
                }
            }

            return minToBlackCount;
        }
    }
}
