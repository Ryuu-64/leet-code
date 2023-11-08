package org.ryuu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/repeated-dna-sequences"/>
 */
public interface RepeatedDnaSequences {
    List<String> findRepeatedDnaSequences(String sourceString);

    /**
     * 哈希表
     * 位运算
     * 滑动窗口
     */
    class RepeatedDnaSequencesSlidingWindow implements RepeatedDnaSequences {
        private static final int windowLength = 10;
        private static final int bitPerNucleotide = 2;
        private static final Map<Character, Integer> nucleotideNameBitMap = new HashMap<Character, Integer>() {{
            put('A', 0b00);
            put('C', 0b01);
            put('G', 0b10);
            put('T', 0b11);
        }};

        public List<String> findRepeatedDnaSequences(String sourceString) {
            List<String> ans = new ArrayList<>();
            int sourceStringLength = sourceString.length();
            if (sourceStringLength <= windowLength) {
                return ans;
            }

            int x = 0;
            //region 初始化滑动窗口
            for (int i = 0; i < windowLength - 1; i++) {
                x <<= bitPerNucleotide;
                x |= nucleotideNameBitMap.get(sourceString.charAt(i));
            }
            //endregion
            Map<Integer, Integer> sequeneceCountMap = new HashMap<>();
            for (int i = 0; i <= sourceStringLength - windowLength; i++) {
                //region 窗口滑动
                x <<= bitPerNucleotide;
                // 更新下一最低位
                x |= nucleotideNameBitMap.get(sourceString.charAt(i + windowLength - 1));
                // 清除无效高位
                x &= (1 << (windowLength * bitPerNucleotide)) - 1;
                //endregion
                sequeneceCountMap.put(x, sequeneceCountMap.getOrDefault(x, 0) + 1);
                if (sequeneceCountMap.get(x) == 2) {
                    ans.add(sourceString.substring(i, i + windowLength));
                }
            }
            return ans;
        }
    }

    class RepeatedDnaSequencesSubString implements RepeatedDnaSequences {
        private static final int targetLength = 10;

        public List<String> findRepeatedDnaSequences(String dna) {
            Map<String, Integer> sequenceCountMap = new HashMap<>();
            for (int i = 0; i <= dna.length() - targetLength; i++) {
                String dnaSequence = dna.substring(i, i + targetLength);
                sequenceCountMap.put(dnaSequence, sequenceCountMap.getOrDefault(dnaSequence, 0) + 1);
            }

            List<String> ans = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : sequenceCountMap.entrySet()) {
                if (entry.getValue() > 1) {
                    ans.add(entry.getKey());
                }
            }
            return ans;
        }
    }
}
