package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array">88. 合并两个有序数组</a>
 */
public class LeetCode88 {
    /**
     * 由于题目的复杂度要求，因此不能直接合并两个数组之后使用语言内置的 sort
     * 由于 nums1 数组中已为 nums2 数组中的元素提供空间，因此无需构建新的合并数组，而应该直接将 nums2 合并至 nums1 中，可由此降低时间复杂度
     * <p>
     * 从后往前排序即可避免在合并中可能覆盖掉 nums1 的问题
     */
    static class DoublePointer {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int pointer1 = m - 1;
            int pointer2 = n - 1;
            int pointerTail = m + n - 1;
            int currValue;
            while (pointer1 >= 0 || pointer2 >= 0) {
                if (pointer1 == -1) {
                    currValue = nums2[pointer2];
                    pointer2--;
                } else if (pointer2 == -1) {
                    currValue = nums1[pointer1];
                    pointer1--;
                } else if (nums1[pointer1] > nums2[pointer2]) {
                    currValue = nums1[pointer1];
                    pointer1--;
                } else {
                    currValue = nums2[pointer2];
                    pointer2--;
                }
                nums1[pointerTail] = currValue;
                pointerTail--;
            }
        }
    }
}
