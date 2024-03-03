package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/w3tCBm/">LCR 003. 比特位计数</a>
 */
public class LCR003 {
    public static class BrianKernighan {
        public int[] countBits(int n) {
            int[] bits = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                bits[i] = countOnes(i);
            }
            return bits;
        }

        private int countOnes(int x) {
            int ones = 0;
            while (x > 0) {
                x &= (x - 1);
                ones++;
            }
            return ones;
        }
    }

    /**
     * Most Significant Bit (MSB), DP (自底向上/表格法), 位运算
     * <p>
     * 0 =< j < i, j 比 i 的二进制表示仅小一 时
     * 有 bits[i] = bits[j] + 1
     * <p>
     * 存在最大的y, y <= x, 且 y 为 2 的整数次幂 时
     * y 为 x 的最高有效位 (Most Significant Bit)
     * z = x - y, 0 <= z < x
     * bits[x] = bit[z] + 1
     * <p>
     * 当 k & (k - 1) == 0 时, k 为 2 的整数次幂
     * <p>
     * 例:
     * y = 100
     * x = 111
     * z = 11
     * <p>
     * 总结
     * 显然，此题可通过先前较小的数求得较大的数的比特数(dp 自底向上)，降低时间复杂度 (否则需要重复求比特)
     * 当 l < m 时
     * 状态转移的主干为 bits[m] = bits[l]
     * 此时需要一个特殊的 l 才能完成状态转移
     * n 为 m 的最高有效位, l = m - n
     * 状态转移函数完成 bits[m] = bits[l] + 1
     */
    public static class DpMsb {
        public int[] countBits(int n) {
            int[] bits = new int[n + 1];
            int msb = 0; // Most Significant Bit
            for (int i = 1; i <= n; i++) {
                if ((i & (i - 1)) == 0) {
                    msb = i;
                }
                bits[i] = bits[i - msb] + 1;
            }

            return bits;
        }
    }
}
