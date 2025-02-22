package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode392Test {
    private final LeetCode392.DoublePointer doublePointer = new LeetCode392.DoublePointer();

    @Test
    void isSubsequence() {
        String s1 = "abc";
        String t1 = "ahbgdc";
        assertTrue(doublePointer.isSubsequence(s1, t1));

        String s2 = "axc";
        String t2 = "ahbgdc";
        assertFalse(doublePointer.isSubsequence(s2, t2));
    }
}