package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning-iv/description/"></a>
 * isPalindrome(i, j) 表示字符串 s[i, j] 是否为回文串
 */
public class LeetCode1745 {
    /**
     * {@link LeetCode1278} 直接复用类似的 API
     */
    public static class Solution1 {
        public boolean checkPartitioning(String s) {
            int k = 3;
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

            return dpSplit[len - 1] == 0;
        }
    }

    public static class Solution2 {
        public boolean checkPartitioning(String s) {
            int n = s.length();
            char[] charArray = s.toCharArray();

            boolean[][] isPalindromeDp = new boolean[n][n];
            for (int length = 1; length < n; length++) {
                for (int left = 0; left <= n - length; left++) {
                    int right = left + length - 1;
                    if (length == 1) {
                        isPalindromeDp[left][right] = true;
                    } else {
                        boolean curr = charArray[left] == charArray[right];
                        if (length == 2) {
                            isPalindromeDp[left][right] = curr;
                        } else {
                            boolean last = isPalindromeDp[left + 1][right - 1];
                            isPalindromeDp[left][right] = curr && last;
                        }
                    }
                }
            }

            // 左子串 [0, start - 1]
            // 中子串 [start, end]
            // 右子串 [end + 1, n - 1]
            for (int start = 1; start < n - 1; start++) {
                if (!isPalindromeDp[0][start - 1]) {
                    continue;
                }

                for (int end = start; end < n - 1; end++) {
                    if (!isPalindromeDp[start][end]) {
                        continue;
                    }

                    if (!isPalindromeDp[end + 1][n - 1]) {
                        continue;
                    }

                    return true;
                }
            }

            return false;
        }
    }

    public static class Solution3 {
        public boolean checkPartitioning(String s) {
            int n = s.length();
            boolean[][] isPalindrome = new boolean[n][n];
            for (int length = 1; length < n; length++) {
                for (int start = 0; start <= n - length; start++) {
                    int end = start + length - 1;
                    if (length == 1) {
                        isPalindrome[start][end] = true;
                    } else if (length == 2) {
                        isPalindrome[start][end] = (s.charAt(start) == s.charAt(end));
                    } else {
                        isPalindrome[start][end] = ((s.charAt(start) == s.charAt(end)) && (isPalindrome[start + 1][end - 1]));
                    }
                }
            }
            for (int start = 1; start < n - 1; start++) {
                if (!isPalindrome[0][start - 1]) {
                    continue;
                }

                for (int end = start; end < n - 1; end++) {
                    if (isPalindrome[start][end] && isPalindrome[end + 1][n - 1]) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
