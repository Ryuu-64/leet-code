package org.ryuu;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串</a>
 */
public class LeetCode3 {
    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int res = 0;
            int left = -1;
            Map<Character, Integer> charIndexMap = new HashMap<>();
            for (int right = 0; right < chars.length; right++) {
                char rightChar = chars[right];
                int lastIndex = charIndexMap.getOrDefault(rightChar, -1);
                if (lastIndex > left) {
                    left = lastIndex;
                }
                charIndexMap.put(rightChar, right);
                int windowLength = right - left;
                res = Math.max(windowLength, res);
            }

            return res;
        }
    }

    public static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int res = 0;
            int left = -1;
            Map<Character, Integer> charIndexMap = new HashMap<>();
            for (int right = 0; right < chars.length; right++) {
                char rightChar = chars[right];
                int lastIndex = charIndexMap.getOrDefault(rightChar, -1);
                left = Math.max(lastIndex, left);
                charIndexMap.put(rightChar, right);
                int length = right - left;
                res = Math.max(length, res);
            }
            return res;
        }
    }
}
