package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumbers {
    public List<List<Integer>> closestNumbers(int[] arr) {
        // sort
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            // case 1: arr[i] - arr[i - 1] < minDiff
            // case 2: arr[i] - arr[i - 1] == minDiff
            // case 3: arr[i] - arr[i - 1] > minDiff
            if (arr[i] - arr[i - 1] < minDiff) {
                minDiff = arr[i] - arr[i - 1];
                res.clear();
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (arr[i] - arr[i - 1] == minDiff) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ClosestNumbers test = new ClosestNumbers();
        int[] arr = new int[]{6, 2, 4, 10};
        System.out.println(test.closestNumbers(arr));
    }
}
