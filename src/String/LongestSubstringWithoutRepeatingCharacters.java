package String;

/*
Given a string, find the longest substring without any repeating characters and return the length of it. The input string is guaranteed to be not null.

        For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            if (set.contains(element)) {
                for (int j = left; j < i; j++) {
                    if (input.charAt(j) == element) {
                        left = j + 1;
                        break;
                    }
                    set.remove(input.charAt(j));
                }
            } else {
                set.add(element);
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

//    // approach 1 - Sliding Window + Set TC: O(n) SC: O(MIN(m, n))
//    public int lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet<>();
//        int max = 0;
//        int start = 0;
//        for (int i = 0; i < s.length(); i++) {
//            // check
//            while (set.contains(s.charAt(i))) {
//                set.remove(s.charAt(start++));
//            }
//
//            // add
//            set.add(s.charAt(i));
//
//            // update max
//            max = Math.max(max, i - start + 1);
//        }
//        return max;
//    }

    // approach 2 - Sliding Window + Map TC: O(n) SC: O(MIN(m, n))
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            // check
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
                start = map.get(s.charAt(i)) + 1;
            }

            // add
            map.put(s.charAt(i), i);

            // update max
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    // approach 1: Sliding Window + Set TC: O(n) SC: O(1)
    public int lengthOfLongestSubstring3(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int max = 0;

        // sliding window
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // check dup
            if (set.contains(c)) {
                // remove all characters before the current char
                while (s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                set.add(c);
            }

            // update max
            max = Math.max(max, set.size());
        }
        return max;
    }

    // approach 2: Sliding Window + Map TC: O(n) SC: O(1)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;

        // sliding window
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // check dup
            if (map.containsKey(c) && map.get(c) >= start) {
                // remove all characters before the current char
                int prev = map.get(c);
                start = prev + 1;
            }
            map.put(c, i);

            // update max
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(test.lengthOfLongestSubstring("aabaab!bb"));
    }
}
