package org.ryuu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCode488Test {
    private final LeetCode488 leetCode488 = new LeetCode488();

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
                    leetCode488.findMinStep(useCase.board, useCase.hand)
            );
        }
    }

    @Test
    void clean() {
        assertEquals("", leetCode488.clean("RRR"));
        assertEquals("W", leetCode488.clean("RRRW"));
        assertEquals("", leetCode488.clean("WWRRRW"));
        assertEquals("BW", leetCode488.clean("BRRRW"));
    }

    @Getter
    @AllArgsConstructor
    private static class UseCase {
        private final String board;
        private final String hand;
        private final int minStep;
    }
}