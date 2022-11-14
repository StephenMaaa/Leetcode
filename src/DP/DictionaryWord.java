package DP;

/*
Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

        Assumptions

        The given word is not null and is not empty
        The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
        Examples

        Dictionary: {“bob”, “cat”, “rob”}

        Word: “robob” return false

        Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
*/

import java.util.HashSet;

public class DictionaryWord {
    public boolean canBreak(String input, String[] dict) {
        HashSet<String> keyDict = new HashSet<>();
        for (String key : dict) {
            keyDict.add(key);
        }
        boolean[] check = new boolean[input.length() + 1];
        check[0] = true;
        for (int i = 1; i < input.length() + 1;  i++) {
            for (int j = 0; j < i; j++) {
                if (check[j] && keyDict.contains(input.substring(j, i))) {
                    check[i] = true;
                    break;
                }
            }
        }
        return check[input.length()];
    }

    public static void main(String[] args) {
        String[] dict = new String[]{"bob", "cat", "rob"};
        DictionaryWord test = new DictionaryWord();
        System.out.println(test.canBreak(" ", dict));
    }
}
