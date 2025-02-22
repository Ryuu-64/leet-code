package org.ryuu;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum">1. 两数之和</a>
 * <p>
 * 要求时间复杂度小于 O(n^2) 因此肯定有比暴力遍历枚举更好的算法
 * 题目要求 numA + numB = target 寻找 A B
 * 若要时间复杂度小于 O(n^2)
 * 解决时间复杂度的关键是消除遍历遍历枚举中嵌套的一个遍历
 * <p>
 * 从数据结构上考虑
 * 可借助 HashMap 消除嵌套的里层遍历
 * 为此，需要把 numA，numB 中的一个数存入 HashMap
 * <p>；
 * 从数据上考虑
 * 记遍历时的数为 numA，此时我们在寻找可能 numB (numB = target - numA)，因此 numB 应该在 HashMap 中
 * 可以将当前遍历的 numA 放入 HashMap，放入 HashMap 的数就成了 numB
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> differenceMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int numA = nums[i];
            int numB = target - numA;
            if (differenceMap.containsKey(numB)) {
                return new int[]{differenceMap.get(numB), i};
            }

            differenceMap.put(numA, i);
        }

        return new int[0];
    }
}
