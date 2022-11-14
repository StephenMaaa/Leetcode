package Array;

/*
Given an integer array(not guaranteed to be sorted), remove adjacent repeated elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the final array.

        Assumptions

        The given array is not null
        Examples

        {1, 2, 2, 3, 3, 3} --> {1, 2, 2, 3, 3}

        {2, 1, 2, 2, 2, 3} --> {2, 1, 2, 2, 3}
*/

import java.util.Arrays;

public class ArrayDedupV {
    public int[] dedup(int[] array) {
        int pointer = 0;
        for (int i = 0; i < array.length; i++) {
            // base case: first 2 elements
            // case 1: no dup -> add
            // case 2: dup -> skip
            if (i < 2 || array[pointer - 2] != array[i] || array[pointer - 1] != array[i]) {
                array[pointer++] = array[i];
            }
        }
        return Arrays.copyOf(array, pointer);
    }

    public static void main(String[] args) {
        ArrayDedupV test = new ArrayDedupV();
        int[] arr = new int[]{};
        System.out.println(Arrays.toString(test.dedup(arr))); 
    }
}
