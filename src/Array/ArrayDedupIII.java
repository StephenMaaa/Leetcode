package Array;

/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value do not keep any of them. Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. Return the array after deduplication.

        Assumptions

        The given array is not null
        Examples

        {1, 2, 2, 3, 3, 3} → {1}
*/

import java.util.Arrays;

public class ArrayDedupIII {
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
        ArrayDedupIII test = new ArrayDedupIII();
        int[] arr = new int[]{};
        System.out.println(Arrays.toString(test.dedup(arr)));
    }
}
