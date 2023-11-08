package org.ryuu;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        //region 获取文本的掩码，文本的最大长度的 map
        Map<Integer, Integer> maskLengthMap = new HashMap<>();
        for (String word : words) {
            int mask = this.getMask(word);
            int length = word.length();
            // 同掩码单词只需要最大的长度的
            if (!maskLengthMap.containsKey(mask) || length > maskLengthMap.get(mask)) {
                maskLengthMap.put(mask, length);
            }
        }
        //endregion
        //region 获取最大的乘积
        int ans = 0;
        for (int aMask : maskLengthMap.keySet()) {
            for (int bMask : maskLengthMap.keySet()) {
                if ((aMask & bMask) == 0) {
                    ans = Math.max(ans, maskLengthMap.get(aMask) * maskLengthMap.get(bMask));
                }
            }
        }
        //endregion
        return ans;
    }

    private int getMask(String word) {
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            int offset = word.charAt(i) - 'a';
            mask |= (1 << offset);
        }
        return mask;
    }
}
