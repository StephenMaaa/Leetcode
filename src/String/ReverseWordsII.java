package String;

/*
Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.

        Examples

        “ I  love  Google  ” → “Google love I”

        Corner Cases

        If the given string is null, we do not need to do anything.
*/

public class ReverseWordsII {
    // time complexity: O(n)
    // space complexity: O(1)
    public String reverseWords(String input) {
        // edge case
        if (input == null) {
            return null;
        }

        char[] arr = input.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        // dedup heading spaces
        while (start < arr.length - 1 && arr[start] == ' ') {
            start++;
        }

        // dedup tailing spaces
        while (end > 0 && arr[end] == ' ') {
            end--;
        }

        int pointer = 0;
        while (start <= end) {
            // dedup
            while (start < end && arr[start] == ' ' && arr[start + 1] == ' ') {
                start++;
            }
            arr[pointer++] = arr[start++];
        }

        // edge case
        if (pointer == 0) {
            return "";
        }

        // reverse whole sentence
        reverse(arr, 0, pointer - 1);

        // reverse words
        start = 0;
        end = 0;
        for (int i = 0; i < pointer; i++) {
            if (arr[i] == ' ') {
                end = i - 1;
                reverse(arr, start, end);
                start = i + 1;
            }
        }
        reverse(arr, start, pointer - 1);
        return new String(arr, 0, pointer);
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
        ReverseWordsII test = new ReverseWordsII();
        System.out.println(test.reverseWords(" I  love  Google  "));
    }
}
