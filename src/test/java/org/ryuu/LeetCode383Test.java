package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode383Test {
    private final LeetCode383 leetCode383 = new LeetCode383();

    @Test
    void canConstruct() {
        String ransomNote1 = "a";
        String magazine1 = "b";
        assertFalse(leetCode383.canConstruct(ransomNote1, magazine1));

        String ransomNote2 = "aa";
        String magazine2 = "ab";
        assertFalse(leetCode383.canConstruct(ransomNote2, magazine2));

        String ransomNote3 = "aa";
        String magazine3 = "aab";
        assertTrue(leetCode383.canConstruct(ransomNote3, magazine3));
    }
}