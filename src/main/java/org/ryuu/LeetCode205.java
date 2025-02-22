package org.ryuu;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/isomorphic-strings">205. 同构字符串</a>
 */
public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2tMap = new HashMap<>();
        Map<Character, Character> t2sMap = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (s2tMap.containsKey(sChar) && s2tMap.get(sChar) != tChar) {
                return false;
            }

            if (t2sMap.containsKey(tChar) && t2sMap.get(tChar) != sChar) {
                return false;
            }

            s2tMap.put(sChar, tChar);
            t2sMap.put(tChar, sChar);
        }

        return true;
    }
}
