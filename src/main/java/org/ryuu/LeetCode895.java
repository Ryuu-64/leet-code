package org.ryuu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/maximum-frequency-stack/">895. 最大频率栈</a>
 */
public class LeetCode895 {
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