package org.ryuu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZumaGameTest {
    @Test
    void findMinStep() {
        List<UseCase> useCases = Arrays.asList(
                new UseCase("WRRBBW", "RB", -1),
                new UseCase("RRWWRRBBRR", "WB", 2),
                new UseCase("RRYGGYYRRYGGYYRR", "GGBBB", 5)
        );
        for (UseCase useCase : useCases) {
            assertEquals(
                    useCase.minStep,
                    ZumaGame.findMinStep(useCase.board, useCase.hand)
            );
        }
    }

    @Test
    void clean() {
        assertEquals("", ZumaGame.clean("RRR"));
        assertEquals("W", ZumaGame.clean("RRRW"));
        assertEquals("", ZumaGame.clean("WWRRRW"));
        assertEquals("BW", ZumaGame.clean("BRRRW"));
    }

    @Getter
    @AllArgsConstructor
    private static class UseCase {
        private final String board;
        private final String hand;
        private final int minStep;
    }
}