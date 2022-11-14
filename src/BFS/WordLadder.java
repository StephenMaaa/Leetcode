package BFS;

/*
Given a begin word, an end word and a dictionary, find the least number transformations from begin word to end word, and return the length of the transformation sequence. Return 0 if there is no such transformations.

        In each transformation, you can only change one letter, and the word should still in the dictionary after each transformation.

        Assumptions

        1. All words have the same length.

        2. All words contain only lowercase alphabetic characters.

        3. There is no duplicates in the word list.

        4.The beginWord and endWord are non-empty and are not the same.

        Example: start = "git", end = "hot", dictionary = {"git","hit","hog","hot"}

        Output: 3

        Explanation: git -> hit -> hot
*/

import java.util.*;

public class WordLadder {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> dict = new HashSet<>();
//        for (String word : wordList) {
//            dict.add(word);
//        }
////        Set<String> visited = new HashSet<>();
//        Queue<String> queue = new ArrayDeque<>();
//        queue.offer(beginWord);
////        visited.add(beginWord);
//
//        int level = 1;
//        // BFS
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            // iterate the current level
//            for (int i = 0; i < size; i++) {
//                String word = queue.poll();
//
//                // check terminating condition
//                if (word.equals(endWord)) {
//                    return level;
//                }
//
//                StringBuilder sb = new StringBuilder(word);
//                // change only one char
//                for (int j = 0; j < sb.length(); j++) {
//                    char origin = sb.charAt(j);
//                    for (char k = 'a'; k < 'z'; k++) {
//                        sb.setCharAt(j, k);
//                        String newWord = sb.toString();
//                        if (dict.contains(newWord)) {
//                            queue.offer(newWord);
////                            visited.add(newWord); // or delete
//                            dict.remove(newWord);
//                        }
//                    }
//                    sb.setCharAt(j, origin);
//                }
//            }
//            level++;
//        }
//        return 0;
//    }

    // approach 1 - BFS TC: O(kn) SC: O(kn)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // check
                if (word.equals(endWord)) {
                    return level;
                }

                // expand
                StringBuilder sb = new StringBuilder(word);
                for (int j = 0; j < word.length(); j++) {
                    char original = word.charAt(j);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String newWord = sb.toString();
                        if (set.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    sb.setCharAt(j, original);
                }
            }
            level++;
        }
        return 0;
    }

    // approach 1 - BFS TC: O(kn) SC: O(kn)
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        // BFS
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // check
                if (word.equals(endWord)) {
                    return level;
                }

                // expand
                StringBuilder sb = new StringBuilder(word);
                for (int j = 0; j < word.length(); j++) {
                    char original = word.charAt(j);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String newWord = sb.toString();
                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    sb.setCharAt(j, original);
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        String beginWord = "git";
        String endWord = "hot";
        List<String> list = Arrays.asList("git","hit","hog","hot");
//        String beginWord = "cclull";
//        String endWord = "kfxhjj";
//        List<String> list = Arrays.asList("izvcnt","hyjwgb","luzvff","illbjg","iehfzp","jjofku","tmkrma","yrrvpq","ntijqd","lbruez","jtoimy","fgktfq","tmtibx","vujkns","fjdeds","cicrlt","lkupnp","kbquoc","vaqnwd","sybbkk","voifyl","zycdrm","yxfkyg","tusvnf","bfffsq","oxqtaq","slynkf","eiamsy","cxmvkt","xsmdmi","jckoeq","zxpjjf","ndjdtk","xvqomc","hmqrlq","nwmoyw","swomhn","tqrljp","ruwdbe","hgliyu","cclull","fpeltr","kivdkq","puuqfh","kdjnrw","ceuvpm","axnoct","kfxhjj","mhvqjv","kmhlgy","avgxno","jiqrjj","rkiyyt","pjvjuf","twlwjy","mdjlug","nqmteo","mbqith","unfgkn","snvcok","ytjezq","jzbgdm");
        System.out.println(test.ladderLength(beginWord, endWord, list));
    }
}
