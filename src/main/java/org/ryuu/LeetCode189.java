package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/rotate-array">189. 轮转数组</a>
 */
public class LeetCode189 {
    /**
     * 题目要求空间复杂度为 O(1), 因此只能原地操作数组，不能借助其他的新空间
     * <p>
     * k = 2
     * length = 5
     * [1, 2, 3, 4, 5]
     * 轮转后：
     * [4, 5, 1, 2, 3]
     * 可见 先将整个数组倒置
     * [5, 4, 3, 2, 1]
     * 再将 [0, k - 1] 与 [k, length-1] 的两段位置再倒置，即可完成轮转
     * 需要考虑 k >= nums.length 的情况
     * k = nums.length 时：
     * 与 k = 0 一致
     * k = nums.length + 1 时：
     * 与 k = 1 一致
     * 因此可预处理 k, k %= nums.length
     */
    static class ArrayFlip {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private static void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
