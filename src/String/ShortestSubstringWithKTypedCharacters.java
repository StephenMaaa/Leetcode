package String;

/*
Given a string, return the shortest contiguous substring that contains exactly k type of characters.

        Return an empty string if there does not exist such substring.

        Assumptions:

        The given string is not null.
        k >= 0.
        Examples:

        input = "aabcc", k = 3, output = "abc".
        input = "aabbbcccc", k = 3, output = "abbbc".
        input = "aabcc", k = 4, output = "".
*/

import java.util.HashMap;
import java.util.Map;

public class ShortestSubstringWithKTypedCharacters {
    // time complexity: O(n)
    // space complexity: O(k)
    public String shortest(String input, int k) {
        // edge case
        if (k == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int minStart = 0;
        int minEnd = Integer.MAX_VALUE;
        for (int i = 0; i < input.length(); i++) {
            char var = input.charAt(i);

            // case 1: size < k
            // case 2: size == k
            if (map.size() < k) {
                map.put(var, map.getOrDefault(var, 0) + 1);
            } else {
                // case 1: var in map
                // case 2: otherwise
                if (map.containsKey(var)) {
                    map.put(var, map.get(var) + 1);
                } else {
                    while (map.size() == k) {
                        char startVar = input.charAt(start);
                        int count = map.get(startVar);
                        if (count == 1) {
                            map.remove(startVar);
                        } else {
                            map.put(startVar, count - 1);
                        }
                        start++;
                    }
                    map.put(var, 1);
                }
            }

            // trim
            while (map.size() == k) {
                char startVar = input.charAt(start);
                int count = map.get(startVar);
                if (count > 1) {
                    map.put(startVar, count - 1);
                } else {
                    break;
                }
                start++;
            }

            // update min
            if (map.size() == k && (minEnd - minStart) > (i - start)) {
                minStart = start;
                minEnd = i;
            }
        }

        minEnd = minEnd == Integer.MAX_VALUE ? -1 : minEnd;
        return input.substring(minStart, minEnd + 1);
    }

    public static void main(String[] args) {
        ShortestSubstringWithKTypedCharacters test = new ShortestSubstringWithKTypedCharacters();
        System.out.println(test.shortest("aabcc", 0));
    }
}
