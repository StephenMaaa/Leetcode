package HashTable;

/*
Find all numbers that appear in both of two unsorted arrays.

        Assumptions

        Both of the two arrays are not null.
        In any of the two arrays, there could be duplicate numbers.
        Examples

        A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonNumbersII {
    // approach 1: two pointer - TC: O(nlogn) SC: O(1)
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(A);
        Arrays.sort(B);

        int pointerA = 0;
        int pointerB = 0;
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

    // approach 2: map - TC: O(n) SC: O(n)
    public List<Integer> common2(int[] A, int[] B) {
        int[] arrS;
        int[] arrL;
        if (A.length < B.length) {
            arrS = A;
            arrL = B;
        } else {
            arrS = B;
            arrL = A;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrS.length; i++) {
            map.put(arrS[i], map.getOrDefault(arrS[i], 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arrL.length; i++) {
            Integer val = map.get(arrL[i]);
            if (val != null && val > 0) {
                map.put(arrL[i], val - 1);
                ans.add(arrL[i]);
            }
        }
        return ans;
}

    public static void main(String[] args) {
        CommonNumbersII test = new CommonNumbersII();
        int[] arrA = new int[]{};
        int[] arrB = new int[]{};
        System.out.println(test.common(arrA, arrB));
    }
}
