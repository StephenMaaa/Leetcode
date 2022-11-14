package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VowelsInQueries {
    // approach 1 - PrefixSum TC: O(m + n) SC: O(m + n)
    public int[] vowelsInQueries(String[] arr, int[][] query) {
        int[] prefixSum = new int[arr.length];
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        // initialization
        if (arr.length > 0 && check(arr[0], vowels)) {
            prefixSum[0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
            if (check(arr[i], vowels)) {
                prefixSum[i]++;
            }
        }

        // process
        int[] res = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            res[i] = prefixSum[query[i][1] - 1] - prefixSum[query[i][0]] + 1;
        }
        return res;
    }

    private boolean check(String s, Set<Character> vowels) {
        return vowels.contains(s.charAt(0)) && vowels.contains(s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        VowelsInQueries test = new VowelsInQueries();
        String[] arr = new String[]{"aba", "bcb", "ece", "aa", "e"};
        int[][] query = new int[][]{{1, 3}, {2, 5}, {2, 2}};
        System.out.println(Arrays.toString(test.vowelsInQueries(arr, query)));
    }
}
