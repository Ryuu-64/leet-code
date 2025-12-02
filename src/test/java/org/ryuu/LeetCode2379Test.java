package org.ryuu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LeetCode2379Test {
    @Test
    void minimumRecolors() {
        LeetCode2379.Solution solution = new LeetCode2379.Solution();
        String blocks = "WBWBBBW";
        int k = 2;
        int i = solution.minimumRecolors(blocks, k);
        Assertions.assertEquals(0, i);

        blocks = "WWBBBWBBBBBWWBWWWB";
        k = 16;
        i = solution.minimumRecolors(blocks, k);
        Assertions.assertEquals(6, i);

        blocks = "WBBWWBBWBW";
        k = 7;
        i = solution.minimumRecolors(blocks, k);
        Assertions.assertEquals(3, i);
    }
}
