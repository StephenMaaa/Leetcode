package Array;

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

        Increment the large integer by one and return the resulting array of digits.
*/

import java.util.Arrays;

public class PlusOne {
    // approach 1 - Linear Scan TC: O(n) SC: O(n)
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;

            // early stopping
            if (carry == 0) {
                return digits;
            }
            digits[i] %= 10;
        }

        // add additional carry
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        PlusOne test = new PlusOne();
        int[] arr = new int[]{9};
        System.out.println(Arrays.toString(test.plusOne(arr)));
    }
}
