package org.ryuu.monotonicstack;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-i/description/">496. 下一个更大元素 I</a>
 */
public class LeetCode496 {
    public static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n = nums1.length;
            Map<Integer, Integer> valueIndexMap = new HashMap<>(n, 1); // 预分配空间
            for (int i = 0; i < n; i++) {
                valueIndexMap.put(nums1[i], i);
            }

            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            Deque<Integer> stack = new ArrayDeque<>();
            for (int x : nums2) {
                while (!stack.isEmpty() && x > stack.peek()) {
                    // x 是栈顶的下一个更大元素
                    // 既然栈顶已经算出答案，弹出
                    int indexInNum1 = valueIndexMap.get(stack.pop());
                    ans[indexInNum1] = x; // 记录答案
                }
                // num1 是 num2 的子集，所以可能有 num2 中有，但是 num1 没有的数
                if (valueIndexMap.containsKey(x)) { // x 在 nums1 中
                    stack.push(x); // 只需把在 nums1 中的元素入栈
                }
            }
            return ans;
        }
    }
}
