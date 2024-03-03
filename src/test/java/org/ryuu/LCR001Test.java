package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCR001Test {
    private final LCR001.LCR001Power lcr001 = new LCR001.LCR001Power();

    @Test
    void divide() {
        assertEquals(7, lcr001.divide(15, 2));
        assertEquals(1, lcr001.divide(1, 1));
        assertEquals(-2, lcr001.divide(7, -3));
    }
}