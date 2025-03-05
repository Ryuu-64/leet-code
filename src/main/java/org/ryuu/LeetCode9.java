package org.ryuu;

/**
 *<a href="https://leetcode.cn/problems/palindrome-number/"></a>
 */
public class LeetCode9 {
    public static class Solution1 {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            // avoid x0 x00 x000 etc.
            if (x % 10 == 0 && x != 0) {
                return false;
            }

            int revert = 0;
            while (x > revert) {
                revert = revert * 10 + x % 10;
                x /= 10;
            }

            // abba
            if (x == revert) {
                return true;
            }

            // aba
            if (x == revert / 10) {
                return true;
            }

            return false;
        }
    }
}
