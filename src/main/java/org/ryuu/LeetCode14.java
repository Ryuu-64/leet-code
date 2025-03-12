package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/description/"></a>
 */
public class LeetCode14 {
    /**
     * 如果有公共串，公共串必然是现有串的前缀子串
     * 所以可以先取一个字符串出来按长度遍历
     */
    public static class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            String s0 = strs[0];
            for (int i = 0; i < s0.length(); i++) {
                char c = s0.charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    String s = strs[j];
                    if (i != s.length() && s.charAt(i) == c) {
                        continue;
                    }

                    return s0.substring(0, i);
                }
            }
            return s0;
        }
    }
}
