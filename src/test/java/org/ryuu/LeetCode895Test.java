package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCode895Test {
    @Test
    public void FreqStackTest() {
        LeetCode895.FreqStack freqStack = new LeetCode895.FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        int pop;
        pop = freqStack.pop();
        assertEquals(5, pop);
        pop = freqStack.pop();
        assertEquals(7, pop);
        pop = freqStack.pop();
        assertEquals(5, pop);
        pop = freqStack.pop();
        assertEquals(4, pop);
    }
}