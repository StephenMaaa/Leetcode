package Array;

/*
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

        Assumptions

        The given array is not null
        Examples

        {1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
*/

import java.util.Arrays;

public class ArrayDedupII {
    public int[] dedup(int[] array) {
        int valid = 0;
        for (int i = 0; i < array.length; i++) {
            // case 1: arr[i] first/second appearance
            if (i < 2 || array[valid - 2] != array[i]) {
                array[valid++] = array[i];
            }
            // case 2: duplicate
        }
        return Arrays.copyOf(array, valid);
    }

    public static void main(String[] args) {
        ArrayDedupII test = new ArrayDedupII();
        int[] arr = new int[]{};
        System.out.println(Arrays.toString(test.dedup(arr)));
    }
}
