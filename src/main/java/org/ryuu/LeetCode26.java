package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array">26. 删除有序数组中的重复项</a>
 */
public class LeetCode26 {
    /**
     * 由于要求元素的顺序一致，因此需要从左向右开始删除
     * 但这会导致数组的元素移动过频繁
     * 可以换个思路，将从左开始，将前方第一个不一样的数替换至左边
     * 因此可使用快慢指针
     * 慢指针负责记录被替换的元素位置
     * 快指针负责找后方不一样的元素
     */
    static class FastSlowPointer {
        public int removeDuplicates(int[] nums) {
            int length = nums.length;
            if (length == 0) {
                return 0;
            }
            int pSlow = 1;
            int pFast = 1;
            while (pFast < length) {
                if (nums[pFast] != nums[pFast - 1]) {
                    nums[pSlow] = nums[pFast];
                    pSlow++;
                }
                pFast++;
            }
            return pSlow;
        }
    }
}
