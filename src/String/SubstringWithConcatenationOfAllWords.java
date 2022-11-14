package String;

/*
You are given a string s and an array of strings words. All the strings of words are of the same length.

        A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.

        For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
        Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
//    // approach 1 - Sliding Window + Map TC: O(n) SC: O(n)
//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> res = new ArrayList<>();
//
//        // index map of words
//        Map<String, Integer> map = new HashMap<>();
//        for (String word : words) {
//            map.put(word, -1);
//        }
//        int start = 0;
//        int wordLength = words[0].length();
//
//        // iterate each word
//        for (int i = 0; i < s.length(); i += wordLength) {
//            // read the word
//            String word = s.substring(i, i + wordLength);
//
//            // maintain sliding window
//            if (!map.containsKey(word)) {
//                start = i + wordLength;
//            } else {
//                if (map.get(word) >= start) {
//                    start = i;
//                }
//                map.put(word, i);
//            }
//
//            // check
//            if ((words.length - 1) * wordLength == i - start) {
//                res.add(start);
//                start += wordLength;
//            }
//        }
//        return res;
//    }

    // approach 1 - Sliding Window + Map TC: O(len * n) SC: O(k * len)
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        // freq map of words
        Map<String, Integer> map = new HashMap<>();
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word, 0) + 1);
//        }
//        int start = 0;
//        int misMatched = words.length;
        int wordLength = words[0].length();

        for (int k = 0; k < wordLength; k++) {
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            int start = k;
            int misMatched = words.length;

            // iterate each word
            for (int i = k; i < s.length() - wordLength; i += wordLength) {
                // read the word
                String word = s.substring(i, i + wordLength);

                // maintain sliding window
                while (start <= i && (!map.containsKey(word) || map.get(word) == 0)) {
                    String startWord = s.substring(start, start + wordLength);
                    if (map.containsKey(startWord)) {
                        int count = map.get(startWord);
                        map.put(startWord, count + 1);
                        misMatched++;
                    }
                    start += wordLength;
                }

                if (map.containsKey(word)) {
                    int count = map.get(word);
                    map.put(word, count - 1);
                    misMatched--;
                }

                // check
                if (misMatched == 0) {
                    res.add(start);
                }
            }
            map.clear();
        }
        return res; 
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords test = new SubstringWithConcatenationOfAllWords();
        String[] words = new String[]{"fooo", "barr", "wing", "ding", "wing"};
        System.out.println(test.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", words));
    }
}
