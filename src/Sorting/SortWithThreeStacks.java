package Sorting;

/*
Given one stack with integers, sort it with two additional stacks (total 3 stacks).

        After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

        Assumptions:

        The given stack is not null.
        The time complexity should be O(n log n).
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortWithThreeStacks {
    // time complexity: O(nlogn)
    // space complexity: O(n)
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        mergeSort(s1, s2, s3, s1.size());
    }

    private void mergeSort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int size) {
        // edge case
        if (size <= 1) {
            return;
        }

        int firstHalf = size / 2;
        int secondHalf = size - firstHalf;
        // move first half in s1 to s2
        for (int i = 0; i < firstHalf; i++) {
            s2.offerFirst(s1.pollFirst());
        }

        // s1 and s2 uses for sorting, s3 uses for buffer
        // s1 stores #secondHalf and s2 stores #firstHalf
        mergeSort(s2, s3, s1, firstHalf);
        mergeSort(s1, s3, s2, secondHalf);

        // add numbers in ascending order from bottom to top to s3
        int i = 0;
        int j = 0;
        while (i < firstHalf && j < secondHalf) {
            if (s1.peekFirst() < s2.peekFirst()) {
                s3.offerFirst(s1.pollFirst());
                j++;
            } else {
                s3.offerFirst(s2.pollFirst());
                i++;
            }
        }

        while (i < firstHalf) {
            s3.offerFirst(s2.pollFirst());
            i++;
        }

        while (j < secondHalf) {
            s3.offerFirst(s1.pollFirst());
            j++;
        }

        // add numbers in ascending order from top to bottom to s1
        for (i = 0; i < size; i++) {
            s1.offerFirst(s3.pollFirst());
        }
    }

    public static void main(String[] args) {
        SortWithThreeStacks test = new SortWithThreeStacks();
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3, 2, 1, 4));
        test.sort(list);
        System.out.println(list);
    }
}
