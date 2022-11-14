package Math;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    // approach 1 - Math TC: O(n!) SC: O(1)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));

        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> lastRow = res.get(i - 2);

            list.add(1);
            for (int j = 0; j < i - 2; j++) {
                list.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle test = new PascalsTriangle();
        System.out.println(test.generate(6));
    }
}
