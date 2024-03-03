package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCR002Test {
    private final LCR002.LCR002Language lcr002Language = new LCR002.LCR002Language();
    private final LCR002.LCR002Simulate lcr002Simulate = new LCR002.LCR002Simulate();

    @Test
    void addBinary() {
        lcr002Language.addBinary("11", "10");
        lcr002Language.addBinary("1010", "1011");
        lcr002Simulate.addBinary("11", "10");
        lcr002Simulate.addBinary("1010", "1011");
    }
}