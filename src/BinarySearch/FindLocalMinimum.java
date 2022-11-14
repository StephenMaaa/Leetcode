package BinarySearch;

/*
Given an unsorted integer array, return the local minimum's index.

        An element at index i is defined as local minimum when it is smaller than all its possible two neighbors a[i - 1] and a[i + 1]

        (you can think a[-1] = +infinite, and a[a.length] = +infinite)

        Assumptions:

        The given array is not null or empty.
        There are no duplicate elements in the array.
        There is always one and only one result for each case.
*/

public class FindLocalMinimum {
    // time complexity: O(logn)
    // space complexity: O(1)
    public int localMinimum(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // case 1: arr[mid] < arr[mid + 1]
            // case 2: arr[mid] > arr[mid + 1]
            if (array[mid] > array[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindLocalMinimum test = new FindLocalMinimum();
        int[] arr = new int[]{6, 4, 2};
        System.out.println(test.localMinimum(arr));
    }
}
