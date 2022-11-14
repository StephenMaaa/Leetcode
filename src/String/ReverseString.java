package String;

/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

        Assumptions

        The given string is not null.
*/

public class ReverseString {
    // time complexity: O(n)
    // space complexity: O(1)
    public String reverse(String input) {
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - i - 1);
        }
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // time complexity: O(n)
    // space complexity: O(1)
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left++, right--);
        }
    }

    public static void main(String[] args) {
        ReverseString test = new ReverseString();
//        System.out.println(test.reverse("  "));
        test.reverseString("helloword".toCharArray());
    }
}
