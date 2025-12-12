package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/">3090. 每个字符最多出现两次的最长子字符串</a>
 */
public class LeetCode3090 {
    public static class Solution {
        public int maximumLengthSubstring(String s) {
            char[] chars = s.toCharArray();
            int ans = 0;
            int left = 0;
            int[] cnt = new int[26];
            for (int right = 0; right < chars.length; right++) {
                int rightChar = chars[right] - 'a';
                cnt[rightChar]++;
                while (cnt[rightChar] > 2) {
                    int leftChar = chars[left] - 'a';
                    cnt[leftChar]--;
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
}
