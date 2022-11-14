package HashTable;


/*
Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

        Assumptions

        In each of the two sorted arrays, there could be duplicate numbers.
        Both two arrays are not null.
        Examples

        A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
*/

import java.util.*;

public class CommonNumbers {
    // time complexity: O(n)
    // space complexity: O(1)
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> ans = new ArrayList<>();

        // sort
        Arrays.sort(A);
        Arrays.sort(B);

        int pointerA = 0, pointerB = 0;
        while (pointerA < A.length && pointerB < B.length) {
            if (A[pointerA] == B[pointerB]) {
                ans.add(A[pointerA]);
                pointerA++;
                pointerB++;
            } else if (A[pointerA] < B[pointerB]) {
                pointerA++;
            } else {
                pointerB++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CommonNumbers test = new CommonNumbers();
        int[] arr1 = new int[]{128};
        int[] arr2 = new int[]{128};
        System.out.println(Arrays.toString(test.common(arr1, arr2).toArray()));
    }
}
