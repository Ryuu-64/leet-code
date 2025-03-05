package org.ryuu;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning-iii/description/"></a>
 */
public class LeetCode1278 {
    /**
     * 1. 字符串切分 dp
     * i: 切分次数，切分出 i+1 个子串
     * r: 字符串最右侧索引
     * l: 字符串的左侧索引 l ∈ [i, r]
     * 状态转移方程：
     * dp(i, r) = min(dp(i - 1, l - 1) + minChange(l, r)), l ∈ [i, r]
     * 递归边界：
     * 起始：
     * dp(0, r) = minChange(0, r)
     * 结束：
     * dp(k - 1, len(s) - 1), k ≥ 1
     * <p>
     * 2. 字母修改 dp
     * minChange(i, j)：把字串 s[i] 至 s[j] 改成回文，至少要改多少个字母
     * 分情况讨论：
     * 若 i = j 此时不需要修改
     * minChange(i, j) = minChange(i + 1, j - 1)
     * 若 i ≠ j 此时需要改一次
     * minChange(i, j) = minChange(i + 1, j - 1) + 1
     * 逻辑较简单可以合并
     * minChange(i, j) = minChange(i + 1, j - 1) + (s[i] ≠ s[j])
     */
    public static class Solution1 {
        public int palindromePartition(String s, int k) {
            char[] charArray = s.toCharArray();
            int len = charArray.length;

            int[][] dpSplit = new int[k][len];
            for (int[] row : dpSplit) {
                Arrays.fill(row, -1);
            }

            int[][] dpChange = new int[len][len];
            for (int[] row : dpChange) {
                Arrays.fill(row, -1);
            }

            return split(k - 1, len - 1, charArray, dpSplit, dpChange);
        }

        private int split(int i, int r, char[] charArray, int[][] dpSplit, int[][] dpChange) {
            if (i == 0) {
                return change(0, r, charArray, dpChange);
            }

            if (dpSplit[i][r] != -1) {
                return dpSplit[i][r];
            }

            int curSplit = Integer.MAX_VALUE;
            for (int l = i; l <= r; l++) {
                int split = split(i - 1, l - 1, charArray, dpSplit, dpChange);
                int change = change(l, r, charArray, dpChange);
                int newSplit = split + change;
                curSplit = Math.min(newSplit, curSplit);
            }

            dpSplit[i][r] = curSplit;
            return dpSplit[i][r];
        }

        private int change(int i, int j, char[] charArray, int[][] dpChange) {
            if (i >= j) {
                return 0;
            }

            if (dpChange[i][j] != -1) {
                return dpChange[i][j];
            }

            int curChange = charArray[i] != charArray[j] ? 1 : 0;
            int innerChange = change(i + 1, j - 1, charArray, dpChange);
            dpChange[i][j] = innerChange + curChange;
            return dpChange[i][j];
        }
    }

    /**
     * Solution 1 中使用了递归，然而我们可以自低向上求解，可以使用迭代优化
     *  minChange(i, j) 表示把子串 s[i] 到 s[j] 改成回文串，最少改多少个字母。
     *  minChange(i, j) = minChange(i + 1, j - 1) + (s[i] ≠ s[j])
     *  由于需要 i + 1 的值，因此需要倒着遍历 i
     */
    public static class Solution2 {
        public int palindromePartition(String s, int k) {
            char[] charArray = s.toCharArray();
            int len = charArray.length;

            int[][] dpChange = new int[len][len];
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    int curr = charArray[i] != charArray[j] ? 1 : 0;
                    int last = dpChange[i + 1][j - 1];
                    dpChange[i][j] = curr + last;
                }
            }

            int[][] dpSplit = new int[k][len];
            dpSplit[0] = dpChange[0];
            for (int i = 1; i < k; i++) {
                for (int r = i; r < len; r++) {
                    dpSplit[i][r] = Integer.MAX_VALUE;
                    for (int l = i; l <= r; l++) {
                        dpSplit[i][r] = Math.min(dpSplit[i - 1][l - 1] + dpChange[l][r], dpSplit[i][r]);
                    }
                }
            }

            return dpSplit[k - 1][len - 1];
        }
    }

    /**
     * 滚动数组优化
     * 因为 dp(i, r) = min(dp(i - 1, l - 1) + minChange(l, r)), l ∈ [i, r]
     * dp 只需要用到 i - 1，不需要更早的状态，可以将 i 与 i + 1 的状态合并到一个一维数组
     * dp(r) = dp(l - 1) + minChange(l, r)
     * 此时需要注意 遍历的方向，因为 r 比 l - 1 大，因此一定要从大到小遍历
     */
    public static class Solution3 {
        public int palindromePartition(String s, int k) {
            char[] charArray = s.toCharArray();
            int len = charArray.length;

            int[][] dpChange = new int[len][len];
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    int curr = charArray[i] != charArray[j] ? 1 : 0;
                    int last = dpChange[i + 1][j - 1];
                    dpChange[i][j] = curr + last;
                }
            }

            int[] dpSplit = dpChange[0];
            for (int i = 1; i < k; i++) {
                for (int r = len - 1; r >= i; r--) {
                    dpSplit[r] = Integer.MAX_VALUE;
                    for (int l = i; l <= r; l++) {
                        dpSplit[r] = Math.min(dpSplit[l - 1] + dpChange[l][r], dpSplit[r]);
                    }
                }
            }

            return dpSplit[len - 1];
        }
    }

    /**
     * 可以优化 r 的最大边界
     */
    public static class Solution4 {
        public int palindromePartition(String s, int k) {
            char[] charArray = s.toCharArray();
            int len = charArray.length;

            int[][] dpChange = new int[len][len];
            for (int left = len - 2; left >= 0; left--) {
                for (int right = left + 1; right < len; right++) {
                    int curr = charArray[left] != charArray[right] ? 1 : 0;
                    int last = dpChange[left + 1][right - 1];
                    dpChange[left][right] = curr + last;
                }
            }

            int[] dpSplit = dpChange[0];
            for (int i = 1; i < k; i++) {
                // 除本此外，剩余的子串个数为 k - 1 - i
                // r 最大为 len - 1
                // 考虑到剩余的字串会占据长度，且每个字串长度至少为 1
                // r 最大为 len - 1 - (k - 1 - i) * 1
                // r = len - k + i
                for (int r = len - k + i; r >= i; r--) {
                    dpSplit[r] = Integer.MAX_VALUE;
                    for (int l = i; l <= r; l++) {
                        dpSplit[r] = Math.min(dpSplit[l - 1] + dpChange[l][r], dpSplit[r]);
                    }
                }
            }

            return dpSplit[len - 1];
        }
    }
}
