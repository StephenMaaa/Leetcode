package Sorting;

/*
Only reverse the vowels('a', 'e', 'i', 'o', 'u') in a given string, the other characters should not be moved or changed.

        Assumptions:

        The given string is not null, and only contains lower case letters.
        Examples:

        "abbegi" --> "ibbega"
*/

import java.util.HashSet;
import java.util.Set;

public class ReverseOnlyVowels {
    // time complexity: O(n)
    // space complexity: O(1)
    public String reverse(String input) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        char[] arr = input.toCharArray();
        int pointerA = 0;
        int pointerB = arr.length - 1;
        while (pointerA < pointerB) {
            // case 1: both are vowels
            // case 2: otherwise
            if (!vowels.contains(arr[pointerA])) {
                pointerA++;
            }

            if (!vowels.contains(arr[pointerB])) {
                pointerB--;
            }

            if (vowels.contains(arr[pointerA]) && vowels.contains(arr[pointerB])) {
                swap(arr, pointerA++, pointerB--);
            }
        }
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        ReverseOnlyVowels test = new ReverseOnlyVowels();
        System.out.println(test.reverse("abbegi"));
    }
}
