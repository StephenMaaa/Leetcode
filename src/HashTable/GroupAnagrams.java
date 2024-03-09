package HashTable;

/*
LeetCode 49

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/

import java.util.*;

public class GroupAnagrams {
//    // approach 1 - Sort + Map TC: O(klogkn) SC: O(kn)
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> res = new ArrayList<>();
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (int i = 0; i < strs.length; i++) {
//            char[] arr = strs[i].toCharArray();
//            Arrays.sort(arr);
//            String str = String.valueOf(arr);
//
//            if (!map.containsKey(str)) {
//                map.put(str, new ArrayList<>());
//            }
//            map.get(str).add(strs[i]);
//        }
//
//        for (String key : map.keySet()) {
//            res.add(map.get(key));
//        }
//        return res;
//    }

//    // approach 1: Map + Sorting TC: O(knlogk) SC: O(kn)
//    public List<List<String>> groupAnagrams2(String[] strs) {
//        // initialization
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String s : strs) {
//            // get key
//            char[] arr = s.toCharArray();
//            Arrays.sort(arr);
//            String key = new String(arr);
//
//            // check
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//
//            // update
//            map.get(key).add(s);
//        }
//
//        // populate
//        List<List<String>> res = new ArrayList<>();
//        for (String key : map.keySet()) {
//            res.add(map.get(key));
//        }
//        return res;
//    }
//
//    // approach 2: Counting TC: O(kn) SC: O(kn)
//    public List<List<String>> groupAnagrams(String[] strs) {
//        // initialization
//        Map<String, List<String>> map = new HashMap<>();
//        int[] count = new int[26];
//
//        for (String s : strs) {
//            // count occurrence
//            Arrays.fill(count, 0);
//            for (char c : s.toCharArray()) {
//                count[c - 'a']++;
//            }
//
//            // get key
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < count.length; i++) {
//                sb.append(count[i]);
//                sb.append('#');
//            }
//            String key = sb.toString();
//
//            // check
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//
//            // update
//            map.get(key).add(s);
//        }
//
//        // populate
//        List<List<String>> res = new ArrayList<>();
//        for (String key : map.keySet()) {
//            res.add(map.get(key));
//        }
//        return res;
//    }

    // approach 1: Counting + Map TC: O(kn) SC: O(kn)
    public List<List<String>> groupAnagrams(String[] strs) {
        // initialization
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        // group
        for (String str : strs) {
            // count frequency
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            // construct
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append(count[i]);
                sb.append('+');
            }

            // check anagram
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        // populate
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(test.groupAnagrams(arr));
    }
}
