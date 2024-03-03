package org.ryuu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCode2586Test {
    private final LeetCode2586 leetCode2586 = new LeetCode2586();

    @Test
    void vowelStrings() {
        int i = leetCode2586.vowelStrings(Arrays.asList("hey", "aeo", "mu", "ooo", "artro").toArray(new String[0]), 1, 4);
        assertEquals(3, i);
    }
}