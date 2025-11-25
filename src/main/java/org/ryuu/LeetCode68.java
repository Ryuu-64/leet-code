package org.ryuu;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/text-justification/description/">68. 文本左右对齐</a>
 */
public class LeetCode68 {
    public static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
            int len = words.length;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < len; ) {
                // list 装载当前行的所有 word
                list.clear();
                list.add(words[i]);
                int curLen = words[i++].length();
                while (i < len && curLen + 1 + words[i].length() <= maxWidth) {
                    curLen += 1 + words[i].length();
                    list.add(words[i++]);
                }

                // 当前行为最后一行，特殊处理为左对齐
                if (i == len) {
                    StringBuilder sb = new StringBuilder(list.get(0));
                    for (int j = 1; j < list.size(); j++) {
                        sb.append(" ").append(list.get(j));
                    }
                    while (sb.length() < maxWidth) {
                        sb.append(" ");
                    }
                    ans.add(sb.toString());
                    break;
                }

                // 如果当前行只有一个 word，特殊处理为左对齐
                int cnt = list.size();
                if (cnt == 1) {
                    StringBuilder str = new StringBuilder(list.get(0));
                    while (str.length() != maxWidth) {
                        str.append(" ");
                    }
                    ans.add(str.toString());
                    continue;
                }

                //  其余为一般情况
                //  wordWidth : 当前行单词总长度;
                //  spaceWidth : 当前行空格总长度;
                //  spaceItem : 往下取整后的单位空格长度
                int wordWidth = curLen - (cnt - 1);
                int spaceWidth = maxWidth - wordWidth;
                int spaceItemWidth = spaceWidth / (cnt - 1);
                StringBuilder spaceItem = new StringBuilder();
                for (int k = 0; k < spaceItemWidth; k++) {
                    spaceItem.append(" ");
                }
                StringBuilder sb = new StringBuilder();
                for (int k = 0, sum = 0; k < cnt; k++) {
                    String item = list.get(k);
                    sb.append(item);
                    if (k == cnt - 1) break;
                    sb.append(spaceItem);
                    sum += spaceItemWidth;
                    // 剩余的间隙数量（可填入空格的次数）
                    int remain = cnt - k - 1 - 1;
                    // 剩余间隙数量 * 最小单位空格长度 + 当前空格长度 < 单词总长度，则在当前间隙多补充一个空格
                    if (remain * spaceItemWidth + sum < spaceWidth) {
                        sb.append(" ");
                        sum++;
                    }
                }
                ans.add(sb.toString());
            }
            return ans;
        }
    }
}
