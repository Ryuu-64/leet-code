package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome">125. 验证回文串</a>
 */
public class LeetCode125 {
    static class DoublePointer {
        public boolean isPalindrome(String s) {
            int length = s.length();
            int pLeft = 0;
            int pRight = length - 1;
            while (pLeft < pRight) {
                while (pLeft < pRight && !Character.isLetterOrDigit(s.charAt(pLeft))) {
                    pLeft++;
                }

                while (pLeft < pRight && !Character.isLetterOrDigit(s.charAt(pRight))) {
                    pRight--;
                }

                if (pLeft >= pRight) {
                    continue;
                }

                int leftLowerCase = Character.toLowerCase(s.charAt(pLeft));
                int rightLowerCase = Character.toLowerCase(s.charAt(pRight));
                if (leftLowerCase == rightLowerCase) {
                    pLeft++;
                    pRight--;
                    continue;
                }

                return false;
            }

            return true;
        }
    }
}
