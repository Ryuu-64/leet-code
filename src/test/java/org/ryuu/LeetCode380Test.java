package org.ryuu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode380Test {
    @Test
    void solution1test1() {
        LeetCode380.Solution1.RandomizedSet set = new LeetCode380.Solution1.RandomizedSet();

        set.remove(0);
        set.remove(0);

        set.insert(0);
        set.getRandom();
        set.remove(0);
        set.insert(0);
    }
    @Test
    void solution1test2() {
        LeetCode380.Solution1.RandomizedSet set = new LeetCode380.Solution1.RandomizedSet();
        set.insert(0);
        set.remove(0);
        set.insert(-1);
        set.remove(0);
        set.getRandom();
        set.getRandom();
        set.getRandom();
        set.getRandom();
        set.getRandom();
        set.getRandom();
        set.getRandom();
    }
}
