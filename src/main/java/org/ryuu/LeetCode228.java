package org.ryuu;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/summary-ranges">228. 汇总区间</a>
 */
public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int i = 0;
        int length = nums.length;
        while (i < length) {
            int low = i;
            //region 计算当前范围的高位
            i++;
            while (i < length && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            //endregion
            StringBuilder buffer = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                buffer.append("->");
                buffer.append(nums[high]);
            }
            ranges.add(buffer.toString());
        }
        return ranges;
    }
}
