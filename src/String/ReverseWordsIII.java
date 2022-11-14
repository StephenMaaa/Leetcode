package String;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*/

public class ReverseWordsIII {
    // approach 1 - Arrays TC: O(n) SC: O(n)
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < arr.length) {
            // find word
            int start = i;
            while (i < arr.length && arr[i] != ' ') {
                i++;
            }

            // reverse word
            reverse(arr, start, i - 1);
            i++;
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsIII test = new ReverseWordsIII();
        System.out.println(test.reverseWords("God Ding"));
    }
}
