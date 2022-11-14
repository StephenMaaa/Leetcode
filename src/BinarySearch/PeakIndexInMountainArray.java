package BinarySearch;

/*
An array arr a mountain if the following properties hold:

        arr.length >= 3
        There exists some i with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
        Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

        You must solve it in O(log(arr.length)) time complexity.
*/

public class PeakIndexInMountainArray {
    // time complexity: O(logn)
    // space complexity: O(1)
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // case 1: arr[mid] < arr[mid + 1]
            // case 2: arr[mid] > arr[mid + 1]
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray test = new PeakIndexInMountainArray();
        int[] arr = new int[]{1, 2, 3, 2, 1};
        System.out.println(test.peakIndexInMountainArray(arr));
    }
}
