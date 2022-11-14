package String;

/*
Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.

        Assumptions

        Try to do it in place.
        Examples

        “aaaabbbc” is transferred to “abc”
        Corner Cases

        If the given string is null, returning null or an empty string are both valid.
*/

public class RemoveAdjacentRepeatedChars {
    public String deDup(String input) {
        // Write your solution here
        if (input == null) return null;
        char[] arr = input.toCharArray();
        char prev = ' ';
        int pointer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != prev) {
                arr[pointer++] = arr[i];
                prev = arr[i];
            }
        }
        return new String(arr, 0, pointer);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedChars test = new RemoveAdjacentRepeatedChars();
        System.out.println(test.deDup(null));
    }
}
