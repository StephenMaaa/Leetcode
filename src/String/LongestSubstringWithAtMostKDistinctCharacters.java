package String;

/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

        For example, Given s = “eceba” and k = 2,

        T is "ece" which its length is 3.
*/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
//    // time complexity: O(n)
//    // space complexity: O(k)
//    public int lengthOfLongestSubstringKDistinct(String input, int k) {
//        Map<Character, Integer> map = new HashMap<>();
//        int max = 0;
//        int start = 0;
//
//        for (int i = 0; i < input.length(); i++) {
//            char var = input.charAt(i);
//            // case 1: size < k
//            // case 2: size == k
//            if (map.size() < k) {
//                map.put(var, map.getOrDefault(var, 0) + 1);
//            } else {
//                // case 1: var in map
//                // case 2: otherwise
//                if (map.containsKey(var)) {
//                    map.put(var, map.get(var) + 1);
//                } else {
//                    // remove
//                    while (map.size() == k) {
//                        char startVar = input.charAt(start);
//                        int count = map.get(startVar);
//                        if (count == 1) {
//                            map.remove(startVar);
//                        } else {
//                            map.put(startVar, count - 1);
//                        }
//                        start++;
//                    }
//                    map.put(var, 1);
//                }
//            }
//
//            // update max
//            max = Math.max(max, i - start + 1);
//        }
//        return max;
//    }

    // approach 1 - Sliding Window + Map TC: O(n) SC: O(k)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            // add
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            // check
            while (map.size() > k) {
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
        LongestSubstringWithAtMostKDistinctCharacters test = new LongestSubstringWithAtMostKDistinctCharacters();
        System.out.println(test.lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
