package org.ryuu;

public class LeetCode122 {
    /**
     * i: 天数
     * j: 持有现金: 0, 持有股票: 1
     * dp(i, j)
     * 持有现金时:
     * dp(i, 0) = max(dp(i - 1, 0), dp(i - 1, 1) + prices[i])
     * dp(i, 1) = max(dp(i - 1, 0) - prices[i], dp(i - 1, 1))
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;

        for (int day = 1; day < prices.length; day++) {
            dp[day][0] = Math.max();
        }
    }
}
