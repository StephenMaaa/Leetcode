package DP;

/*
Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). Determine if you are able to reach the last index.

        Assumptions

        The given array is not null and has length of at least 1.
        Examples

        {1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)

        {2, 1, 1, 0, 2}, we are not able to reach the end of array
*/

import java.util.List;

public class ArrayHopper {
//    public boolean canJump(int[] array) {
//        boolean[] arr = new boolean[array.length];
//        arr[0] = true;
//        for (int i = 0; i < array.length - 1; i++) {
//            if (arr[i] == true) {
//                for (int j = 1; j <= array[i]; j++) {
//                    if (i + j < array.length) {
//                        arr[i + j] = true;
//                    }
//                }
//            }
//        }
//        return arr[array.length - 1];
//    }

    public boolean canJump(int[] array) {
        boolean[] arr = new boolean[array.length];
        arr[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] && array[j] + j >= i) {
                    arr[i] = true;
                    break;
                }
            }
        }
        return arr[array.length - 1];
    }

    public static void main(String[] args) {
        ArrayHopper test = new ArrayHopper();
        int[] arr = new int[]{1, 3, 2, 0, 3};
        System.out.println(test.canJump(arr));
    }
}
