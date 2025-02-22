package org.ryuu;

/**
 * <a href="https://leetcode.cn/problems/ransom-note">383. 赎金信</a>
 */
public class LeetCode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        char[] magazineChars = magazine.toCharArray();
        int[] map = new int[26];
        for (char magazineChar : magazineChars) {
            map[magazineChar - 'a']++;
        }

        char[] ransomNoteChars = ransomNote.toCharArray();
        for (char ransomNoteChar : ransomNoteChars) {
            map[ransomNoteChar - 'a']--;
            if (map[ransomNoteChar - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
