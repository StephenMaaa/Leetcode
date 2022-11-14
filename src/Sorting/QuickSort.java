package Sorting;

/*
Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.

        Examples

        {1} is sorted to {1}
        {1, 2, 3} is sorted to {1, 2, 3}
        {3, 2, 1} is sorted to {1, 2, 3}
        {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
        Corner Cases

        What if the given array is null? In this case, we do not need to do anything.
        What if the given array is of length zero? In this case, we do not need to do anything.
*/

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    Random random = new Random();

    public int[] quickSort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private void sort(int[] array, int left, int right) {
//        if (left < right) {
//            int pivot = partition(array, left, right);
//            sort(array, left, pivot - 1);
//            sort(array, pivot + 1, right);
//        }
        if (left > array.length || right < 0 || left >= right) {
            return;
        }
        int pivot = partition(array, left, right);
        sort(array, left, pivot - 1);
        sort(array, pivot + 1, right);
    }

//    private int partition(int[] array, int left, int right) {
//        int i = left - 1;
//        int pivot = right;
//        for (int j = left; j < right; j++) {
//            if (array[j] < array[pivot]) {
//                i++;
//                swap(array, i, j);
//            }
//        }
//        i++;
//        swap(array, i, pivot);
//        return i;
//    }

//    private int partition(int[] array, int left, int right) {
//        int pivot = left + random.nextInt(right - left + 1);
//        int i = left - 1;
//        swap(array, right, pivot);
//        pivot = array[right];
//        for (int j = left; j < right; j++) {
//            if (array[j] < pivot) {
//                i++;
//                swap(array, i, j);
//            }
//        }
//        i++;
//        swap(array, i, right);
//        return i;
//    }

    private int partition(int[] array, int left, int right) {
        int pivot = left + random.nextInt(right - left + 1);
//        int i = left - 1;
        swap(array, right, pivot);
        pivot = array[right];
        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                swap(array, i, left++);
            }
        }
        swap(array, left, right);
        return left;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 6, 5, 6};
        QuickSort test = new QuickSort();
        System.out.println(Arrays.toString(test.quickSort(arr)));
    }
}
