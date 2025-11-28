package org.ryuu;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150">202. 快乐数</a>
 */
public class LeetCode202 {
    public static class SolutionHashSet {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            while (n != 1 && !set.contains(n)) {
                set.add(n);
                n = next(n);
            }

            return n == 1;
        }

        private int next(int num) {
            int next = 0;
            while (num > 0) {
                int part = num % 10;
                num = num / 10;
                next += part * part;
            }

            return next;
        }
    }

    /**
     * 快慢指针环检测
     */
    public static class SolutionCycleDetection {
        public boolean isHappy(int n) {
            int slowPointer = n;
            int fastPointer = next(n);
            while (fastPointer != 1 && fastPointer != slowPointer) {
                slowPointer = next(slowPointer);
                fastPointer = next(next(fastPointer));
            }

            return fastPointer == 1;
        }

        private int next(int num) {
            int next = 0;
            while (num > 0) {
                int part = num % 10;
                num = num / 10;
                next += part * part;
            }

            return next;
        }
    }
}
