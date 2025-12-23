package org.ryuu.slidingwindow.variablesize;

/**
 * <a href="https://leetcode.cn/problems/get-equal-substrings-within-budget/">1208. 尽可能使字符串相等</a>
 * 初始化一个diff数组然后对数组进行滑窗，取得最大窗口的长度
 */
public class LeetCode1208 {
    public static class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int length = s.length();
            int[] diff = new int[length];
            for (int i = 0; i < length; i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);
                diff[i] = Math.abs(sChar - tChar);
            }
            int result = 0;
            int cost = 0;
            int left = 0;
            for (int right = 0; right < length; right++) {
                cost += diff[right];
                while (cost > maxCost) {
                    cost -= diff[left];
                    left++;
                }

                result = Math.max(right - left + 1, result);
            }

            return result;
        }
    }
}
