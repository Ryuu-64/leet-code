package org.ryuu.slidingwindow.variablesize;

import java.util.HashMap;
import java.util.Map;

public class LeetCode904 {
    public static class Solution {
        public int totalFruit(int[] fruits) {
            int result = 0;
            int left = 0;
            Map<Integer, Integer> typeIdCountMap = new HashMap<>();
            for (int right = 0; right < fruits.length; right++) {
                int rightTypeId = fruits[right];
                typeIdCountMap.merge(rightTypeId, 1, Integer::sum);
                while (typeIdCountMap.size() > 2) {
                    int leftTypeId = fruits[left];
                    typeIdCountMap.merge(leftTypeId, -1, Integer::sum);
                    if (typeIdCountMap.get(leftTypeId) == 0) {
                        typeIdCountMap.remove(leftTypeId);
                    }
                    left++;
                }

                result = Math.max(right - left + 1, result);
            }

            return result;
        }
    }
}
