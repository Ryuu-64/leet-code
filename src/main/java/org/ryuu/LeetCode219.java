package org.ryuu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150">219. 存在重复元素 II</a>
 */
public class LeetCode219 {
    public static class SolutionHashMap {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> numIndexMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (numIndexMap.containsKey(num) && i - numIndexMap.get(num) <= k) {
                    return true;
                }

                numIndexMap.put(num, i);
            }

            return false;
        }
    }

    public static class SolutionSlidingWindow {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                if (i > k) {
                    set.remove(nums[i - k - 1]);
                }

                boolean add = set.add(nums[i]);
                if (!add) {
                    return true;
                }
            }

            return false;
        }
    }
}
