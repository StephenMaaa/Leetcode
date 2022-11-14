package Array;

/*
Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. For each group of elements with the same value do not keep any of them.

        Do this in-place, using the left side of the original array. Return the array after deduplication.

        Assumptions

        The given array is not null
        Examples

        {1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
*/

import java.util.Arrays;

public class ArrayDedupIV {
    public int[] dedup(int[] array) {
        int valid = 0, i = 0;
        while (i < array.length) {
            // case 1: arr[i] first appearance
            // case 2: duplicate
            if (valid == 0 || array[valid - 1] != array[i]) {
                array[valid++] = array[i++];
            } else {
                while (i < array.length && array[valid - 1] == array[i]) {
                    i++;
                }
                valid--;
            }
        }
        return Arrays.copyOf(array, valid);
    }

    public static void main(String[] args) {
        ArrayDedupIV test = new ArrayDedupIV();
        int[] arr = new int[]{1, 2, 1};
        System.out.println(Arrays.toString(test.dedup(arr)));
    }
}
