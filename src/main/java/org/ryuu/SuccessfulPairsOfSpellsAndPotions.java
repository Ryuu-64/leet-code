package org.ryuu;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/">1779. 找到最近的有相同 X 或 Y 坐标的点</a>
 */
public class SuccessfulPairsOfSpellsAndPotions {
    /**
     * 二分查找
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int spellLen = spells.length, potionLen = potions.length;
        int[] res = new int[spellLen];
        for (int i = 0; i < spellLen; i++) {
            int spell = spells[i];
            double minPotion = ((double) success) / spell;
            int left = 0;
            int right = potionLen;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (potions[mid] >= minPotion) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = potionLen - left;
        }
        return res;
    }
}
