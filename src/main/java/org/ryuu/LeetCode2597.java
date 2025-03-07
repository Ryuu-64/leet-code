package org.ryuu;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/the-number-of-beautiful-subsets/description/"></a>
 * 例 nums = [1, 2, 3, 4, 5, 6, 7, 8], k = 2，把数组按照模 k 的结果，分成两组：
 * group1 = [2, 4, 6, 8]，模 k 等于 0
 * group2 = [1, 3, 5, 7]，模 k 等于 1
 * 由于余数不同，group1 和 group2 中各选一个数，二者相差一定不等于 k。
 * 考虑每组内选数字的方案数，然后根据乘法原理，把各个组的方案数相乘，即为答案。
 * 按模 k 的结果分组，每组用有序集合（或者哈希表）统计元素及其出现次数。
 */
public class LeetCode2597 {
    public static class Solution {
        public int beautifulSubsets(int[] nums, int k) {
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (int num : nums) {
                numCountMap.merge(num, 1, Integer::sum);
            }

            int ans = 1;
            for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
                int num = entry.getKey();
                if (numCountMap.containsKey(num - k)) { // x 不是等差数列的首项
                    continue;
                }
                // 计算这一组的方案数
                int f0 = 1;
                int f1 = 1 << entry.getValue();
                for (num += k; numCountMap.containsKey(num); num += k) {
                    int newF = f1 + f0 * ((1 << numCountMap.get(num)) - 1);
                    f0 = f1;
                    f1 = newF;
                }
                ans *= f1; // 每组方案数相乘
            }
            return ans - 1; // 去掉空集
        }
    }
}
