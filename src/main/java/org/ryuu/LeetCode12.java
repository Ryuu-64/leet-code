package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/integer-to-roman/description/"></a>
 */
public class LeetCode12 {
    public static class Solution {
        private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < values.length; ++i) {
                int value = values[i];
                while (num >= value) {
                    num -= value;
                    String symbol = symbols[i];
                    stringBuilder.append(symbol);
                }

                if (num == 0) {
                    break;
                }
            }

            return stringBuilder.toString();
        }
    }
}
