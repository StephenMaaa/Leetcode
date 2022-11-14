package String;

/*
Given two strings s1 and s2, find the shortest substring in s1 containing all characters in s2.

        If there does not exist such substring in s1, return an empty string.

        Assumptions:

        s1 and s2 are not null or empty.
        Examples:

        s1= “The given test strings”

        s2: “itsst”

        Output string: “st stri”
*/

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContainingAllCharactersOfAnotherString {
//    // time complexity: O(n)
//    // space complexity: O(n)
//    public String smallest(String s1, String s2) {
//        // edge case
//        if (s1 == null || s2 == null) {
//            return null;
//        }
//
//        if (s1.length() == 0 || s2.length() == 0) {
//            return "";
//        }
//
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s2.length(); i++) {
//            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
//        }
//        int unMatched = s2.length();
//        int start = 0;
//        int minStart = 0;
//        int minEnd = -1;
//        for (int i = 0; i < s1.length(); i++) {
//            // case 1: str[i] in s2
//            // case 2: otherwise
//            char key = s1.charAt(i);
//            if (map.containsKey(key)) {
//                int count = map.get(key);
//
//                // case 1: count > 0
//                // case 2: count <= 0
//                if (count > 0) {
//                    map.put(key, count - 1);
//                    unMatched--;
//
//                    // check
//                    if (unMatched == 0) {
//                        // trim
//                        while (!map.containsKey(s1.charAt(start))) {
//                            start++;
//                        }
//
//                        if (minEnd == -1 || (minEnd - minStart) > (i - start)) {
//                            minStart = start;
//                            minEnd = i;
//                        }
//                    }
//                } else {
//                    // remove dup
//                    while (s1.charAt(start) != key) {
//                        char startKey = s1.charAt(start);
//                        // case 1: str[start] in s2
//                        // case 2: otherwise
//                        if (map.containsKey(startKey)) {
//                            int startCount = map.get(startKey);
//                            if (startCount >= 0) {
//                                unMatched++;
//                            } else {
//                                unMatched--;
//                            }
//                            map.put(startKey, startCount + 1);
//                        }
//                        start++;
//                    }
//                    start++;
//
//                    // check
//                    if (unMatched == 0) {
//                        // trim
//                        while (!map.containsKey(s1.charAt(start))) {
//                            start++;
//                        }
//
//                        if (minEnd == -1 || (minEnd - minStart) > (i - start)) {
//                            minStart = start;
//                            minEnd = i;
//                        }
//                    }
//                }
//            }
//        }
//
//        // trim
//        if (unMatched == 0) {
//            while (!map.containsKey(s1.charAt(start))) {
//                start++;
//            }
//            if (minEnd == -1 || (minEnd - minStart) > (s1.length() - 1 - start)) {
//                minStart = start;
//                minEnd = s1.length() - 1;
//            }
//        }
//        return s1.substring(minStart, minEnd + 1);
//    }

    // time complexity: O(n)
    // space complexity: O(n)
    public String smallest(String s1, String s2) {
        // edge case
        if (s1 == null || s2 == null) {
            return null;
        }

        if (s1.length() == 0 || s2.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int unMatched = s2.length();
        int start = 0;
        int minStart = 0;
        int minEnd = -1;
        for (int i = 0; i < s1.length(); i++) {
            // case 1: str[i] in s2
            // case 2: otherwise
            char key = s1.charAt(i);
            if (map.containsKey(key)) {
                int count = map.get(key);

                // case 1: count > 0
                // case 2: count <= 0
                if (count > 0) {
                    map.put(key, count - 1);
                    unMatched--;
                } else {
                    map.put(key, map.get(key) - 1);
                }

                // check
                if (unMatched == 0) {
                    // trim
                    while (true) {
                        char startVar = s1.charAt(start);
                        if (!map.containsKey(startVar)) {
                            start++;
                        } else if (map.get(startVar) < 0) {
                            start++;
                            map.put(startVar, map.get(startVar) + 1);
                        } else {
                            break;
                        }
                    }

                    if (minEnd == -1 || (minEnd - minStart) > (i - start)) {
                        minStart = start;
                        minEnd = i;
                    }
                }
            }
        }
        return s1.substring(minStart, minEnd + 1);
    }

    public static void main(String[] args) {
        SmallestSubstringContainingAllCharactersOfAnotherString test = new SmallestSubstringContainingAllCharactersOfAnotherString();
        System.out.println(test.smallest("movefastermoveslower", "term"));
    }
}
