package BinarySearch;

/*
Given a target integer T and an integer array A sorted in ascending order, find the index of the smallest element in A that is larger than T or return -1 if there is no such index.



        Assumptions

        There can be duplicate elements in the array.



        Examples

        A = {1, 2, 3}, T = 1, return 1

        A = {1, 2, 3}, T = 3, return -1

        A = {1, 2, 2, 2, 3}, T = 1, return 1



        Corner Cases

        What if A is null or A of zero length? We should return -1 in this case.
*/

public class SmallestElementLargerThanTarget {
    public int smallestElementLargerThanTarget(int[] array, int target) {
        // edge case
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array[0] > target) {
            return 0;
        }

        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // case 1: arr[mid] <= target
            // case 2: arr[mid] > target
            if (array[mid] <= target) {
                // check
                if (mid + 1 < array.length && array[mid + 1] > target) {
                    return mid + 1;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SmallestElementLargerThanTarget test = new SmallestElementLargerThanTarget();
        int[] arr = new int[]{1, 1, 2, 2, 2, 3};
        System.out.println(test.smallestElementLargerThanTarget(arr, 0));
    }
}
