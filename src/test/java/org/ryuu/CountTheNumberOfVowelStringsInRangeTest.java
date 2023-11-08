package org.ryuu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTheNumberOfVowelStringsInRangeTest {
    CountTheNumberOfVowelStringsInRange solution = new CountTheNumberOfVowelStringsInRange();

    @Test
    void vowelStrings() {
        int i = solution.vowelStrings(Arrays.asList("hey", "aeo", "mu", "ooo", "artro").toArray(new String[0]), 1, 4);
        assertEquals(3, i);
    }
}