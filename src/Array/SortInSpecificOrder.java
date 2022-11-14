package Array;

/*
Given two integer arrays A1 and A2, sort A1 in such a way that the relative order among the elements will be same as those are in A2.

        For the elements that are not in A2, append them in the right end of the A1 in an ascending order.

        Assumptions:

        A1 and A2 are both not null.
        There are no duplicate elements in A2.
        Examples:

        A1 = {2, 1, 2, 5, 7, 1, 9, 3}, A2 = {2, 1, 3}, A1 is sorted to {2, 2, 1, 1, 3, 5, 7, 9}
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortInSpecificOrder {
    public int[] sortSpecial(int[] A1, int[] A2) {
        // initialization
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A2.length; i++) {
            map.put(A2[i], 0);
        }

        // count sort
        int i = 0;
        int bound = A1.length - 1;
        while (i <= bound) {
            // case 1: A1[i] in A2
            // case 2: otherwise
            if (map.containsKey(A1[i])) {
                map.put(A1[i], map.get(A1[i]) + 1);
                i++;
            } else {
                swap(A1, i, bound--);
            }
        }

        // fill
        int count = 0;
        for (i = 0; i < A2.length; i++) {
            for (int j = 0; j < map.get(A2[i]); j++) {
                A1[count++] = A2[i];
            }
        }

        // sort the rest
        Arrays.sort(A1, bound + 1, A1.length);
        return A1;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        SortInSpecificOrder test = new SortInSpecificOrder();
        int[] A1 = new int[]{1, 3, 0};
        int[] A2 = new int[]{};
        System.out.println(Arrays.toString(test.sortSpecial(A1, A2)));
    }
}
