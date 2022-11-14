package Graph;

/*
Given a dictionary containing many words, find the largest product of two words’ lengths, such that the two words do not share any common characters.

        Assumptions

        The words only contains characters of 'a' to 'z'
        The dictionary is not null and does not contains null string, and has at least two strings
        If there is no such pair of words, just return 0
        Examples

        dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)
*/

import java.util.HashMap;
import java.util.Map;

public class LargestProductOfLength {
    public int largestProduct(String[] dict) {
        int max = 0;
        Map<String, Integer> map = generateBitsMap(dict);

        // check every pairs
        for (int i = 0; i < dict.length - 1; i++) {
            for (int j = i + 1; j < dict.length; j++) {
                if (dict[i].length() * dict[j].length() > max && (map.get(dict[i]) & map.get(dict[j])) == 0) {
                    max = dict[i].length() * dict[j].length();
                }
            }
        }
        return max;
    }

    private Map<String, Integer> generateBitsMap(String[] dict) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : dict) {
            int convertToBits = 0;
            for (int i = 0; i < str.length(); i++) {
                convertToBits |= 1 << (str.charAt(i) - 'a');
            }
            map.put(str, convertToBits);
        }
        return map;
    }

    public static void main(String[] args) {
        LargestProductOfLength test = new LargestProductOfLength();
        String[] dict = new String[]{"abcde", "abcd"};
        System.out.println(test.largestProduct(dict));
    }
}
