package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/break-a-palindrome/description/"></a>
 */
public class LeetCode1328 {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }

        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }

        chars[chars.length - 1] = 'b';
        return String.valueOf(chars);
    }
}
