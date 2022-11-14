package HashTable;

/*
Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

        A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

        Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
//    // approach 1 - Two Maps TC: O(kn) SC: O(kn)
//    public List<String> findAndReplacePattern(String[] words, String pattern) {
//        List<String> res = new ArrayList<>();
//        for (String word : words) {
//            // bijection mapping
//            Map<Character, Character> inMap = new HashMap<>();
//            Map<Character, Character> outMap = new HashMap<>();
//            boolean flag = true;

//            // check mapping
//            for (int i = 0; i < word.length(); i++) {
//                // add mapping
//                if (!inMap.containsKey(pattern.charAt(i)) && !outMap.containsKey(word.charAt(i))) {
//                    inMap.put(pattern.charAt(i), word.charAt(i));
//                    outMap.put(word.charAt(i), pattern.charAt(i));
//                }
//
//                // check
//                if (!inMap.containsKey(pattern.charAt(i)) || !outMap.containsKey(word.charAt(i)) || inMap.get(pattern.charAt(i)) != word.charAt(i) || outMap.get(word.charAt(i)) != pattern.charAt(i)) {
//                    flag = false;
//                    break;
//                }
//            }
//
//            if (flag) {
//                res.add(word);
//            }
//        }
//        return res;
//    }

    // approach 2 - One Map TC: O(kn) SC: O(kn)
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            // bijection mapping
            Map<Character, Character> map = new HashMap<>();
            boolean flag = true;

            // check mapping
            for (int i = 0; i < word.length(); i++) {
                // add mapping
                if (!map.containsKey(word.charAt(i))) {
                    map.put(word.charAt(i), pattern.charAt(i));
                }

                // check
                if (map.get(word.charAt(i)) != pattern.charAt(i)) {
                    flag = false;
                    break;
                }
            }

            // bijection check
            boolean[] arr = new boolean[26];
            for (char c : map.values()) {
                if (arr[c - 'a']) {
                    flag = false;
                    break;
                }
                arr[c - 'a'] = true;
            }

            if (flag) {
                res.add(word);
            }
        }
        return res;
    }
}
