package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/"></a>
 */
public class LeetCode28 {
    public static class Solution1 {
        public int strStr(String string, String pattern) {
            int[] lps = buildLongestPrefixSuffix(pattern);
            int textIndex = 0;
            int patternIndex = 0;
            while (textIndex < string.length()) {
                if (string.charAt(textIndex) == pattern.charAt(patternIndex)) {
                    textIndex++;
                    patternIndex++;

                    if (patternIndex == pattern.length()) {
                        return textIndex - patternIndex;
                    }
                } else if (patternIndex != 0) {
                    patternIndex = lps[patternIndex - 1];
                } else {
                    textIndex++;
                }
            }

            return -1;
        }

        private static int[] buildLongestPrefixSuffix(String pattern) {
            int patternLength = pattern.length();
            int[] longestPrefixSuffix = new int[patternLength];
            int currentLongestPrefixSuffixLength = 0;
            for (int currentIndex = 1; currentIndex < patternLength; ) {
                if (pattern.charAt(currentIndex) == pattern.charAt(currentLongestPrefixSuffixLength)) {
                    currentLongestPrefixSuffixLength++;
                    longestPrefixSuffix[currentIndex] = currentLongestPrefixSuffixLength;
                    currentIndex++;
                } else if (currentLongestPrefixSuffixLength != 0) {
                    currentLongestPrefixSuffixLength = longestPrefixSuffix[currentLongestPrefixSuffixLength - 1];
                } else {
                    longestPrefixSuffix[currentIndex] = 0;
                    currentIndex++;
                }
            }

            return longestPrefixSuffix;
        }
    }
}
