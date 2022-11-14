package HashTable;

/*
Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.

        Assumptions

        The given array is not null, and N >= 1
        Examples

        A = {2, 1, 4}, the missing number is 3
        A = {1, 2, 3}, the missing number is 4
        A = {}, the missing number is 1
*/

import java.util.HashSet;

public class MissingNumber {
    // approach 1 - Set TC: O(n) SC: O(n)
    public int missing(int[] array) {
        HashSet<Integer> hashset = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            hashset.add(array[i]);
        }
        for (int i = 1; i <= array.length + 1; i++) {
            if (!hashset.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    // approach 2 - Bit Operation TC: O(n) SC: O(1)
    public int missing2(int[] array) {
        int xor = array.length + 1;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i] ^ (i + 1);
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2};
        MissingNumber test = new MissingNumber();
        System.out.println(test.missing2(arr));
    }
}
