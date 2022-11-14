package DP;

import java.util.HashSet;
import java.util.Set;

public class NumbersOfCut {
    public int countCut(String str, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            dict.add(dictionary[i]);
        }

        int[] countArr = new int[str.length() + 1];
        countArr[0] = 1;
        for (int i = 1; i < str.length() + 1; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (countArr[j] > 0 && dict.contains(str.substring(j, i))) {
                    count += countArr[j];
                }
            }
            countArr[i] = count;
        }
        return countArr[str.length()];
    }

    public static void main(String[] args) {
        String input = "catsand";
        String[] dict = new String[]{"cat", "cats", "sand", "and"};
        NumbersOfCut test = new NumbersOfCut();
        System.out.println(test.countCut(input, dict));
    }
}
