package org.ryuu.slidingwindow.variablesize;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/description/">2024. 考试的最大困扰度</a>
 */
public class LeetCode2024 {
    public static class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            int result = 0;
            Map<Character, Integer> answerCountMap = new HashMap<>();
            int left = 0;
            for (int right = 0; right < answerKey.length(); right++) {
                char rightChar = answerKey.charAt(right);
                answerCountMap.merge(rightChar, 1, Integer::sum);
                while (answerCountMap.getOrDefault('T', 0) > k && answerCountMap.getOrDefault('F', 0) > k) {
                    char leftChar = answerKey.charAt(left);
                    answerCountMap.merge(leftChar, -1, Integer::sum);
                    left++;
                }

                result = Math.max(right - left + 1, result);
            }

            return result;
        }
    }
}
