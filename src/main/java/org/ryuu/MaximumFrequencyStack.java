package org.ryuu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/maximum-frequency-stack/">895. 最大频率栈</a>
 * 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
 * 实现 FreqStack 类:
 * FreqStack() 构造一个空的堆栈。
 * void push(int val) 将一个整数 val 压入栈顶。
 * int pop() 删除并返回堆栈中出现频率最高的元素。
 * 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。.
 * <p>
 * 0 <= val <= 10^9
 * push 和 pop 的操作数不大于 2 * 10^4。
 * 输入保证在调用 pop 之前堆栈中至少有一个元素。
 */
public class MaximumFrequencyStack {
    public static class FreqStack {
        private final Map<Integer, List<Integer>> countValuesMap = new HashMap<>();
        private final Map<Integer, Integer> valueCountMap = new HashMap<>();
        private int maxCount;

        public void push(int val) {
            valueCountMap.put(val, valueCountMap.getOrDefault(val, 0) + 1);
            int count = valueCountMap.get(val);
            List<Integer> list = countValuesMap.getOrDefault(count, new ArrayList<>());
            list.add(val);
            countValuesMap.put(count, list);
            maxCount = Math.max(maxCount, count);
        }

        public int pop() {
            List<Integer> list = countValuesMap.get(maxCount);
            int value = list.remove(list.size() - 1);
            valueCountMap.put(value, valueCountMap.get(value) - 1);
            if (list.isEmpty()) {
                maxCount--;
            }
            return value;
        }
    }
}