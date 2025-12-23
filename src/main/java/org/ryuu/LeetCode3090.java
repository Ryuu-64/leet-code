package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/">3090. 每个字符最多出现两次的最长子字符串</a>
 */
public class LeetCode3090 {
    public static class Solution {
        public int maximumLengthSubstring(String s) {
            int[] count = new int[26];
            char[] chars = s.toCharArray();
            int maxLength = 0;
            int left = 0;
            for (int right = 0; right < chars.length; right++) {
                int rightId = chars[right] - 'a';
                count[rightId]++;
                while (count[rightId] > 2) {
                    int leftId = chars[left] - 'a';
                    count[leftId]--;
                    left++;
                }
                // 考虑 left right 都为 0 的情况，此时长度应为 1
                maxLength = Math.max(right - left + 1, maxLength);
            }

            return maxLength;
        }
    }
}
