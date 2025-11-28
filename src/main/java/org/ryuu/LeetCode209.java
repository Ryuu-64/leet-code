package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150">209. 长度最小的子数组</a>
 */
public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < length) {
            sum += nums[end];
            while (sum >= s) {
                minLength = Math.min(end - start + 1, minLength);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public int minSubArrayLenFromLeetCode(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
