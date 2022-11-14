package Array;

/*
Given an array of integers, move all the 0s to the right end of the array.

        The relative order of the elements in the original array need to be maintained.

        Assumptions:

        The given array is not null.
        Examples:

        {1} --> {1}
        {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
*/

import java.util.Arrays;

public class Move0sToTheEndII {
    // main idea: partition in quick sort
//    public int[] moveZero(int[] array) {
//        if (array == null || array.length == 0) {
//            return array;
//        }
//        int pivot = array.length - 1;
//        int count = -1;
//        for (int i = 0; i < array.length - 1; i++) {
//            // case 1: arr[i] != 0
//            if (array[i] != 0) {
//                swap(array, ++count, i);
//            }
//            // case 2: arr[i] == 0
//        }
//        swap(array, ++count, pivot);
//        return array;
//    }

    public int[] moveZero(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int pivot = array.length - 1;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            // case 1: arr[i] != 0
            if (array[i] != 0) {
                swap(array, count++, i);
            }
            // case 2: arr[i] == 0
        }
        swap(array, count++, pivot);
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Move0sToTheEndII test = new Move0sToTheEndII();
        int[] arr = new int[]{1, 0, 3, 0, 1};
        System.out.println(Arrays.toString(test.moveZero(arr)));
    }
}
