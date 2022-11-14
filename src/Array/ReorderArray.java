package Array;

/*
Given an array of elements, reorder it as follow:

        { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }

        { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

        Try to do it in place.

        Assumptions

        The given array is not null
        Examples

        { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }

        { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }

        { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
*/

import java.util.Arrays;

public class ReorderArray {
    public int[] reorder(int[] array) {
        if (array.length % 2 == 0) {
            reorderArray(array, 0, array.length - 1);
        } else {
            reorderArray(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorderArray(int[] array, int left, int right) {
        // base case
        if (right - left <= 1) {
            return;
        }

        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;

        reverse(array, leftMid, mid - 1);
        reverse(array, mid, rightMid - 1);
        reverse(array, leftMid, rightMid - 1);

        reorderArray(array, left, left + 2 * (leftMid - left) - 1);
        reorderArray(array, left + 2 * (leftMid - left), right);
    }

    private void reverse(int[] array, int left, int right) {
        int size = right - left + 1;
        for (int i = 0; i < size / 2; i++) {
            swap(array, left + i, right - i);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        ReorderArray test = new ReorderArray();
        int[] arr = new int[]{};
        System.out.println(Arrays.toString(test.reorder(arr)));
    }
}
