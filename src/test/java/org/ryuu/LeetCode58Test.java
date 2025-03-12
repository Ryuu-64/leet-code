package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode58Test {
    @Test
    void solution1() {
        LeetCode58.Solution1 solution1 = new LeetCode58.Solution1();
        int day = solution1.lengthOfLastWord("day");
        assertEquals(3, day);
    }
}
