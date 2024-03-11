package String;

/*
LeetCode 567

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

        In other words, return true if one of s1's permutations is the substring of s2.
*/

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    // approach 1: Sliding Window TC: O(n) SC: O(m)
    public boolean checkInclusion(String s1, String s2) {
        // initialization
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int unmatched = map.size();
        int left = 0;

        // sliding window
        int i = 0;
        while (i < s2.length()) {
            char c = s2.charAt(i);

            // check
            // case 1: c in s1
            // case 2: c not in s1
            if (!map.containsKey(c)) {
                // skip
                while (i < s2.length() && !map.containsKey(s2.charAt(i))) {
                    i++;
                }

                // re init
                map = new HashMap<>();
                for (char ch : s1.toCharArray()) {
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                }
                unmatched = map.size();
                left = i;
            } else {
                // update freq
                int count = map.get(c);
                map.put(c, count - 1);

                // check match
                // case 1: matched -> update
                // case 2: less matched
                // case 3: over matched -> move sliding window
                if (count == 1) {
                    unmatched--;
                } else if (count < 1) {
                    // move sliding window
                    while (s2.charAt(left) != c) {
                        char curr = s2.charAt(left);
                        left++;

                        // remove from freq
                        count = map.get(curr);
                        map.put(curr, count + 1);

                        // update match
                        if (count == 0) {
                            unmatched++;
                        }
                    }
                }

                // check permutation
                if (unmatched == 0) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    // approach 2: Optimized Sliding Window TC: O(n) SC: O(1)
    public boolean checkInclusion2(String s1, String s2) {
        // edge case
        if (s1.length() > s2.length()) {
            return false;
        }

        // initialization
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        // count match
        int unmatched = 26;
        for (int i = 0; i < map1.length; i++) {
            if (map1[i] == map2[i]) {
                unmatched--;
            }
        }

        // check
        if (unmatched == 0) {
            return true;
        }

        // sliding window
        for (int i = s1.length(); i < s2.length(); i++) {
            char left = s2.charAt(i - s1.length());
            char right = s2.charAt(i);

            // update matched
            if (map1[left - 'a'] == map2[left - 'a']) {
                unmatched++;
            } else if (map1[left - 'a'] == map2[left - 'a'] - 1) {
                unmatched--;
            }

            // update freq
            map2[left - 'a']--;
            map2[right - 'a']++;

            // update matched
            if (map1[right - 'a'] == map2[right - 'a']) {
                unmatched--;
            } else if (map1[right - 'a'] == map2[right - 'a'] - 1) {
                unmatched++;
            }

            // check
            if (unmatched == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString test = new PermutationInString();
        System.out.println(test.checkInclusion2("ab", "eidbaooo"));
    }
}
