package Array;

/*
Given two arrays of integers, find the median value.

        Assumptions

        The two given array are not null and at least one of them is not empty
        The two given array are not guaranteed to be sorted
        Examples

        A = {4, 1, 6}, B = {2, 3}, median is 3
        A = {1, 4}, B = {3, 2}, median is 2.5
*/

import java.util.Arrays;

public class MedianOfTwoArrays {
    // time complexity: O(nlogn)
    // space complexity: O(1)
    public double median(int[] a, int[] b) {
        // sort
        Arrays.sort(a);
        Arrays.sort(b);

        int midLen = (a.length + b.length) / 2;
        if ((a.length + b.length) % 2 == 0) {
            int midLeft = findMedian(a, b, midLen);
            midLeft = midLeft == Integer.MIN_VALUE ? findMedian(b, a, midLen) : midLeft;
            int midRight = findMedian(a, b, midLen + 1);
            midRight = midRight == Integer.MIN_VALUE ? findMedian(b, a, midLen + 1) : midRight;
            return midLeft + (midRight - midLeft) / 2.0;
        } else {
            int mid = findMedian(a, b, midLen + 1);
            return  mid == Integer.MIN_VALUE ? findMedian(b, a, midLen + 1) : mid;
        }
    }

    private int findMedian(int[] a, int[] b, int k) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // case 1: B[k - mid - 2] <= A[mid] <= B[k - mid - 1]
            // case 2: B[k - mid - 2] > A[mid]
            // case 3: B[k - mid - 1] < A[mid]
            if (checkIndex(b, k - mid - 2) > a[mid]) {
                left = mid + 1;
            } else if (checkIndex(b, k - mid - 1) < a[mid]) {
                right = mid - 1;
            } else {
                return a[mid];
            }
        }
        return Integer.MIN_VALUE;
    }

    private int checkIndex(int[] arr, int index) {
        // case 1: in range
        // case 2: out of left bound
        // case 3: out of right bound
        if (index < 0) {
            return Integer.MIN_VALUE;
        } else if (index >= arr.length) {
            return Integer.MAX_VALUE;
        } else {
            return arr[index];
        }
    }

    public static void main(String[] args) {
        MedianOfTwoArrays test = new MedianOfTwoArrays();
        int[] a = new int[]{4, 1, 6};
        int[] b = new int[]{2, 3};
        System.out.println(test.median(a, b));
    }
}
