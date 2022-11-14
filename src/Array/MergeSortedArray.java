package Array;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

        Merge nums1 and nums2 into a single array sorted in non-decreasing order.

        The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
*/

public class MergeSortedArray {
    // approach 1 - Two Pointers TC: O(m + n) SC: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointerA = m - 1;
        int pointerB = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {
            // case 1: pA < 0
            // case 2: pB < 0
            // case 3: arrA[pA] >= arrB[pB]
            // case 4: arrA[pA] < arrB[pB]
            if (pointerA < 0) {
                nums1[i] = nums2[pointerB--];
            } else if (pointerB < 0) {
                nums1[i] = nums1[pointerA--];
            } else if (nums1[pointerA] >= nums2[pointerB]) {
                nums1[i] = nums1[pointerA--];
            } else {
                nums1[i] = nums2[pointerB--];
            }
        }
    }

    // approach 1 - Two Pointers TC: O(m + n) SC: O(1)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int pointerA = m - 1;
        int pointerB = n - 1;
        int i = m + n - 1;

        while (pointerB >= 0) {
            if (pointerA >= 0 && nums1[pointerA] > nums2[pointerB]) {
                nums1[i--] = nums1[pointerA--];
            } else {
                nums1[i--] = nums2[pointerB--];
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray test = new MergeSortedArray();
        int[] arrA = new int[]{0};
        int[] arrB = new int[]{1};
        test.merge(arrA, 0, arrB, 1);
    }
}
