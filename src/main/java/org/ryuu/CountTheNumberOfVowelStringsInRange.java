package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/description/"/>
 */
public class CountTheNumberOfVowelStringsInRange {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (
                isVowelChar(word.charAt(0)) &&
                isVowelChar(word.charAt(word.length() - 1))
            ) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowelChar(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
