package String;

/*
Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.

        Assumptions

        sh is not null or empty.
        lo is not null.
        Examples

        l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
//    public List<Integer> allAnagrams(String sh, String lo) {
//        List<Integer> res = new ArrayList<>();
//        Map<Character, Integer> map = generateMap(sh);
//
//        boolean full = true;
//        int index = -1;
//        for (int i = 0; i < lo.length(); i++) {
//            Character element = lo.charAt(i);
//            if (map.containsKey(element)) {
//                // initialize the index
//                if (full) {
//                    index = i;
//                    full = false;
//                }
//
//                int count = map.get(element);
//                if (count > 1) {
//                    map.put(element, count - 1);
//                } else {
//                    map.remove(element);
//                }
//
//                // check correctness
//                if (map.isEmpty()) {
//                    res.add(index);
//                    map = generateMap(sh);
//                    full = true;
//                }
//            } else {
//                // reset index and map
//                map = generateMap(sh);
//                full = true;
//            }
//        }
//        return res;
//    }

    public List<Integer> allAnagrams(String sh, String lo) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = generateMap(sh);

        int match = 0;
        for (int i = 0; i < lo.length(); i++) {
            // move left bound
            if (i >= sh.length()) {
                Character left = lo.charAt(i - sh.length());
                if (map.containsKey(left)) {
                    int count = map.get(left);
                    map.put(left, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }

            // move right bound
            Character element = lo.charAt(i);
            if (map.containsKey(element)) {
                int count = map.get(element);
                map.put(element, count - 1);

                if (count == 1) {
                    match++;
                }

                // check correctness
                if (match == map.size()) {
                    res.add(i - sh.length() + 1);
                }
            }
        }
        return res;
    }

    private Map<Character, Integer> generateMap (String str){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        return map;
    }

    // approach 1 - Sliding Window TC: O(n) SC: O(m)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        // generate frequency map
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            // move left bound
            if (i >= p.length()) {
                char c = s.charAt(i - p.length());

                if (map.containsKey(c)) {
                    int count = map.get(c);
                    map.put(c, count + 1);

                    // update
                    if (count == 0) {
                        match--;
                    }
                }
            }

            // move right bound
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count - 1);

                // update
                if (count == 1) {
                    match++;
                }
            }

            // check
            if (match == map.size()) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AllAnagrams test = new AllAnagrams();
//        System.out.println(test.allAnagrams("bb", "bbbb"));
        System.out.println(test.findAnagrams("baa", "aa"));
    }
}
