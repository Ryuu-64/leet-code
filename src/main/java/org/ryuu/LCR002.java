package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/JFETK5">LCR 002. 二进制求和</a>
 */
public class LCR002 {
    public static class LCR002Language {
        public String addBinary(String a, String b) {
            return Integer.toBinaryString(
                    Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
            );
        }
    }

    public static class LCR002Simulate {
        public String addBinary(String a, String b) {
            StringBuilder stringBuilder = new StringBuilder();
            int length = Math.max(a.length(), b.length());
            int carry = 0;

            for (int i = 0; i < length; i++) {
                if (i < a.length()) {
                    carry += a.charAt(a.length() - 1 - i) - '0';
                }

                if (i < b.length()) {
                    carry += b.charAt(b.length() - 1 - i) - '0';
                }
                stringBuilder.append((char) (carry % 2 + '0'));
                carry /= 2;
            }

            if (carry > 0) {
                stringBuilder.append('1');
            }

            stringBuilder.reverse();
            return stringBuilder.toString();
        }
    }
}
