package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/gas-station/description"></a>
 */
public class LeetCode134 {
    /**
     * 至少需要遍历一次
     * 车可以从任意加油站开始，因此我们只需要找到一个汽油最小的值即可保证解是唯一的要求
     * 如果转了一圈油是负的，那么就一定没有解
     * <p>
     *
     */
    public static class Solution1 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int stationIndex = 0;
            int minGas = 0;
            // currGas 最后为加油量减去耗油量
            int currGas = 0;
            for (int i = 0; i < gas.length; i++) {
                currGas += gas[i] - cost[i];
                if (currGas >= minGas) {
                    continue;
                }

                minGas = currGas;
                stationIndex = i + 1;
            }

            return currGas < 0 ? -1 : stationIndex;
        }
    }
}
