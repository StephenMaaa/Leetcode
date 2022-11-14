package String;

/*
Reverse the words in a sentence.

        Assumptions

        Words are separated by single space

        There are no heading or tailing white spaces

        Examples

        “I love Google” → “Google love I”

        Corner Cases

        If the given string is null, we do not need to do anything.
*/

public class ReverseWords {
//    public String reverseWords(String input) {
//        if (input == null) {
//            return input;
//        }
//
//        char[] arr = input.toCharArray();
//        reverse(arr, 0, arr.length);
//        int start = 0, end = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == ' ') {
//                end = i;
//                reverse(arr, start, end);
//                start = i + 1;
//            }
//        }
//        reverse(arr, start, arr.length);
//        return new String(arr);
//    }
    public String reverseWords(String input) {
        if (input == null) {
            return input;
        }

        char[] arr = input.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                end = i - 1;
                reverse(arr, start, end);
                start = i + 1;
            }
        }
        reverse(arr, start, arr.length - 1);
        return new String(arr);
    }

    /*private void reverse(char[] arr, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            swap(arr, start + i, end - i - 1);
        }
    }*/

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
        ReverseWords test = new ReverseWords();
        System.out.println(test.reverseWords("I love Google"));
    }
}
