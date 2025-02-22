package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode205Test {
    private final LeetCode205 leetCode205 = new LeetCode205();

    @Test
    void isIsomorphic() {
        String s1 = "egg";
        String t1 = "add";
        assertTrue(leetCode205.isIsomorphic(s1, t1));

        String s2 = "foo";
        String t2 = "bar";
        assertFalse(leetCode205.isIsomorphic(s2, t2));

        String s3 = "paper";
        String t3 = "title";
        assertTrue(leetCode205.isIsomorphic(s3, t3));
    }
}