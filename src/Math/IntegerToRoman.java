package Math;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

        Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given an integer, convert it to a roman numeral.
*/

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    // approach 1 - Map + Arrays TC: O(1) SC: O(1)
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Character> map = new HashMap<>();
        map.put(1000, 'M');
        map.put(500, 'D');
        map.put(100, 'C');
        map.put(50, 'L');
        map.put(10, 'X');
        map.put(5, 'V');
        map.put(1, 'I');
        int[] arr = new int[]{1000, 500, 100, 50, 10, 5, 1};
        for (int i = 0; i < arr.length; i++) {
            // add current value
            while (num >= arr[i]) {
                num -= arr[i];
                sb.append(map.get(arr[i]));
            }

            // check small + large
            if (num >= arr[i] - 100 && i < 2) {
                num -= arr[i] - 100;
                sb.append(map.get(100));
                sb.append(map.get(arr[i]));
            } else if (num >= arr[i] - 10 && i >= 2 && i < 4) {
                num -= arr[i] - 10;
                sb.append(map.get(10));
                sb.append(map.get(arr[i]));
            } else if (num >= arr[i] - 1 && i >= 4 && i < 6) {
                num -= arr[i] - 1;
                sb.append(map.get(1));
                sb.append(map.get(arr[i]));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman test = new IntegerToRoman();
        System.out.println(test.intToRoman(1994));
    }
}
