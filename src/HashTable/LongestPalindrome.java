package HashTable;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

        Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {
    // approach 1: Map TC: O(n) SC: O(1)
    public int longestPalindrome(String s) {
        // hashtable
        Map<Character, Integer> map = new HashMap<>();

        // count
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // populate
        int res = 0;
        int label = 0;
        for (Character key : map.keySet()) {
            int count = map.get(key);

            if (count % 2 == 0) {
                res += count;
            } else {
                res += count - 1;
                label = 1;
            }
        }
        res += label;
        return res;
    }

    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();
        System.out.println(test.longestPalindrome("abccccdd"));
    }
}
