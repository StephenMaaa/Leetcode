package Array;

/*
Find all common elements in 3 sorted arrays.

        Assumptions

        The 3 given sorted arrays are not null
        There could be duplicate elements in each of the arrays
        Examples

        A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]
*/

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInThreeSortedArrays {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        int pointerA = 0;
        int pointerB = 0;
        int pointerC = 0;
        List<Integer> ans = new ArrayList<>();
        while (pointerA < a.length && pointerB < b.length && pointerC < c.length) {
            if (a[pointerA] == b[pointerB] && b[pointerB] == c[pointerC]) {
                ans.add(a[pointerA]);
                pointerA++;
                pointerB++;
                pointerC++;
            } else if (a[pointerA] <= b[pointerB] && a[pointerA] <= c[pointerC]) {
                pointerA++;
            } else if (b[pointerB] <= a[pointerA] && b[pointerB] <= c[pointerC]) {
                pointerB++;
            } else {
                pointerC++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CommonElementsInThreeSortedArrays test = new CommonElementsInThreeSortedArrays();
        int[] a = new int[]{1,2,3,3};
        int[] b = new int[]{2,3,4,4,5};
        int[] c = new int[]{1,1,3,3};
        System.out.println(test.common(a, b, c));
    }
}
