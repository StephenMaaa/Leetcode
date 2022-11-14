package String;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
*/

import java.util.*;

public class FirstUniqueCharacterInAString {
    // approach 1 - Map TC: O(n) SC: O(n)
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // frequency map
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // approach 2 - Bit Operation TC: O(n) SC: O(1)
    public int firstUniqChar2(String s) {
        int occurrence = 0;
        int dup = 0;

        // frequency map
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            // check dup
            if ((dup >> index & 1) == 1) {
                continue;
            }

            // update occurrence
            if ((occurrence >> index & 1) == 0) {
                occurrence |= 1 << index;
            } else {
                dup |= 1 << index;
            }
        }

        // find the first unique character
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if ((occurrence >> index & 1) == 1 && (dup >> index & 1) == 0) {
                return i;
            }
        }
        return -1;
    }

    // approach 3 - One Pass TC: O(n) SC: O(1)
    public char firstUniqChar3(String s) {
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                list.add(s.charAt(i));
            } else {
                list.remove((Character) s.charAt(i));
            }
        }
        return list.size() == 0 ? ' ' : list.get(0);
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString test = new FirstUniqueCharacterInAString();
        System.out.println(test.firstUniqChar3("eaacbbd"));
    }
}
