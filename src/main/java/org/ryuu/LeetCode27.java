package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/remove-element">27. 移除元素</a>
 */
public class LeetCode27 {
    /**
     * 需要返回新数组的长度，且移除实现指定为原地算法(in-place algorithm)
     * 且题目单独提到 "元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。"
     * 可面向条件作答，合理运用此条件
     * 将舍弃的元素与在超过数组长度的元素进行交互
     * 此时数组左侧全为新数组元素 (方便获取新数组长度)，超出新数组长度的元素全为舍弃的元素(避免多次移动元素位置)
     */
    static class DoublePointer {
        public int removeElement(int[] nums, int val) {
            int pLeft = 0;
            int pRight = nums.length - 1;
            while (pLeft <= pRight) {
                if (nums[pLeft] == val) {
                    nums[pLeft] = nums[pRight];
                    pRight--;
                } else {
                    pLeft++;
                }
            }

            return pLeft;
        }
    }
}
