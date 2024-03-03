package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LCR003Test {
    private final LCR003.BrianKernighan brianKernighan = new LCR003.BrianKernighan();
    private final LCR003.DpMsb dpMsb = new LCR003.DpMsb();

    @Test
    void countBits() {
        int[] expected1 = {0, 1, 1};
        int[] expected2 = {0, 1, 1, 2, 1, 2};
        assertArrayEquals(expected1, brianKernighan.countBits(2));
        assertArrayEquals(expected2, brianKernighan.countBits(5));
        assertArrayEquals(expected1, dpMsb.countBits(2));
        assertArrayEquals(expected2, dpMsb.countBits(5));
    }
}