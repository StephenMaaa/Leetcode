package String;

/*
Right shift a given string by n characters.

        Assumptions

        The given string is not null.
        n >= 0.
        Examples

        "abc", 4 -> "cab"
*/

public class RightShift {
    public String rightShift(String input, int n) {
        if (input.length() == 0) {
            return input;
        }
        char[] arr = input.toCharArray();
        n = n % input.length();
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, n - 1);
        reverse(arr, n, arr.length - 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        RightShift test = new RightShift();
        System.out.println(test.rightShift("", 4));
    }
}
