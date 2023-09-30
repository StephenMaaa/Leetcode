package Math;

/*
LeetCode 13

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
*/

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    // approach 1 - Map + Linear Scan TC: O(n) SC: O(1)
    public int romanToInt2(String s) {
        // initialization
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            // case 1: single number OR dup numbers
            // case 3: small + large
            if (i == s.length() - 1 || map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                sum += map.get(s.charAt(i++));
            } else if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i++));
            }
        }
        return sum;
    }

    // approach 1: Map TC: O(n) SC: O(1)
    public int romanToInt(String s) {
        // initialization
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));

            // case 1: s[i] >= s[i + 1]
            // case 2: s[i] < s[i + 1]
            if (i == s.length() - 1 || val >= map.get(s.charAt(i + 1))) {
                count += val;
            } else {
                count -= val;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RomanToInteger test = new RomanToInteger();
        System.out.println(test.romanToInt("MCMXCIV"));
    }
}
