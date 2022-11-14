package DFS;

/*
Given a telephone keypad, and an int number, print all words which are possible by pressing these numbers, the output strings should be sorted.

        {0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}

        Assumptions:

        The given number >= 0
        Examples:

        if input number is 231, possible words which can be formed are:

        [ad, ae, af, bd, be, bf, cd, ce, cf]
*/

import java.nio.charset.StandardCharsets;
import java.util.*;

public class CombinationsForTelephonePad {
    public String[] combinations(int number) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = generateMap();
        dfs(String.valueOf(number), 0, sb, map, ans);
//        String[] ans = new String[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ans[i] = list.get(i);
//        }
        return ans.toArray(new String[0]);
    }

    private void dfs(String number, int index, StringBuilder sb, Map<Integer, String> map, List<String> list) {
        // base case
        if (index == number.length()) {
            list.add(sb.toString());
            return;
        }

        int num = Character.getNumericValue(number.charAt(index));
        String str = map.get(num);

        if (str.length() == 0) {
            dfs(number, index + 1, sb, map, list);
        } else {
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                dfs(number, index + 1, sb, map, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private Map generateMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        return map;
    }

    public static void main(String[] args) {
        CombinationsForTelephonePad test = new CombinationsForTelephonePad();
        System.out.println(Arrays.toString(test.combinations(231)));
    }
}
