package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode274Test {

    @Test
    void hIndex() {
        int[] input = {3, 0, 6, 1, 5};
        int i = new LeetCode274().hIndex(input);
        assertEquals(3, i);

        input = new int[]{1, 2, 5, 5, 5};
        i = new LeetCode274().hIndex(input);
        assertEquals(3, i);
    }
}
