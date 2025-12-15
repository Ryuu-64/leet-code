package org.ryuu;

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
            int maxVowels = 0;
            int vowels = 0;
            for (int right = 0; right < s.length(); right++) {
                char rightChar = s.charAt(right);
                if (ALL_VOWELS.contains(rightChar)) {
                    vowels++;
                }

                if (right < k - 1) {
                    continue;
                }

                maxVowels = Math.max(vowels, maxVowels);

                int left = right - k + 1;
                char leftChar = s.charAt(left);
                if (ALL_VOWELS.contains(leftChar)) {
                    vowels--;
                }

            }
            return maxVowels;
        }
    }
}
