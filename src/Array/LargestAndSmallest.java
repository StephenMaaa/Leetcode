package Array;

/*
Use the least number of comparisons to get the largest and smallest number in the given integer array. Return the largest number and the smallest number.

        Assumptions

        The given array is not null and has length of at least 1
        Examples

        {2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
*/

import java.util.Arrays;

public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        // split into max arr and min arr
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] < array[array.length - i - 1]) {
                swap(array, i, array.length - i - 1);
            }
        }

        // find max in max arr and min in min arr
        int max = array[0];
        int min = array[array.length / 2];
        for (int i = 1; i <= (array.length - 1) / 2; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[array.length / 2 + i]);
        }
        return new int[]{max, min};
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        LargestAndSmallest test = new LargestAndSmallest();
        int[] arr = new int[]{2, 2, 2};
        System.out.println(Arrays.toString(test.largestAndSmallest(arr)));
    }
}
