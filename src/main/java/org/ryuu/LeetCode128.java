package org.ryuu;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150">128. 最长连续序列</a>
 */
public class LeetCode128 {
    public static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }

            int longestStreak = 0;
            for (int numInSet : numSet) {
                if (numSet.contains(numInSet - 1)) {
                    continue;
                }

                int num = numInSet;
                int streak = 1;
                while (numSet.contains(num + 1)) {
                    streak++;
                    num++;
                }

                longestStreak = Math.max(longestStreak, streak);
            }

            return longestStreak;
        }
    }
}
