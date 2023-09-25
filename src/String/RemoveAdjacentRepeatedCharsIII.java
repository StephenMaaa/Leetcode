package String;

/*
Remove adjacent, repeated characters in a given string, leaving no character for each group of such characters. The characters in the string are sorted in ascending order.

        Assumptions

        Try to do it in place.
        Examples

        “aaaabbbc” is transferred to “c”
        Corner Cases

        If the given string is null, we do not need to do anything.
*/

public class RemoveAdjacentRepeatedCharsIII {
    public String deDup(String input) {
        if (input == null) return null;
        char[] arr = input.toCharArray();
        int pointer = 0;
        int count = 0;
        while (pointer < arr.length) {
            if (pointer == arr.length - 1) {
                arr[count++] = arr[pointer++];
            } else if (arr[pointer] == arr[pointer + 1]) {
                while (pointer < arr.length - 1 && arr[pointer] == arr[pointer + 1]) {
                    pointer++;
                }
                pointer++;
            } else {
                arr[count++] = arr[pointer++];
            }
        }
        return new String(arr, 0, count);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharsIII test = new RemoveAdjacentRepeatedCharsIII();
        System.out.println(test.deDup("ecaabbc"));
    }
}
