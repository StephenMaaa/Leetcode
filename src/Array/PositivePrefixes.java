package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PositivePrefixes {
    // approach 1 - Sorting + PrefixSum TC: O(nlogn) SC: O(logn)
    public int positivePrefixes(List<Integer> arr) {
        // sort
        Collections.sort(arr, Collections.reverseOrder());

        int res = 0;
        long prefixSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            prefixSum += arr.get(i);

            // check
            if (prefixSum < 0) {
                break;
            }
            res++;
        }
        return res; 
    }

    public static void main(String[] args) {
        PositivePrefixes test = new PositivePrefixes();
        List<Integer> arr = Arrays.asList(-6, 3, 4, -10);
        System.out.println(test.positivePrefixes(arr));
    }
}
