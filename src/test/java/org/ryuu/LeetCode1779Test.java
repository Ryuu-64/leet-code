package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.ryuu.LeetCode1779.nearestValidPoint;

class LeetCode1779Test {
    @Test
    public void nearestValidPointTest() {
        int x = 3;
        int y = 4;
        int[][] points = {
                {1, 2},
                {3, 1},
                {2, 4},
                {2, 3},
                {4, 4}
        };

        assertEquals(2, nearestValidPoint(x, y, points));
    }

    @Test
    public void nearestValidPointSamePositionTest() {
        int x = 3;
        int y = 4;
        int[][] points = {{3, 4}};

        assertEquals(0, nearestValidPoint(x, y, points));
    }

    @Test
    public void nearestValidPointNoValidPositionTest() {
        int x = 3;
        int y = 4;
        int[][] points = {{2, 3}};

        assertEquals(-1, nearestValidPoint(x, y, points));
    }
}