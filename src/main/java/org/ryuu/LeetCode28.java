package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/"></a>
 */
public class LeetCode28 {
    /**
     * KMP 算法
     */
    public static class Solution1 {
        public int strStr(String string, String pattern) {
            if (pattern.isEmpty()) {
                return 0;
            }

            // 分别读取原串和匹配串的长度
            int patternLen = pattern.length();
            int len = string.length();
            // 原串和匹配串前面都加空格，使其下标从 1 开始
            string = " " + string;
            pattern = " " + pattern;

            char[] chars = string.toCharArray();
            char[] patternChars = pattern.toCharArray();

            // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
            int[] next = new int[patternLen + 1];
            // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
            for (int i = 2, j = 0; i <= patternLen; i++) {
                // 匹配不成功的话，j = next(j)
                while (j > 0 && patternChars[i] != patternChars[j + 1]) {
                    j = next[j];
                }
                // 匹配成功的话，先让 j++
                if (patternChars[i] == patternChars[j + 1]) {
                    j++;
                }
                // 更新 next[i]，结束本次循环，i++
                next[i] = j;
            }

            // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
            for (int i = 1, j = 0; i <= len; i++) {
                // 匹配不成功 j = next(j)
                while (j > 0 && chars[i] != patternChars[j + 1]) {
                    j = next[j];
                }
                // 匹配成功的话，先让 j++，结束本次循环后 i++
                if (chars[i] == patternChars[j + 1]) {
                    j++;
                }
                // 整一段匹配成功，直接返回下标
                if (j == patternLen) {
                    return i - patternLen;
                }
            }

            return -1;
        }
    }
}
