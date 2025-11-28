package org.ryuu;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150">242. 有效的字母异位词</a>
 */
public class LeetCode242 {
    public static class SolutionArray {
        public boolean isAnagram(String s, String t) {
            int[] counts = new int[26];
            for (char c : s.toCharArray()) {
                counts[c - 'a']++;
            }

            for (char c : t.toCharArray()) {
                counts[c - 'a']--;
            }

            for (int count : counts) {
                if (count != 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static class SolutionMap {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }

            for (char c : t.toCharArray()) {
                int count = countMap.getOrDefault(c, 0);
                if (count == 0) {
                    return false;
                }
                countMap.put(c, count - 1);
            }

            return true;
        }
    }
}
