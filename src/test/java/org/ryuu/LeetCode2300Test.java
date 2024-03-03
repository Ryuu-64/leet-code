package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LeetCode2300Test {

    @Test
    void successfulPairs() {
        LeetCode2300 solution = new LeetCode2300();
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        int[] ints = solution.successfulPairs(spells, potions, 7);
        int[] excepted = {4, 0, 3};
        assertArrayEquals(excepted, ints);
    }
}