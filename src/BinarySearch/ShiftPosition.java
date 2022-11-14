package BinarySearch;

/*
Given an integer array A, A is sorted in ascending order first then shifted by an arbitrary number of positions, For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index of the smallest number.

        Assumptions

        There are no duplicate elements in the array
        Examples

        A = {3, 4, 5, 1, 2}, return 3
        A = {1, 2, 3, 4, 5}, return 0
        Corner Cases

        What if A is null or A is of zero length? We should return -1 in this case.
*/

public class ShiftPosition {
    public int shiftPosition(int[] array) {
        // edge case
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        // edge case: sorted
        if (array[left] < array[right]) {
            return 0;
        }

        while (left < right - 1) {
            int mid = left + (right - left) / 2;

            if (array[left] < array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        ShiftPosition test = new ShiftPosition();
        int[] arr = new int[]{};
        System.out.println(test.shiftPosition(arr));
    }
}
