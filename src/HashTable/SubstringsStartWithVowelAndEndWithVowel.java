package HashTable;

import java.util.Arrays;

public class SubstringsStartWithVowelAndEndWithVowel {
    // approach 1 - prefixSum TC: O(n) SC: O(n)
    public int[] count(String str, int[][] interval) {
        int[] count = new int[str.length() + 1];
        int[] sum = new int[str.length() + 1];
        int curr = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                sum[curr + 1] = sum[curr++] + count[i];
                count[i + 1] = count[i] + 1;
            } else {
                sum[i + 1] = sum[i];
                count[i + 1] = count[i];
            }
        }

        int[] res = new int[interval.length];
        for (int i = 0; i < interval.length; i++) {
            int vowels = count[interval[i][1] + 1] - count[interval[i][0]];
            res[i] = sum[vowels];
        }
        return res;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        SubstringsStartWithVowelAndEndWithVowel test = new SubstringsStartWithVowelAndEndWithVowel();
        int[][] interval = new int[][]{{0, 1}, {2, 4}, {0, 5}};
        System.out.println(Arrays.toString(test.count("aebcdu", interval))); 
    }
}
