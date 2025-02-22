package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii">80. 删除有序数组中的重复项 II</a>
 */
public class LeetCode80 {
    /**
     * 思考解题方法：
     * 根据题目条件可知，不能去除一个元素就将数组后的数都向左移动，降低时间复杂度
     * 可通过用数组右侧的新数覆盖左侧重复过多的数
     * 一边在左侧标记需要被覆盖数，一边在右侧寻找覆盖数
     * 右侧寻找时需要一直向前
     * 可知此题需要使用快慢指针
     * <p>
     * 快慢指针
     * 1 寻找快慢指针的起始位置
     * 考虑边界情况 [1,1,1],要重复2次至少需要2个数，因此快慢指针的起始位置为重复的次数
     * 2 寻找快指针移动条件
     * 快指针会在慢指针前寻找覆盖所需的数字，因此快指针一直走
     * 3 寻找慢指针移动条件 (也即寻找进行覆盖时的条件)
     * 以以下数据为例：（归纳推理）
     * 示例1：
     * [1,1,1,2]
     * nums[3] 覆盖 nums[2]
     * pSlow = 2
     * pFast = 3
     * num[0] != num[3]
     * 示例2：
     * [1,2,2,2,3]
     * nums[4] 覆盖 nums[3]
     * pSlow = 3
     * pFast = 4
     * num[1] != num[4]
     * 可知 num[pSlow - repeatCount] != nums[pFast] 条件时进行替换，并移动慢指针
     * 注意考虑到不覆盖时的情况：
     * 因为 pFast >= pSlow 且 repeatCount > 0
     * 所以 pFast > pSlow - repeatCount
     * 所以 num[pSlow - repeatCount] < nums[pFast] 恒成立
     * 所以 num[pSlow - repeatCount] != nums[pFast] 恒成立
     * 因此不需要为不会覆盖时的情况单独考虑
     * 即慢指针移动及数字覆盖的条件为：num[pSlow - repeatCount] != nums[pFast]
     */
    static class DoublePointer {
        public int removeDuplicates(int[] nums) {
            return removeDuplicates(nums, 2);
        }

        private static int removeDuplicates(int[] nums, int repeatCount) {
            if (nums.length <= repeatCount) {
                return nums.length;
            }

            int pSlow = repeatCount;
            int pFast = repeatCount;
            while (pFast < nums.length) {
                if (nums[pFast] != nums[pSlow - repeatCount]) {
                    nums[pSlow] = nums[pFast];
                    pSlow++;
                }
                pFast++;
            }
            return pSlow;
        }
    }
}
