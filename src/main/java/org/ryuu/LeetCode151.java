package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string/description/"></a>
 */
public class LeetCode151 {
    /**
     *从后往前找到每个单词
     * 可以用两个指针，left 指向单词的开始，right 指向单词的结束
     * 先把字符串头尾的空格去掉
     * 左指针从单词右侧到左侧，找到空格结束，然后把单词添加到结果中
     * 左指针从空格右侧到左侧，找到单词结束，设置 right 为 left，继续循环
     */
    public static class Solution1 {
        public String reverseWords(String s) {
            s = s.trim();
            int left = s.length() - 1;
            int right = left;
            StringBuilder reverseBuilder = new StringBuilder();
            while (left >= 0) {
                while (left >= 0 && s.charAt(left) != ' ') {
                    left--;
                }
                reverseBuilder.append(s, left + 1, right + 1).append(" ");
                while (left >= 0 && s.charAt(left) == ' ') {
                    left--;
                }
                right = left;
            }

            return reverseBuilder.toString().trim();
        }
    }
}
