package HashTable;

/*
Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.

        Assumptions

        The given input string is not null.
        The characters to be removed is given by another string, it is guaranteed to be not null.
        Examples

        input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
*/

import java.util.Arrays;
import java.util.HashSet;

public class RemoveCertainChars {
    public String remove(String input, String t) {
        // Write your solution here
        HashSet<Character> keySet = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            keySet.add(t.charAt(i));
        }
        int pointer = 0;
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!keySet.contains(arr[i])) {
                arr[pointer++] = arr[i];
            }
        }
//        char[] ans = new char[pointer];
//        for (int i = 0; i < pointer; i++) {
//            ans[i] = arr[i];
//        }
        return new String(arr, 0, pointer);
    }

    public static void main(String[] args) {
        RemoveCertainChars test = new RemoveCertainChars();
        System.out.println(test.remove("abcd", "ab"));
    }
}
