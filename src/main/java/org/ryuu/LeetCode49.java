package org.ryuu;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150">49. 字母异位词分组</a>
 */
public class LeetCode49 {
    class Solution {
        public List<List<String>> groupAnagramsArraysSort(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String key = new String(array);
                map.computeIfAbsent(key, list -> new ArrayList<>()).add(str);
            }

            return new ArrayList<>(map.values());
        }

        public List<List<String>> groupAnagramsArraySort(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                int[] counts = new int[26];
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    counts[str.charAt(i) - 'a']++;
                }

                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (counts[i] != 0) {
                        builder.append((char) ('a' + i));
                        builder.append(counts[i]);
                    }
                }
                String key = builder.toString();
                map.computeIfAbsent(key, list -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
}
