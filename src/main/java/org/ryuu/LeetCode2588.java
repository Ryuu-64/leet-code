package org.ryuu;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/"></a>
 * <a href="https://en.wikipedia.org/wiki/Prefix_sum"></a>
 * prefixXor(i, j) = 0
 * prefixXor(i) = v, prefixXor(j) = v, i < j, v = {0, 1}
 * prefixXor(i, j) = prefixXor(i) == prefixXor(j)
 */
public class LeetCode2588 {
    public long beautifulSubarrays(int[] nums) {
        long subarrayCount = 0;
        int prefixXOR = 0;
        // 考虑 xor = 0 的情况, 所以要 + 1
        Map<Integer, Integer> prefixXORCountMap = new HashMap<>(nums.length + 1);
        // 考虑 [0, 0] 或类似的情况
        prefixXORCountMap.put(0, 1);
        for (int num : nums) {
            prefixXOR ^= num;
            int count = prefixXORCountMap.getOrDefault(prefixXOR, 0);
            subarrayCount += count;
            prefixXORCountMap.put(prefixXOR, prefixXORCountMap.getOrDefault(prefixXOR, 0) + 1);
        }

        return subarrayCount;
    }
}
