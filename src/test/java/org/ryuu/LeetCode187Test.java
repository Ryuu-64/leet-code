package org.ryuu;

import org.junit.jupiter.api.Test;

import java.util.List;

class LeetCode187Test {
    @Test
    void findRepeatedDnaSequences() {
        LeetCode187.LeetCode187SubString solution = new LeetCode187.LeetCode187SubString();
        List<String> res = solution.findRepeatedDnaSequences("AAAAAAAAAA");
        System.out.println(res);
    }
}