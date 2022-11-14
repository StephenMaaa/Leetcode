package String;

/*
Remove adjacent, repeated characters in a given string, leaving only two characters for each group of such characters. The characters in the string are sorted in ascending order.

        Assumptions

        Try to do it in place.
        Examples

        “aaaabbbc” is transferred to “aabbc”
        Corner Cases

        If the given string is null, we do not need to do anything.
*/

public class RemoveAdjacentRepeatedCharsII {
    public String deDup(String input) {
        if (input == null) return input;
        char[] arr = input.toCharArray();
        boolean flag = true;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[count - 1]) {
                arr[count++] = arr[i];
                flag = true;
            } else if (flag) {
                arr[count++] = arr[i];
                flag = false;
            }
        }
        return new String(arr, 0, count);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharsII test = new RemoveAdjacentRepeatedCharsII();
        System.out.println(test.deDup("aaaabbbc"));
    }
}
