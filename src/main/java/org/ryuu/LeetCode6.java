package org.ryuu;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/zigzag-conversion/description/"></a>
 */
public class LeetCode6 {
    /**
     * 遍历z字形字符串可发现，每到下一个字符就会换一行
     * 因此知道每个字符在哪一行，就可以构建出结果字符串的每一行
     * <p>
     * 虽然是z行的，但是对于构建的每一行来说，每个字只是在上下上下移动
     */
    public static class Solution1 {
        public String convert(String s, int numRows) {
            if (numRows < 2) {
                return s;
            }

            List<StringBuilder> rowBuilders = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                rowBuilders.add(new StringBuilder());
            }

            int i = 0, step = -1;
            for (char c : s.toCharArray()) {
                rowBuilders.get(i).append(c);
                if (i == 0 || i == numRows - 1) {
                    step = -step;
                }
                i += step;
            }

            StringBuilder builder = new StringBuilder();
            for (StringBuilder row : rowBuilders) {
                builder.append(row);
            }
            return builder.toString();
        }
    }
}
