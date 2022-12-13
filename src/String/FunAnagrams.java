package String;

import java.util.*;

public class FunAnagrams {
    // approach 1 - Sorting + Map TC: O(m * klogk + n * s * plogp) SC: O(mk)
    public List<Long> funAnagrams(List<String> words, List<String> phrases) {
        List<Long> res = new ArrayList<>();

        // generate frequency map
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            String sortedString = sort(s);
            map.put(sortedString, map.getOrDefault(sortedString, 0) + 1);
        }

        for (String phrase : phrases) {
            String[] strArr = phrase.split(" ");

            long count = 1;
            for (String s : strArr) {
                String sortedString = sort(s);

                // check
                if (map.containsKey(sortedString)) {
                    count *= map.get(sortedString);
                }
            }
            res.add(count);
        }
        return res;
    }

    private String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        FunAnagrams test = new FunAnagrams();
        List<String> words = Arrays.asList("ab", "ba", "cd", "abc");
        List<String> phrases = Arrays.asList("ab ba", "ab cd", "abc ab ba ba");
        System.out.println(test.funAnagrams(words, phrases));
    }
}
