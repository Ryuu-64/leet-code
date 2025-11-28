package org.ryuu;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150">290. 单词规律</a>
 */
public class LeetCode290 {
    public static class MySolution {
        /**
         * 如果word和pattern是一一对应的，那么他们的索引也是一一对应的。
         */
        public boolean wordPatternIndexMapping(String pattern, String str) {
            String[] words = str.split(" ");
            if (pattern.length() != words.length) {
                return false;
            }

            Map<Object, Integer> keyIndexMap = new HashMap<>();
            // 直接存入包装整型，避免 Integer 的享元导致值一样但 != 为 true 的情况
            for (Integer i = 0; i < words.length; i++) {
                Integer previousPatternIndex = keyIndexMap.put(pattern.charAt(i), i);
                Integer previousWordIndex = keyIndexMap.put(words[i], i);
                if (previousWordIndex != previousPatternIndex) {
                    return false;
                }
            }

            return true;
        }

        public boolean wordPatternBijectiveMap(String pattern, String str) {
            Map<String, Character> strMap = new HashMap<>();
            Map<Character, String> charMap = new HashMap<>();
            String[] words = str.split(" ");
            if (pattern.length() != words.length) {
                return false;
            }

            for (int i = 0; i < words.length; i++) {
                char currChar = pattern.charAt(i);
                String currWord = words[i];

                String word = charMap.get(currChar);
                if (word != null && !word.equals(currWord)) {
                    return false;
                }

                Character character = strMap.get(currWord);
                if (character != null && character != currChar) {
                    return false;
                }

                charMap.put(currChar, currWord);
                strMap.put(currWord, currChar);
            }
            return true;
        }
    }

    public static class SolutionLeetCode {
        public boolean wordPattern(String pattern, String str) {
            Map<String, Character> str2ch = new HashMap<>();
            Map<Character, String> ch2str = new HashMap<>();
            int m = str.length();
            int i = 0;
            for (int p = 0; p < pattern.length(); ++p) {
                char ch = pattern.charAt(p);
                if (i >= m) {
                    return false;
                }
                int j = i;
                while (j < m && str.charAt(j) != ' ') {
                    j++;
                }
                String tmp = str.substring(i, j);
                if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                    return false;
                }
                if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                    return false;
                }
                str2ch.put(tmp, ch);
                ch2str.put(ch, tmp);
                i = j + 1;
            }
            return i >= m;
        }
    }
}
