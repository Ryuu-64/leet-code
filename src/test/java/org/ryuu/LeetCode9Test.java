package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode9Test {
    @Test
    void solution1() {
        LeetCode9.Solution1 solution1 = new LeetCode9.Solution1();
        boolean palindrome = solution1.isPalindrome(10);
        assertFalse(palindrome);
        palindrome = solution1.isPalindrome(20);
        assertFalse(palindrome);
        palindrome = solution1.isPalindrome(30);
        assertFalse(palindrome);
        palindrome = solution1.isPalindrome(100);
        assertFalse(palindrome);
    }
}
