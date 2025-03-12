package org.ryuu;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/candy/description"></a>
 */
public class LeetCode135 {
    /**
     * 按照示例，首先需要给每个孩子一颗糖。
     * 可以将规则拆解为两个子规则，如果同时满足两个子规则，即符合规则。
     * 规则1:
     * 如果右边的孩子的 rating 比左边的高，那么右边的孩子的糖果需要比左边多一颗
     * candyLeft[i] = candyLeft[i - 1] + 1
     * 规则2:
     * 如果左边的孩子的 rating 比右边的高，那么左边的孩子的糖果需要比右边多一颗
     * candyRight[i] = candyRight[i + 1] + 1
     * 同时满足规则1，规则2即：
     * candy[i] = max(candyLeft[i], candyRight[i])
     */
    public static class Solution1 {
        public int candy(int[] ratings) {
            int[] left = new int[ratings.length];
            int[] right = new int[ratings.length];
            Arrays.fill(left, 1);
            Arrays.fill(right, 1);

            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] <= ratings[i - 1]) {
                    continue;
                }

                left[i] = left[i - 1] + 1;
            }
            int count = left[ratings.length - 1];

            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    right[i] = right[i + 1] + 1;
                }

                count += Math.max(left[i], right[i]);
            }
            return count;
        }
    }
}
