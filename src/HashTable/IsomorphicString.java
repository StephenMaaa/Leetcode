package HashTable;

/*
Two Strings are called isomorphic if the letters in one String can be remapped to get the second String. Remapping a letter means replacing all occurrences of it with another letter. The ordering of the letters remains unchanged. The mapping is two way and no two letters may map to the same letter, but a letter may map to itself. Determine if two given String are isomorphic.

        Assumptions:

        The two given Strings are not null.
        Examples:

        "abca" and "xyzx" are isomorphic since the mapping is 'a' <-> 'x', 'b' <-> 'y', 'c' <-> 'z'.

        "abba" and "cccc" are not isomorphic.
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

    public static void main(String[] args) {
        IsomorphicString test = new IsomorphicString();
        System.out.println(test.isomorphic("aba", "aaa"));
    }
}
