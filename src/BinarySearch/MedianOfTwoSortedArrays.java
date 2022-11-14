package BinarySearch;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

        The overall run time complexity should be O(log (m+n)).
*/

public class MedianOfTwoSortedArrays {
    // time complexity: O(log(m + n))
    // space complexity: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int mid = sum / 2;

        // case 1: mid == even
        // case 2: mid == odd
        if (sum % 2 == 0) {
            int m1Index = findMedian(nums1, nums2, mid - 1);
            int m1 = 0;
            int m2 = 0;

            // check valid
            if (m1Index == -1) {
                m1Index = findMedian(nums2, nums1, mid - 1);
                m1 = nums2[m1Index];

                if (check(nums2, m1Index + 1) < check(nums1, mid - 1 - m1Index)) {
                    m2 = nums2[m1Index + 1];
                } else {
                    m2 = nums1[mid - 1 - m1Index];
                }
            } else {
                m1 = nums1[m1Index];
                if (check(nums1, m1Index + 1) < check(nums2, mid - 1 - m1Index)) {
                    m2 = nums1[m1Index + 1];
                } else {
                    m2 = nums2[mid - 1 - m1Index];
                }
            }
            return (m1 + m2) / 2.0;
        } else {
            int mIndex = findMedian(nums1, nums2, mid);
            int m = 0;
            // check valid
            if (mIndex == -1) {
                mIndex = findMedian(nums2, nums1, mid);
                m = nums2[mIndex];
            } else {
                m = nums1[mIndex];
            }
            return m;
        }
    }

    private int findMedian(int[] num1, int[] num2, int k) {
        int left = 0;
        int right = num1.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // case 1: arrB[k - mid - 1] <= arrA[mid] <= arrB[k - mid]
            // case 2: arrB[k - mid - 1] > arrA[mid]
            // case 3: arrB[k - mid] < arrA[mid]
            if (check(num2, k - mid - 1) > num1[mid]) {
                left = mid + 1;
            } else if (check(num2, k - mid) < num1[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int check(int[] arr, int index) {
        if (index < 0) {
            return Integer.MIN_VALUE;
        } else if (index >= arr.length) {
            return Integer.MAX_VALUE;
        } else {
            return arr[index];
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        int[] arrA = new int[]{1, 2};
        int[] arrB = new int[]{3, 4};
        System.out.println(test.findMedianSortedArrays(arrA, arrB)); 
    }
}
