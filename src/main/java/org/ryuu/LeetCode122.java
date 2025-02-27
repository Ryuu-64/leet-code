package org.ryuu;

/**
 * i: 天数
 * j: 持有现金: 0, 持有股票: 1
 * dp(i, j)
 * 持有现金时:
 * dp(i, 0) = max(dp(i - 1, 0), dp(i - 1, 1) + prices[i])
 * 持有股票时:
 * dp(i, 1) = max(dp(i - 1, 1), dp(i - 1, 0) - prices[i])
 */
public class LeetCode122 {
    public int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int day = 1; day < prices.length; day++) {
            // 持有现金
            dp[day][0] = Math.max(dp[day - 1][0], dp[day - 1][1] + prices[day]);
            // 持有股票
            dp[day][1] = Math.max(dp[day - 1][1], dp[day - 1][0] - prices[day]);
        }

        // 最后一定是持有现金, 而不是持有股票
        return dp[prices.length - 1][0];
    }

    /**
     * 由于下一个状态只由上一次的 dp 数据行决定，因此可以使用滚动数组优化
     */
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[] dp = new int[2];
        dp[1] = -prices[0];


        for (int day = 1; day < prices.length; day++) {
            int[] newDp = new int[2];
            // 持有现金
            newDp[0] = Math.max(dp[0], dp[1] + prices[day]);
            // 持有股票
            newDp[1] = Math.max(dp[1], dp[0] - prices[day]);
            dp = newDp;
        }

        // 最后一定是持有现金, 而不是持有股票
        return dp[0];
    }
}
