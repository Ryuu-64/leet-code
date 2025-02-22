package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode2209Test {
    LeetCode2209 leetCode2209 = new LeetCode2209();

    @Test
    void minimumWhiteTiles1() {
        int i = leetCode2209.minimumWhiteTiles1("10110101", 2, 2);
        assertEquals(2, i);
    }

    @Test
    void minimumWhiteTiles2() {
        int i = leetCode2209.minimumWhiteTiles2("10110101", 2, 2);
        assertEquals(2, i);
    }
}
