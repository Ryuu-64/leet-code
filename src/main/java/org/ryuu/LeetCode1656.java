package org.ryuu;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/design-an-ordered-stream/description/">design-an-ordered-stream</a>
 */
public class LeetCode1656 {
    public static class Solution1 {
        public static class OrderedStream {
            private final String[] a;
            private int ptr = 0;

            public OrderedStream(int n) {
                a = new String[n];
            }

            public List<String> insert(int idKey, String value) {
                a[idKey - 1] = value;
                int start = ptr;
                while (ptr < a.length && a[ptr] != null) {
                    ptr++;
                }

                return Arrays.asList(a).subList(start, ptr);
            }
        }
    }

    public static class Solution2 {
        public static class OrderedStream {
            private final String[] a;
            private int ptr = 1;

            public OrderedStream(int n) {
                a = new String[n + 1];
            }

            public List<String> insert(int idKey, String value) {
                a[idKey] = value;
                int start = ptr;
                while (ptr < a.length && a[ptr] != null) {
                    ptr++;
                }
                return Arrays.asList(a).subList(start, ptr);
            }
        }
    }
}


