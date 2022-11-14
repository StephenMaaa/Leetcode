package String;

/*
Given a string s, return the length of the longest substring that contains at most two distinct characters.
*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    // approach 1 - Sliding Window + Map TC: O(n) SC: O(1)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            // add the current character to the map
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            // check
            while (map.size() > 2) {
                int count = map.get(s.charAt(start));
                if (count == 1) {
                    map.remove(s.charAt(start));
                } else {
                    map.put(s.charAt(start), count - 1);
                }
                start++;
            }

            // update max
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters test = new LongestSubstringWithAtMostTwoDistinctCharacters();
        System.out.println(test.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}
