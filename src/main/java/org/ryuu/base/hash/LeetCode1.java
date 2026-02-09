package org.ryuu.base.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/description/">1. 两数之和</a>
 */
public class LeetCode1 {
    public static
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> differenceMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int difference = target - num;
                if (differenceMap.containsKey(difference)) {
                    return new int[]{differenceMap.get(difference), i};
                }

                differenceMap.put(num, i);
            }

            return new int[0];
        }
    }
}
