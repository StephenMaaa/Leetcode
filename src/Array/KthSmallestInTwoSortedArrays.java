package Array;

/*
Given two sorted arrays of integers, find the Kth smallest number.

        Assumptions

        The two given arrays are not null and at least one of them is not empty

        K >= 1, K <= total lengths of the two sorted arrays

        Examples

        A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.

        A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
*/

public class KthSmallestInTwoSortedArrays {
    // approach 1: Two Pointers - TC: O(k) SC: O(1)
    public int kth(int[] a, int[] b, int k) {
        int pointerA = 0;
        int pointerB = 0;
        while ((pointerA < a.length || pointerB < b.length) && pointerA + pointerB < k - 1) {
            // edge case
            if (pointerA >= a.length) {
                pointerB++;
                continue;
            } else if (pointerB >= b.length) {
                pointerA++;
                continue;
            }

            if (a[pointerA] < b[pointerB]) {
                pointerA++;
            } else {
                pointerB++;
            }
        }

        // termination
        if (pointerA == a.length) {
            return b[pointerB];
        } else if (pointerB == b.length) {
            return a[pointerA];
        } else {
            return a[pointerA] < b[pointerB] ? a[pointerA] : b[pointerB];
        }
    }

    // approach 2: Binary Search - TC: O(logk) SC: O(1)
    public int kth2(int[] a, int[] b, int k) {
        int res = binarySearch(a, b, k);
        return res == -1 ? binarySearch(b, a, k) : res;
    }

    private int binarySearch(int[] a, int[] b, int k) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(b, k - mid - 2) > a[mid]) {
                left = mid + 1;
            } else if (check(b, k - mid - 1) < a[mid]) {
                right = mid - 1;
            } else {
                return a[mid];
            }
        }
        return -1;
    }

    private int check(int[] arr, int index) {
        // case 1: index < 0
        // case 2: index in range
        // case 3: index >= len
        if (index < 0) {
            return Integer.MIN_VALUE;
        } else if (index >= arr.length) {
            return Integer.MAX_VALUE;
        } else {
            return arr[index];
        }
    }

    public static void main(String[] args) {
        KthSmallestInTwoSortedArrays test = new KthSmallestInTwoSortedArrays();
        int[] a = new int[]{1, 4, 6};
        int[] b = new int[]{2, 3};
        System.out.println(test.kth2(a, b, 3));
    }
}
