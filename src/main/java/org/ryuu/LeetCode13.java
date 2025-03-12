package org.ryuu;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/roman-to-integer/description/"></a>
 */
public class LeetCode13 {
    /**
     * 查看罗马数字的拼写规则可发现，如果一个小的值在大的值左侧，应该减去左侧的值
     * 这样的话一次知道两个值，对左边的值进行加减就行
     */
    public static class Solution1 {
        private static final Map<Character, Integer> symbolValueMap = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        public int romanToInt(String s) {
            char[] charArray = s.toCharArray();
            int num = 0;

            for (int i = 1; i < charArray.length; i++) {
                char symbol1 = charArray[i - 1];
                int num1 = symbolValueMap.get(symbol1);
                char symbol2 = charArray[i];
                int num2 = symbolValueMap.get(symbol2);
                num += num1 * (num1 < num2 ? -1 : 1);
            }
            char lastSymbol = charArray[charArray.length - 1];
            int numLast = symbolValueMap.get(lastSymbol);
            num += numLast;

            return num;
        }
    }
}
