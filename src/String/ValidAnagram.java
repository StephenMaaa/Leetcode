package String;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    // approach 1 - Map TC: O(n) SC: O(n)
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        // frequency map
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // check anagram
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            }
            int count = map.get(t.charAt(i));
            if (count == 1) {
                map.remove(t.charAt(i));
            } else {
                map.put(t.charAt(i), count - 1);
            }
        }
        return map.isEmpty();
    }

    // approach 2 - int array TC: O(n) SC: O(1)
    public boolean isAnagram2(String s, String t) {
        // edge case
        if (s.length() != t.length()) {
            return false;
        }

        int[] arrA = new int[26];
        int[] arrB = new int[26];

        // frequency map
        for (int i = 0; i < s.length(); i++) {
            arrA[s.charAt(i) - 'a']++;
            arrB[t.charAt(i) - 'a']++;
        }

        // check anagram
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] != arrB[i]) {
                return false;
            }
        }
        return true;
    }

    // approach 2 - sort TC: O(n) SC: O(1)
    public boolean isAnagram3(String s, String t) {
        // edge case
        if (s.length() != t.length()) {
            return false;
        }

        // sort
        char[] arrA = s.toCharArray();
        char[] arrB = t.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        // check anagram
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] != arrB[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram test = new ValidAnagram();
        System.out.println(test.isAnagram2("anagram", "nagaram"));
    }
}
