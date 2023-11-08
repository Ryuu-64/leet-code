package org.ryuu;

import org.junit.jupiter.api.Test;

import java.util.List;

class RepeatedDnaSequencesTest {
    @Test
    void findRepeatedDnaSequences() {
        RepeatedDnaSequences.RepeatedDnaSequencesSubString solution = new RepeatedDnaSequences.RepeatedDnaSequencesSubString();
        List<String> res = solution.findRepeatedDnaSequences("AAAAAAAAAA");
        System.out.println(res);
    }
}