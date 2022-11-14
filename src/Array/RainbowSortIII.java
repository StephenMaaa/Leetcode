package Array;

/*
Given an array of balls with k different colors denoted by numbers 1- k, sort the balls.

        Examples

        k=1, {1} is sorted to {1}
        k=3, {1, 3, 2, 1, 2} is sorted to {1, 1, 2, 2, 3}
        k=5, {3, 1, 5, 5, 1, 4, 2} is sorted to {1, 1, 2, 3, 4, 5, 5}
        Assumptions

        The input array is not null.
        k is guaranteed to be >= 1.
        k << logn.
*/

import java.util.Arrays;

public class RainbowSortIII {
    // count sort - TC: O(n) SC: O(k)
    // rainbow sort - TC: O(n^2) SC: O(1)
    public int[] rainbowSortIII(int[] array, int k) {
        int[] counts = new int[k + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        int count = 0;
        for (int i = 1; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[count++] = i;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        RainbowSortIII test = new RainbowSortIII();
        int[] arr = new int[]{3, 1, 5, 5, 1, 4, 2};
        System.out.println(Arrays.toString(test.rainbowSortIII(arr, 5)));
    }
}
