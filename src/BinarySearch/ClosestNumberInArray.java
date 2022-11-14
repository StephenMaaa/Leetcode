package BinarySearch;

/*
Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

        Assumptions

        There can be duplicate elements in the array, and we can return any of the indices with same value.
        Examples

        A = {1, 2, 3}, T = 2, return 1
        A = {1, 4, 6}, T = 3, return 1
        A = {1, 4, 6}, T = 5, return 1 or 2
        A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
        Corner Cases

        What if A is null or A is of zero length? We should return -1 in this case.
*/

public class ClosestNumberInArray {
    public int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0, right = array.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // case 1: arr[mid] == target -> return
            // case 2: arr[mid] < target -> save min diff and index, left = mid + 1
            // case 3: arr[mid] > target -> save min diff and index, right = mid - 1
            if (array[mid] == target) {
                return mid;
            } else {
                if (Math.abs(target - array[mid]) < minDiff) {
                    minDiff = Math.abs(target - array[mid]);
                    index = mid;
                }
                if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        ClosestNumberInArray test = new ClosestNumberInArray();
        int[] arr = new int[]{};
        System.out.println(test.closest(null, 2));
    }
}
