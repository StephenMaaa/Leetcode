package String;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.
*/

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    // time complexity: O(n)
    // space complexity: O(n)
    public String minWindow(String source, String target) {
        // edge case
        if (source == null || target == null) {
            return null;
        }

        if (source.length() == 0 || target.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            map.put(target.charAt(i), map.getOrDefault(target.charAt(i), 0) + 1);
        }
        int unMatched = target.length();
        int start = 0;
        int minStart = 0;
        int minEnd = -1;
        for (int i = 0; i < source.length(); i++) {
            // case 1: str[i] in target
            // case 2: otherwise
            char key = source.charAt(i);
            if (map.containsKey(key)) {
                int count = map.get(key);

                // case 1: count > 0
                // case 2: count <= 0
                if (count > 0) {
                    map.put(key, count - 1);
                    unMatched--;
                } else {
                    map.put(key, count - 1);
                }

                // check
                if (unMatched == 0) {
                    // remove dup
                    while (true) {
                        char startKey = source.charAt(start);
                        // case 1: str[start] in target
                        // case 2: otherwise
                        if (!map.containsKey(startKey)) {
                            start++;
                        } else if (map.get(startKey) < 0) {
                            map.put(startKey, map.get(startKey) + 1);
                            start++;
                        } else {
                            break;
                        }
                    }

                    // update
                    if ((minEnd == -1 || (minEnd - minStart) > (i - start))) {
                        minStart = start;
                        minEnd = i;
                    }
                }
            }
        }
        return source.substring(minStart, minEnd + 1);
    }

    // approach 1 - Sliding Window TC: O(n) SC: O(n)
    public String minWindow2(String s, String t) {
        // generate frequency map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        // sliding window
        int start = 0;
        int minStart = 0;
        int minEnd = Integer.MAX_VALUE;
        int unmatched = t.length();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);

            if (map.containsKey(key)) {
                // update unmatched and map
                int count = map.get(key);
                if (count > 0) {
                    unmatched--;
                }
                map.put(key, count - 1);

                // check
                if (unmatched == 0) {
                    // prune
                    while (true) {
                        char startKey = s.charAt(start);
                        if (map.containsKey(startKey)) {
                            int startCount = map.get(startKey);

                            // case 1: count < 0
                            // case 2: count = 0
                            if (startCount < 0) {
                                map.put(startKey, startCount + 1);
                            } else {
                                break;
                            }
                        }
                        start++;
                    }

                    // update min
                    if (i - start < minEnd - minStart) {
                        minStart = start;
                        minEnd = i;
                    }
                }
            }
        }

        if (minEnd == Integer.MAX_VALUE) {
            minEnd = -1;
        }
        return s.substring(minStart, minEnd + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.println(test.minWindow2("ABDCEFGBBCDFE", "BCE"));
//        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
    }
}
