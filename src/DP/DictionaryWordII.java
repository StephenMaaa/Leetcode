package DP;

import java.util.HashSet;

public class DictionaryWordII {
    public int canBreak(String input, String[] dict) {
        HashSet<String> keyDict = new HashSet<>();
        for (String key : dict) {
            keyDict.add(key);
        }
        int[] minCut = new int[input.length() + 1];
        minCut[0] = 0;
        for (int i = 1; i < input.length() + 1;  i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (minCut[j] != Integer.MAX_VALUE && keyDict.contains(input.substring(j, i))) {
                    min = Math.min(min, minCut[j] + 1);
                }
            }
            minCut[i] = min;
        }
        return minCut[input.length()] - 1;
    }

    public static void main(String[] args) {
        String[] dict = new String[]{"bob", "cat", "rob"};
        DictionaryWordII test = new DictionaryWordII();
        System.out.println(test.canBreak("robcatbob", dict));
    }
}

