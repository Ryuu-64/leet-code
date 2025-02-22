package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock">121. 买卖股票的最佳时机</a>
 */
public class LeetCode121 {
    /**
     * 低买高买即是最佳时机
     * 即在左侧找低价在右侧找高价
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
