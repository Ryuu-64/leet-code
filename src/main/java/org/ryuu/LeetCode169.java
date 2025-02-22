package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/majority-element">169. 多数元素</a>
 */
public class LeetCode169 {
    static class BoyerMooreVoting {
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = 0;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }

            return candidate;
        }
    }
}
