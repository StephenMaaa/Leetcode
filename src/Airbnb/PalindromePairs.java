package Airbnb;

/*
You are given a 0-indexed array of unique strings words.

        A palindrome pair is a pair of integers (i, j) such that:

        0 <= i, j < word.length,
        i != j, and
        words[i] + words[j] (the concatenation of the two strings) is a
        palindrome
        .
        Return an array of all the palindrome pairs of words.
*/

import java.util.*;

public class PalindromePairs {
//    public class TrieNode {
//        int index;
//        Map<Character, TrieNode> edges;
//        List<Integer> palindromeIndexList;
//
//        public TrieNode() {
//            this.index = -1;
//            this.edges = new HashMap<>();
//            this.palindromeIndexList = new ArrayList<>();
//        }
//    }
//
//    // approach 1 - Trie TC: O(nk^2) SC: O(n^2k)
//    public List<List<Integer>> palindromePairs(String[] words) {
//        // build trie
//        TrieNode root = new TrieNode();
//        for (int index = 0; index < words.length; index++) {
//            String word = words[index];
//            TrieNode curr = root;
//
//            // insert into trie in reverse order
//            for (int i = word.length() - 1; i >= 0; i--) {
//                char c = word.charAt(i);
//
//                // check edge
//                if (!curr.edges.containsKey(c)) {
//                    curr.edges.put(c, new TrieNode());
//                }
//
//                // check prefix palindrome
//                if (isPalindrome(word, 0, i)) {
//                    curr.palindromeIndexList.add(index);
//                }
//
//                curr = curr.edges.get(c);
//            }
//            curr.index = index;
//            curr.palindromeIndexList.add(index);
//        }
//
//        // search
//        // case 1: wordA + wordB
//        // case 2: wordA + palindromeA + wordB
//        // case 3: wordA + palindromeB + wordB
//        List<List<Integer>> res = new ArrayList<>();
//        for (int index = 0; index < words.length; index++) {
//            String word = words[index];
//            search(word, root, index, res);
//        }
//        return res;
//    }
//
//    private void search(String word, TrieNode root, int index, List<List<Integer>> res) {
//        TrieNode curr = root;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//
//            // check case 1 and case 2
//            if (curr.index != -1 && curr.index != index && isPalindrome(word, i, word.length() - 1)) {
//                res.add(Arrays.asList(index, curr.index));
//            }
//
//            // check edge
//            if (!curr.edges.containsKey(c)) {
//                return;
//            }
//            curr = curr.edges.get(c);
//        }
//
//        // check case 3
//        for (int i : curr.palindromeIndexList) {
//            if (index == i) {
//                continue;
//            }
//            res.add(Arrays.asList(index, i));
//        }
//    }
//
//    private boolean isPalindrome(String s, int i, int j) {
//        while (i < j) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }

    public class TrieNode {
        int index;
        Map<Character, TrieNode> edges;
        List<Integer> palindromeList;

        public TrieNode() {
            this.index = -1;
            edges = new HashMap<>();
            palindromeList = new ArrayList<>();
        }
    }

    // approach 1 - Trie TC: O(nk^2) SC: O(n^2k)
    public List<List<Integer>> palindromePairs(String[] words) {
        // build trie
        TrieNode root = new TrieNode();
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            TrieNode curr = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);

                // check
                if (!curr.edges.containsKey(c)) {
                    curr.edges.put(c, new TrieNode());
                }

                // check palindrome prefix
                if (isPalindrome(word, 0, i)) {
                    curr.palindromeList.add(index);
                }
                curr = curr.edges.get(c);
            }
            curr.index = index;
            curr.palindromeList.add(index);
        }

        // search
        List<List<Integer>> res = new ArrayList<>();
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            search(word, index, root, res);
        }
        return res;
    }

    private void search(String word, int index, TrieNode root, List<List<Integer>> res) {
        // case 1: wordA + wordB
        // case 2: wordA + palindromeA + wordB
        // case 3: wordA + palindromeB + wordB
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // case 1 and case 2
            if (root.index != -1 && root.index != index && isPalindrome(word, i, word.length() - 1)) {
                res.add(Arrays.asList(index, root.index));
            }

            // check
            if (!root.edges.containsKey(c)) {
                return;
            }
            root = root.edges.get(c);
        }

        // case 3
        for (int i : root.palindromeList) {
            if (index == i) {
                continue;
            }
            res.add(Arrays.asList(index, i));
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs test = new PalindromePairs();
        String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(test.palindromePairs(words));
    }
}
