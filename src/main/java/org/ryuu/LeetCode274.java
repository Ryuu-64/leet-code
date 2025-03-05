package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/h-index/description/"></a>
 */
public class LeetCode274 {
    /**
     * count: 论文总数
     * 因为 h-index 的定义是引用次数 >= h 的论文数量 >= h，所以 h-index 范围是 [0, count]
     * 所以在计算引用次数时，大于 count 的引用次数等效于 count
     * 可以创建一个有序的数组 countArray, 长度为 count + 1 (因为有 0 次所以要 + 1), 索引为被引用的次数
     */
    public int hIndex(int[] citations) {
        int paperCount = citations.length;
        int[] countArray = new int[paperCount + 1];
        for (int citation : citations) {
            int min = Math.min(citation, paperCount);
            countArray[min]++;
        }

        int count = 0;
        for (int hIndex = paperCount; ; hIndex--) {
            // 算小的引用次数的论文数量时不要忘记比他大的引用次数的论文数量
            count += countArray[hIndex];
            if (count < hIndex) {
                continue;
            }

            return hIndex;
        }
    }
}
