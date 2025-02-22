package org.ryuu;

public class LeetCode392 {
    static class DoublePointer {
        public boolean isSubsequence(String sequence, String text) {
            int sequenceLength = sequence.length();
            int textLength = text.length();
            int pSequence = 0;
            int pText = 0;
            while (pText < textLength && pSequence < sequenceLength) {
                char charSequence = sequence.charAt(pSequence);
                char charText = text.charAt(pText);
                if (charText == charSequence) {
                    pSequence++;
                }
                pText++;
            }

            return pSequence == sequenceLength;
        }
    }
}
