package org.ryuu;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/description/"></a>
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class LCR147 {
    public static class Solution {
        public static class MinStack {
            private final Stack<Integer> stack = new Stack<>();
            private final Stack<Integer> minStack = new Stack<>();

            /**
             * initialize your data structure here.
             */
            public MinStack() {
                minStack.push(Integer.MAX_VALUE);
            }

            public void push(int x) {
                stack.push(x);
                int lastMin = minStack.peek();
                int min = Math.min(x, lastMin);
                minStack.push(min);
            }

            public void pop() {
                stack.pop();
                minStack.pop();
            }

            public int top() {
                return stack.peek();
            }

            public int getMin() {
                return minStack.peek();
            }
        }
    }
}
