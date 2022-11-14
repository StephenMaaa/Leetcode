package BinarySearch;

/*
Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.

        For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.

        Assumptions

        There could be duplicate elements in the array.
        Return the smallest index if target has multiple occurrence.
        Examples

        A = {3, 4, 5, 1, 2}, T = 4, return 1
        A = {3, 3, 3, 1, 3}, T = 1, return 3
        A = {3, 1, 3, 3, 3}, T = 1, return 1

        Corner Cases

        What if A is null or A is of zero length? We should return -1 in this case.
*/

public class SearchInShiftedSortedArrayII {
    public int search(int[] array, int target) {
        // edge case
        if (array == null) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // deduplicate
            if (left != right && array[left] == array[right]) {
                right--;
                continue;
            }

            // case 1: the first half is sorted
            // case 2: the second half is sorted
            if (array[mid] == target) {
                res = Math.min(res, mid);
            }
            if (array[left] <= array[mid]) {
                if (array[left] <= target && array[mid] >= target) {
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
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        SearchInShiftedSortedArrayII test = new SearchInShiftedSortedArrayII();
        int[] arr = new int[]{4,1,1,1,1,1,3,3};
        System.out.println(test.search(arr, 1));
    }
}
