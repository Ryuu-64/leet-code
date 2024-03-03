package org.ryuu;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/">2300. 咒语和药水的成功对数</a>
 */
public class LeetCode2300 {
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
