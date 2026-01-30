package org.ryuu.binarysearch;

/**
 * <a href="https://leetcode.cn/problems/find-smallest-letter-greater-than-target/">744. 寻找比目标字母大的最小字母</a>
 */
public class LeetCode774 {
    public static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            if (target >= letters[letters.length - 1]) {
                return letters[0];
            }

            int index = lowerBound(letters, (char) (target + 1));
            return letters[index];
        }

        private static int lowerBound(char[] letters, char target) {
            int left = 0;
            int right = letters.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (letters[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return right;
        }
    }
}
