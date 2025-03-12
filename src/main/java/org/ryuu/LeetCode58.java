package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/length-of-last-word/description/"></a>
 */
public class LeetCode58 {
    public static class Solution1 {
        public int lengthOfLastWord(String s) {
            int right = s.length() - 1;
            while (s.charAt(right) == ' ') {
                right--;
            }

            int left = right - 1;
            // 如果是 "abc" right 会是 2, left 得是 -1
            // 所以循环条件有 left == 0 的情况
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }

            return right - left;
        }
    }
}
