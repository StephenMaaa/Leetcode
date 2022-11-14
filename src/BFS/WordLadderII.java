package BFS;

/*
Given a begin word, an end word and a dictionary, find the least number transformations from begin word to end word, and return the transformation sequences. Return empty list if there is no such transformations.

        In each transformation, you can only change one letter, and the word should still in the dictionary after each transformation.

        Assumptions

        1. All words have the same length.

        2. All words contain only lowercase alphabetic characters.

        3. There is no duplicates in the word list.

        4.The beginWord and endWord are non-empty and are not the same.

        Example: start = "git", end = "hot", dictionary = {"git","hit","hog","hot","got"}

        Output: [["git","hit","hot"], ["git","got","hot"]]
*/

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String str : wordList) {
            dict.add(str);
        }
        List<List<String>> res = new ArrayList<>();
        Deque<List<String>> queue = new ArrayDeque<>();
        List<String> beginList = new ArrayList<>();
        beginList.add(beginWord);
        queue.offer(beginList);
        boolean flag = false;
        int level = wordList.size();
        while (!queue.isEmpty() && !flag && level > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<String> list = queue.poll();
                String word = list.get(list.size() - 1);

                // check
                if (word.equals(endWord)) {
                    flag = true;
                    res.add(new ArrayList<>(list));
                } else {
                    StringBuilder sb = new StringBuilder(word);
                    for (int j = 0; j < sb.length(); j++) {
                        char originalChar = sb.charAt(j);
                        for (char c = 'a'; c <= 'z'; c++) {
                            sb.setCharAt(j, c);
                            String newWord = sb.toString();
                            if (dict.contains(newWord)) {
                                List<String> newList = new ArrayList<>(list);
                                newList.add(newWord);
                                queue.offer(newList);
//                                if (!newWord.equals(endWord)) {
//                                    dict.remove(newWord);
//                                }
                            }
                        }
                        sb.setCharAt(j, originalChar);
                    }
                }
            }
            level--;
        }
        return res;
    }

    // approach 1 - BFS + DFS TC: O(kn) SC: O(kn)
    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        // initialization
        Set<String> set = new HashSet<>(wordList);
        Map<String, Integer> levelMap = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        set.remove(beginWord);
        levelMap.put(beginWord, 0);
        map.put(beginWord, new ArrayList<>());
        int level = 1;
        boolean flag = false;

        // BFS
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String newWord = String.valueOf(arr);
                        // check
                        // case 1: newWord visited in same level
                        // case 2: newWord non-visited
                        if (map.containsKey(newWord) && levelMap.get(newWord) == level) {
                            map.get(newWord).add(word);
                        } else if (set.contains(newWord)) {
                            // update level map
                            levelMap.put(newWord, level);

                            // update trajectory
                            if (!map.containsKey(newWord)) {
                                map.put(newWord, new ArrayList<>());
                            }
                            map.get(newWord).add(word);
                            queue.offer(newWord);

                            set.remove(newWord);

                            // check
                            if (newWord.equals(endWord)) {
                                flag = true;
                            }
                        }
                    }
                    arr[j] = original;
                }
            }
            level++;
        }

        // DFS
        List<List<String>> res = new ArrayList<>();
        if (flag) {
            Deque<String> list = new ArrayDeque<>();
            list.offerLast(endWord);
            dfs(beginWord, endWord, list, map, res);
        }
        return res;
    }

    private void dfs(String beginWord, String word, Deque<String> list, Map<String, List<String>> map, List<List<String>> res) {
        // base case
        if (word.equals(beginWord)) {
            res.add(new ArrayList<>(list));
            return;
        }

        // recursive case
        List<String> prev = map.get(word);
        for (int i = 0; i < prev.size(); i++) {
            list.offerFirst(prev.get(i));
            dfs(beginWord, prev.get(i), list, map, res);
            list.pollFirst();
        }
    }

    public static void main(String[] args) {
        WordLadderII test = new WordLadderII();
        String beginWord = "a";
        String endWord = "c";
        List<String> list = Arrays.asList("a", "b", "c");
//        String beginWord = "cclull";
//        String endWord = "kfxhjj";
//        List<String> list = Arrays.asList("izvcnt","hyjwgb","luzvff","illbjg","iehfzp","jjofku","tmkrma","yrrvpq","ntijqd","lbruez","jtoimy","fgktfq","tmtibx","vujkns","fjdeds","cicrlt","lkupnp","kbquoc","vaqnwd","sybbkk","voifyl","zycdrm","yxfkyg","tusvnf","bfffsq","oxqtaq","slynkf","eiamsy","cxmvkt","xsmdmi","jckoeq","zxpjjf","ndjdtk","xvqomc","hmqrlq","nwmoyw","swomhn","tqrljp","ruwdbe","hgliyu","cclull","fpeltr","kivdkq","puuqfh","kdjnrw","ceuvpm","axnoct","kfxhjj","mhvqjv","kmhlgy","avgxno","jiqrjj","rkiyyt","pjvjuf","twlwjy","mdjlug","nqmteo","mbqith","unfgkn","snvcok","ytjezq","jzbgdm");
        System.out.println(test.findLadders2(beginWord, endWord, list));
    }
}
