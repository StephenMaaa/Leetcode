package BinarySearch;

/*
Given an integer array of size N - 1 sorted by ascending order, containing all the numbers from 1 to N except one, find the missing number.

        Assumptions

        The given array is not null, and N >= 1
        Examples

        A = {1, 2, 4}, the missing number is 3
        A = {1, 2, 3}, the missing number is 4
        A = {}, the missing number is 1
*/

public class MissingNumberII {
    public int missing(int[] array) {
        // edge case
        if (array == null) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == mid + 1) {
                left = mid + 1;
            } else if (array[mid] > mid + 1) {
                right = mid - 1;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        MissingNumberII test = new MissingNumberII();
        int[] arr = new int[]{};
        System.out.println(test.missing(arr));
    }
}
