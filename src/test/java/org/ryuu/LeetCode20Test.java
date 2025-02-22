package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode20Test {
    private final LeetCode20.AuxiliaryStackWithoutMap auxiliaryStackWithoutMap = new LeetCode20.AuxiliaryStackWithoutMap();
    private final LeetCode20.AuxiliaryStackWithMap auxiliaryStackWithMap = new LeetCode20.AuxiliaryStackWithMap();

    @Test
    void isValid() {
        String s1 = "()";
        assertTrue(auxiliaryStackWithoutMap.isValid(s1));
        assertTrue(auxiliaryStackWithMap.isValid(s1));

        String s2 = "()[]{}";
        assertTrue(auxiliaryStackWithoutMap.isValid(s2));
        assertTrue(auxiliaryStackWithMap.isValid(s2));

        String s3 = "(]";
        assertFalse(auxiliaryStackWithoutMap.isValid(s3));
        assertFalse(auxiliaryStackWithMap.isValid(s3));

        String s4 = "((";
        assertFalse(auxiliaryStackWithoutMap.isValid(s4));
        assertFalse(auxiliaryStackWithMap.isValid(s4));

        String s5 = "){";
        assertFalse(auxiliaryStackWithoutMap.isValid(s5));
        assertFalse(auxiliaryStackWithMap.isValid(s5));

        String s6 = "))";
        assertFalse(auxiliaryStackWithoutMap.isValid(s6));
        assertFalse(auxiliaryStackWithMap.isValid(s6));
    }
}