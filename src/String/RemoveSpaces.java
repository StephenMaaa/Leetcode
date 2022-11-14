package String;

/*
Given a string, remove all leading/trailing/duplicated empty spaces.

        Assumptions:

        The given string is not null.
        Examples:

        “  a” --> “a”
        “   I     love MTV ” --> “I love MTV”
*/

import HashTable.RemoveCertainChars;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here
        int pointerA = 0, pointerB = input.length() - 1;
        char[] arr = input.toCharArray();
        while (pointerA < input.length() && arr[pointerA] == ' ') {
            pointerA++;
        }
        while ( pointerB > 0 && arr[pointerB] == ' ') {
            pointerB--;
        }
        boolean flag = true;
        int count = 0;
        for (int i = pointerA; i < pointerB + 1; i++) {
            if (arr[i] != ' ') {
                arr[count++] = arr[i];
                flag = true;
            } else if (arr[i] == ' ' && flag) {
                arr[count++] = arr[i];
                flag = false;
            }
        }
        return new String(arr, 0, count);
    }

    public static void main(String[] args) {
        RemoveSpaces test = new RemoveSpaces();
        System.out.println(test.removeSpaces("   "));
    }
}
