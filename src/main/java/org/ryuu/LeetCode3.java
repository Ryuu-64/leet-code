package org.ryuu;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串</a>
 */
public class LeetCode3 {
    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> charIndexMap = new HashMap<>();
            int left = -1, res = 0;
            for (int right = 0; right < s.length(); right++) {
                char rightChar = s.charAt(right);
                if (charIndexMap.containsKey(rightChar)) {
                    left = Math.max(left, charIndexMap.get(rightChar));
                }
                charIndexMap.put(rightChar, right);
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
}
