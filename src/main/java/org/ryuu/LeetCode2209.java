package org.ryuu;

public class LeetCode2209 {
    /**
     * <a href="https://leetcode.cn/problems/minimum-white-tiles-after-covering-with-carpets/solutions/3069163/yong-di-tan-fu-gai-hou-de-zui-shao-bai-s-uav9/">LeetCode 2209</a>
     * i: 地毯数
     * j: 砖块索引（砖块数为 j + 1）
     * l: 毯子的长度（长度为多少块砖）
     * dp(i, j): 用 i 条地毯，覆盖 [0, j] 的地板，没有被覆盖的白色砖块的最小数量
     * 状态转移方程：
     * 不盖地毯的情况：
     * dp(i, j) = dp(i, j - 1) + floor[j] (i = 0, j > 0)
     * 盖地毯的情况：
     * dp(i, j) = dp(i - 1, j - l) (i > 0)
     */
    public int minimumWhiteTiles1(String floor, int numCarpets, int carpetLen) {
        char[] floorArray = floor.toCharArray();
        int floorLen = floorArray.length;

        int[][] dp = new int[numCarpets + 1][floorLen];
        dp[0][0] = floorArray[0] - '0';
        for (int j = 1; j < floorLen; j++) {
            dp[0][j] = dp[0][j - 1] + (floorArray[j] - '0');
        }

        for (int i = 1; i <= numCarpets; i++) {
            for (int j = carpetLen * i; j < floorLen; j++) {
                dp[i][j] = Math.min(
                        dp[i][j - 1] + (floorArray[j] - '0'), // 不覆盖
                        dp[i - 1][j - carpetLen] // 覆盖
                );
            }
        }

        return dp[numCarpets][floorLen - 1];
    }

    public int minimumWhiteTiles2(String floor, int numCarpets, int carpetLen) {
        int floorLen = floor.length();
        if (numCarpets * carpetLen >= floorLen) {
            return 0;
        }

        char[] f = floor.toCharArray();
        int[] dp = new int[floorLen];
        dp[0] = f[0] - '0';
        for (int i = 1; i < floorLen; i++) {
            dp[i] = dp[i - 1] + (f[i] - '0');
        }

        for (int i = 1; i <= numCarpets; i++) {
            int[] newDp = new int[floorLen];
            for (int j = carpetLen * i; j < floorLen; j++) {
                newDp[j] = Math.min(
                        newDp[j - 1] + (f[j] - '0'), // 不覆盖
                        dp[j - carpetLen] // 覆盖
                );
            }
            dp = newDp;
        }

        return dp[floorLen - 1];
    }

    /**
     * dp(carpetCount, brickIndex): 使用 carpetCount 块地毯覆盖长度为 brickIndex + 1 块砖的地面，最少的白色砖块数量
     * 状态转移方程：
     * 覆盖：
     * dp(carpetCount, brickIndex) = dp(carpetCount - 1, brickIndex - carpetLen)
     * 不覆盖：
     * dp(carpetCount, brickIndex) = dp(carpetCount, brickIndex - 1) + floor[brickIndex]
     * 由于在状态转移的过程中最多只需要访问 dp(carpetCount - 1, ?)
     */
//    public int minimumWhiteTiles3(String floor, int numCarpets, int carpetLen) {
//        if (numCarpets * carpetLen > floor.length()) {
//            return 0;
//        }
//
//        int[] dpFloor = new int[floor.length()];
//
//        char[] floorArray = floor.toCharArray();
//    }
}
