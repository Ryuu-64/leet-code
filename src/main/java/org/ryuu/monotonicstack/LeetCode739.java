package org.ryuu.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/daily-temperatures/description/">739. 每日温度</a>
 */
public class LeetCode739 {
    public static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int len = temperatures.length;
            int[] ans = new int[len];
            // todolist 装着还没有得到答案的天数
            // 新入栈的元素总比之前的元素小
            Deque<Integer> indexStack = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                int temperature = temperatures[i];
                while (!indexStack.isEmpty() && temperature > temperatures[indexStack.peek()]) {
                    int j = indexStack.pop();
                    ans[j] = i - j;
                }
                indexStack.push(i);
            }
            return ans;
        }
    }
}
