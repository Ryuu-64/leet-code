package org.ryuu.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/description/">1475. 商品折扣后的最终价格</a>
 */
public class LeetCode1475 {
    public static class Solution1 {
        public int[] finalPrices(int[] prices) {
            Deque<Integer> indexStack = new ArrayDeque<>();
            int length = prices.length;
            int[] ans = new int[length];
            for (int j = 0; j < length; j++) {
                int price = prices[j];
                while (!indexStack.isEmpty() && price <= prices[indexStack.peek()]) {
                    int i = indexStack.pop();
                    ans[i] = prices[i] - prices[j];
                }
                indexStack.push(j);
            }

            while (!indexStack.isEmpty()) {
                int i = indexStack.pop();
                ans[i] = prices[i];
            }
            return ans;
        }
    }

    public static class Solution2 {
        public int[] finalPrices(int[] prices) {
            Deque<Integer> indexStack = new ArrayDeque<>();
            for (int i = 0; i < prices.length; i++) {
                int price = prices[i];
                while (!indexStack.isEmpty() && prices[indexStack.peek()] >= price) {
                    Integer index = indexStack.pop();
                    prices[index] -= price; // price 是栈顶的折扣值
                }
                indexStack.push(i);
            }
            return prices;
        }
    }
}
