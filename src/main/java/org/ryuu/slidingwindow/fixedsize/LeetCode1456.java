package org.ryuu.slidingwindow.fixedsize;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/">1456. 定长子串中元音的最大数目</a>
 */
public class LeetCode1456 {
    public static class Solution {
        private static final Set<Character> ALL_VOWELS = new HashSet<>();

        static {
            ALL_VOWELS.add('a');
            ALL_VOWELS.add('e');
            ALL_VOWELS.add('i');
            ALL_VOWELS.add('o');
            ALL_VOWELS.add('u');
        }

        public int maxVowels(String s, int k) {
            char[] chars = s.toCharArray();
            int maxVowels = 0;
            int vowels = 0;
            for (int right = 0; right < chars.length; right++) {
                char rightChar = chars[right];
                if (ALL_VOWELS.contains(rightChar)) {
                    vowels++;
                }

                int nextLeft = right - k + 1;
                if (nextLeft < 0) {
                    continue;
                }

                maxVowels = Math.max(vowels, maxVowels);
                char nextLeftChar = chars[nextLeft];
                if (ALL_VOWELS.contains(nextLeftChar)) {
                    vowels--;
                }

            }
            return maxVowels;
        }
    }
}
