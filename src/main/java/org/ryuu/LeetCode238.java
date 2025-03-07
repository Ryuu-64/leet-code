package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/description/"></a>
 * input: [2, 3, 4]
 * output: [12, 8, 6]
 * <p>
 * 12 = [1, 3, 4]
 * 8  = [2, 1, 4]
 * 6  = [2, 3, 1]
 * <p>
 * 可发现计算时的数据组成的二维数组的对角线都是1
 * 左下角和右上角的数据是原始的输入数据
 * 而且可发现每个角上的数据是可以在上一个乘积上直接乘
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }

        int[] results = new int[len];
        results[0] = 1;
        for (int i = 1; i < len; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        // 注意将左下角已产生的部分乘积与右上角的乘积隔离开
        int multiply = 1;
        for (int i = len - 2; i >= 0; i--) {
            multiply *= nums[i + 1];
            results[i] *= multiply;
        }

        return results;
    }
}
