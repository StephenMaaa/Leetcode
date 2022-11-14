package BinarySearch;

/*
Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.

        For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.

        Assumptions

        There are no duplicate elements in the array.
        Examples

        A = {3, 4, 5, 1, 2}, T = 4, return 1
        A = {1, 2, 3, 4, 5}, T = 4, return 3
        A = {3, 5, 6, 1, 2}, T = 4, return -1
        Corner Cases

        What if A is null or A is of zero length? We should return -1 in this case.
*/

public class SearchInShiftedSortedArray {
//    public int search(int[] array, int target) {
//        // edge case
//        if (array == null) {
//            return -1;
//        }
//
//        int shift = 0;
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i] > array[i + 1]) {
//                shift = i + 1;
//                break;
//            }
//        }
//
//        int left = 0;
//        int right = array.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            int shiftedMid = (mid + shift) % array.length;
//            if (array[shiftedMid] == target) {
//                return shiftedMid;
//            } else if (array[shiftedMid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return -1;
//    }

    public int search(int[] array, int target) {
        // edge case
        if (array == null) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // case 1: the first half is sorted
            // case 2: the second half is sorted
            if (array[mid] == target) {
                return mid;
            } else if (array[left] <= array[mid]) {
                if (array[left] <= target && array[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (array[right] >= target && array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInShiftedSortedArray test = new SearchInShiftedSortedArray();
        int[] arr = new int[]{3, 1};
        System.out.println(test.search(arr, 1));
    }
}
