package DP;

/*
Determine if the given integer array has three indices such that i < j < k and a[i] < a[j] < a[k].

        Assumptions:

        The given array is not null.
        Examples:

        {1, 5, 2, 4}, return true since i = 0, j = 2, k = 3

        {4, 3, 2, 1}, return false
*/

public class AscendingTriple {
    // time complexity: O(n)
    // space complexity: O(1)
    public boolean existIJK(int[] array) {
        // edge case
        if (array == null || array.length < 3) {
            return false;
        }

        Integer a = array[0];
        Integer b = null;
        for (int i = 1; i < array.length; i++) {
            // case 1: arr[i] < A
            // case 2: arr[i] < B
            // case 3: arr[i] > B
            if (array[i] <= a) {
                a = array[i];
                if (array[i] != a) {
                    b = null;
                }
            } else if (b == null ||array[i] <= b) {
                b = array[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AscendingTriple test = new AscendingTriple();
        int[] arr = new int[]{1, 2, 1, 2};
        System.out.println(test.existIJK(arr));
    }
}
