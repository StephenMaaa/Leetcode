package HashTable;

/*
Find all numbers that appear in both of the two unsorted arrays, return the common numbers in increasing order.

        Assumptions

        Both arrays are not null.
        There are no duplicate numbers in each of the two arrays respectively.
        Exmaples

        A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
        A = {}, B = {3, 1, 4}, return []
*/

import java.util.*;

public class CommonNumbersNoDup {
    // approach 1: two pointers - TC: O(nlogn) SC: O(1)
    public List<Integer> common(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);

        List<Integer> res = new ArrayList<>();
        int pointerA = 0;
        int pointerB = 0;
        while (pointerA < a.size() && pointerB < b.size()) {
            // case 1: A == B
            // case 2: A < B
            // case 3: A > B
            if (a.get(pointerA).equals(b.get(pointerB))) {
                res.add(a.get(pointerA));
                pointerA++;
                pointerB++;
            } else if (a.get(pointerA) < b.get(pointerB)) {
                pointerA++;
            } else {
                pointerB++;
            }
        }
        return res;
    }

    // approach 2: set - TC: O(nlogn) SC: O(n)
    public List<Integer> common2(List<Integer> a, List<Integer> b) {
        Set<Integer> dup = new HashSet<>();

        // add all unique ints in arrA to set
        for (int i = 0; i < a.size(); i++) {
            if (!dup.contains(a.get(i))) {
                dup.add(a.get(i));
            }
        }

        // count matches in arrB
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < b.size(); i++) {
            if (dup.contains(b.get(i))) {
                res.add(b.get(i));
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        CommonNumbersNoDup test = new CommonNumbersNoDup();
        List<Integer> a = Arrays.asList(1200);
        List<Integer> b = Arrays.asList(1200);
        System.out.println(test.common(a, b)); 
    }
}
