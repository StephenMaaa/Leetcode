package String;

/*
Repeatedly remove all adjacent, repeated characters in a given string from left to right.

        No adjacent characters should be identified in the final string.

        Examples

        "abbbaaccz" → "aaaccz" → "ccz" → "z"
        "aabccdc" → "bccdc" → "bdc"

        Note: simple sol: use stack
*/

public class RemoveAdjacentRepeatedCharsIV {
    public String deDup(String input) {
        if (input == null) return null;
        char[] arr = input.toCharArray();
        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (i == 0 || count == 0 || arr[i] != arr[count - 1]) {
//                arr[count++] = arr[i];
//            } else {
//                while (i < arr.length && arr[i] == arr[count - 1]) {
//                    i++;
//                }
//                i--;
//                count--;
//            }
//        }
        int i = 0;
        while (i < arr.length) {
            if (i == 0 || count == 0 || arr[i] != arr[count - 1]) {
                arr[count++] = arr[i++];
            } else {
                while (i < arr.length && arr[i] == arr[count - 1]) {
                    i++;
                }
                count--;
            }
        }
        return new String(arr, 0, count);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharsIV test = new RemoveAdjacentRepeatedCharsIV();
        System.out.println(test.deDup("abbbaaccz"));
    }
}
