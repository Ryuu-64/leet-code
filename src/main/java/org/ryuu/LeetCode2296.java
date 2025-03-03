package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/design-a-text-editor/"></a>
 */
public class LeetCode2296 {
    public static class Solution {
        public static class TextEditor {
            private final StringBuilder left = new StringBuilder();
            private final StringBuilder right = new StringBuilder();

            public void addText(String text) {
                left.append(text);
            }

            public int deleteText(int k) {
                k = Math.min(k, left.length());
                left.setLength(left.length() - k);
                return k;
            }

            public String cursorLeft(int k) {
                return cursorMove(k, left, right);
            }

            public String cursorRight(int k) {
                return cursorMove(k, right, left);
            }

            private String cursorMove(int k, StringBuilder removed, StringBuilder added) {
                while (k > 0 && removed.length() > 0) {
                    char lastRight = removed.charAt(removed.length() - 1);
                    added.append(lastRight);
                    removed.setLength(removed.length() - 1);
                    k--;
                }

                return text();
            }

            private String text() {
                int displayLen = Math.min(left.length(), 10);
                return left.substring(left.length() - displayLen);
            }
        }
    }
}
