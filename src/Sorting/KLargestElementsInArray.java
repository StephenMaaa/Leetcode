package Sorting;

import java.util.Random;

public class KLargestElementsInArray {
    public int kLargest(int[] arr, int k) {
        quickSort(arr, arr.length - k);

        int sum = 0;
        for (int i = arr.length - k; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private void quickSort(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int pivot = partition(arr, left, right);

            if (pivot == k) {
                return;
            } else if (pivot < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
    }

    Random rand = new Random();
    private int partition(int[] arr, int left, int right) {
        int pivot = left + rand.nextInt(right - left + 1);
        swap(arr, pivot, right);
        pivot = arr[right];
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, left++);
            }
        }
        swap(arr, left, right);
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        KLargestElementsInArray test = new KLargestElementsInArray();
        int[] arr = new int[]{1, 4, 3, 2};
        System.out.println(test.kLargest(arr, 2));
    }
}
