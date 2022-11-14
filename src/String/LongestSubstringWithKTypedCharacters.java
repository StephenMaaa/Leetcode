package String;

/*
Given a string, return the longest contiguous substring that contains exactly k type of characters.

        Return null if there does not exist such substring.

        Assumptions:

        The given string is not null and guaranteed to have at least k different characters.
        k > 0.
        Examples:

        input = "aabcc", k = 3, output = "aabcc".
        input = "aabcccc", k = 2, output = "bcccc".
*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKTypedCharacters {
    // time complexity: O(n)
    // space complexity: O(k)
    public String longest(String input, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxStart = 0;
        int maxEnd = -1;
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
                    // remove
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

            // update max
            if (map.size() == k && (maxEnd - maxStart) < (i - start)) {
                maxStart = start;
                maxEnd = i;
            }
        }
        return input.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        LongestSubstringWithKTypedCharacters test = new LongestSubstringWithKTypedCharacters();
        System.out.println(test.longest("aabcccc", 2));
    }
}
