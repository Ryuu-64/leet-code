package org.ryuu;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/xoh6Oh">LCR 001. 两数相除</a>
 */
public class LCR001 {
    public static class LCR001Power {
        public int divide(int dividend, int divisor) {
            //region 被除数为 0 的情况
            if (dividend == 0) {
                return 0;
            }
            //endregion

            //region 被除数为最小值的情况
            if (dividend == Integer.MIN_VALUE) {
                if (divisor == 1) {
                    return Integer.MIN_VALUE;
                }
                if (divisor == -1) {
                    return Integer.MAX_VALUE;
                }
            }
            //endregion

            //region 除数为最小值的情况
            if (divisor == Integer.MIN_VALUE) {
                return dividend == Integer.MIN_VALUE ? 1 : 0;
            }
            //endregion

            //region 将所有的正数取相反数，这样就只需要考虑一种情况
            // 因为 MIN = -2^31, MAX = 2^31 - 1, MIN 取反会溢出, 因此需要全部转化为负数
            boolean isReverse = false;
            if (dividend > 0) {
                dividend = -dividend;
                isReverse = !isReverse;
            }
            if (divisor > 0) {
                divisor = -divisor;
                isReverse = !isReverse;
            }
            //endregion

            //region 循环求刚好满足大于被除数的 divisor * 2 ^ i
            List<Integer> divisors = new ArrayList<>();
            divisors.add(divisor);
            int index = 0;
            while (divisors.get(index) >= dividend - divisors.get(index)) {
                divisors.add(divisors.get(index) + divisors.get(index));
                index++;
            }
            //endregion

            //region 求商数 (根据 divisor 与 2 的幂次的乘数)
            // dividend = quotient * divisor
            // quotient = (2 ^ i + 2 ^ j +....)
            int quotient = 0;
            // quotient 由 2 的多个幂次的和组成, 若忘记相加, 求得 quotient 可能比实际要小
            for (int i = divisors.size() - 1; i >= 0; --i) {
                if (divisors.get(i) >= dividend) {
                    quotient += 1 << i;
                    dividend -= divisors.get(i);
                }
            }
            //endregion

            return isReverse ? -quotient : quotient;
        }
    }
}
