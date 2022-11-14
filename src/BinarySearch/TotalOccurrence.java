package BinarySearch;

/*
Given a target integer T and an integer array A sorted in ascending order, Find the total number of occurrences of T in A.

        Examples

        A = {1, 2, 3, 4, 5}, T = 3, return 1
        A = {1, 2, 2, 2, 3}, T = 2, return 3
        A = {1, 2, 2, 2, 3}, T = 4, return 0
        Corner Cases

        What if A is null? We should return 0 in this case.
*/

public class TotalOccurrence {
    public int totalOccurrence(int[] array, int target) {
        // edge case
        if (array == null) {
            return 0;
        }

        // get the first occurrence of the target
        int firstIndex = -1;
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                firstIndex = mid;
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // get the last occurrence of the target
        int lastIndex = -1;
        if (firstIndex != -1) {
            left = firstIndex;
            right = array.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (array[mid] == target) {
                    lastIndex = mid;
                    left = mid + 1;
                } else if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return lastIndex == -1 ? 0 : lastIndex - firstIndex + 1;
    }

    public static void main(String[] args) {
        TotalOccurrence test = new TotalOccurrence();
        int[] arr = new int[]{};
        System.out.println(test.totalOccurrence(arr, 1));
    }
}
