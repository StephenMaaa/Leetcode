package HashTable;

/*
LeetCode 205

Given two strings s and t, determine if they are isomorphic.

        Two strings s and t are isomorphic if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {
    // time complexity: O(n)
    // space complexity: O(n)
    public boolean isomorphic(String source, String target) {
        // edge case
        if (source.length() != target.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> dup = new HashSet<>();
        for (int i = 0; i < source.length(); i++) {
            // case 1: no such map pair and no dup
            // case 2: map pair exists
            if (!map.containsKey(source.charAt(i))) {
                if (!dup.contains(target.charAt(i))) {
                    map.put(source.charAt(i), target.charAt(i));
                    dup.add(target.charAt(i));
                } else {
                    return false;
                }
            } else {
                if (map.get(source.charAt(i)) != target.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    // approach 1: Set and Map TC: O(n) SC: O(1)
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();

        // map s to t
        for (int i = 0; i < s.length(); i++) {
            // check mapping
            // case 1: s[i] => t[i] -> check
            // case 2: no mapping -> map
            if (!map.containsKey(s.charAt(i))) {
                // case 1: valid
                // case 2: invalid
                if (used.contains(t.charAt(i))) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                    used.add(t.charAt(i));
                }
            } else {
                // check
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicString test = new IsomorphicString();
        System.out.println(test.isIsomorphic("aba", "aaa"));
    }
}
