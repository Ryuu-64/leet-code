package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/trapping-rain-water/description"></a>
 */
public class LeetCode42 {
    /**
     * 要知道总共可以储存多少格水
     * 如果一个格子(格子位于列 i)能储水，需要满足以下的所有条件：
     * 1. 格子不能是墙体
     * 2. 格高小于左墙，左墙列可以不是 i - 1, i - 2 也行
     * 3. 格高小于右墙，右墙列可以不是 i + 1, i + 2 也行
     * <p>
     * 因此可以使用左指针往右，右指针往左的双指针遍历方法
     * 找到当前左右指针的最小
     */
    public static class Solution1 {
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;

            int preMax = 0;
            int sufMax = 0;

            int count = 0;
            while (left < right) {
                preMax = Math.max(preMax, height[left]);
                sufMax = Math.max(sufMax, height[right]);
                count += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
            }

            return count;
        }
    }
}
