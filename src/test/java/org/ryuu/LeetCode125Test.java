package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode125Test {
    private final LeetCode125.DoublePointer doublePointer = new LeetCode125.DoublePointer();

    @Test
    void isPalindrome() {
        String s1 = "A man, a plan, a canal: Panama";
        assertTrue(doublePointer.isPalindrome(s1));

        String s2 = "race a car";
        assertFalse(doublePointer.isPalindrome(s2));

        String s3 = "";
        assertTrue(doublePointer.isPalindrome(s3));
    }
}