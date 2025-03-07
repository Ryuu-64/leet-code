package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/"></a>
 */
public class LeetCode198 {
    /**
     * rob(n) 偷 n 间房的最大金钱
     * money(n) 第 n 间房的金钱
     * 考虑偷不偷第 n 间房：
     * 偷：
     * rob(n) = rob(n - 2) + money(n)
     * 不偷：
     * rob(n) = rob(n - 1)
     */
    public static class Solution1 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int[] robDp = new int[nums.length + 1];
            // 一间都不抢就没有钱
            robDp[0] = 0;
            robDp[1] = nums[0];
            for (int i = 2; i < nums.length; i++) {
                int rub = robDp[i - 2] + nums[i - 1];
                int notRub = robDp[i - 1];
                robDp[i] = Math.max(notRub, rub);
            }

            return robDp[nums.length - 1];
        }
    }

    public static class Solution2 {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int currMoney = 0;
            int prevMoney = 0;

            for (int num : nums) {
                // 循环开始时 n = 1
                // currMoney 是 rob(n - 1), (此时 n 为 1, rob(0) 从没有抢任何房间开始算起)
                // prevMoney 是 rob(n - 2), (因为从没有抢任何房间开始算起，此时的 prev 会是 -1 间房的数据)
                // rob(n) = max(rob(n - 1), rob(n - 2) + money)
                int money = Math.max(currMoney, prevMoney + num);
                prevMoney = currMoney;
                currMoney = money;
                // 循环结束时 n = 房间数
                // currMoney 是 rob(n), 此时 n 为 房间数, 因为循环的次数为房间数
                // prevMoney 是 rob(n - 1)
            }

            return currMoney;
        }
    }
}
