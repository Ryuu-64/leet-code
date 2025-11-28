package org.ryuu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LeetCode290Test {
    @Test
    public void test() {
        LeetCode290.MySolution mySolution = new LeetCode290.MySolution();
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        boolean b = mySolution.wordPatternBijectiveMap(pattern, str);
        Assertions.assertTrue(b);

        pattern = "abba";
        str = "dog cat cat fish";
        b = mySolution.wordPatternBijectiveMap(pattern, str);
        Assertions.assertFalse(b);

        pattern = "ca";
        str = "a c";
        b = mySolution.wordPatternBijectiveMap(pattern, str);
        Assertions.assertTrue(b);
    }
}
