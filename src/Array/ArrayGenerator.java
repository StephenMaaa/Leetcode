package Array;

import java.util.Arrays;

public class ArrayGenerator {
    public int[] arrayGenerator(int[] arr, int l, int r) {
        int[] res = new int[arr.length];
        int lastDiff = l - arr[0];
        res[0] = l;
        for (int i = 1; i < arr.length; i++) {
            int min = lastDiff + arr[i] + 1;
            lastDiff++;

            // check
            if (min < l || min > r) {
                return new int[]{-1};
            }
            res[i] = min;
        }
        return res;
    }

//    public int[] arrayGenerator(int[] arr, int l, int r) {
//        int[] res = new int[arr.length];
//        int lastDiff = l - arr[0];
//        res[0] = l;
//        for (int i = 1; i < arr.length; i++) {
////            int min = lastDiff + arr[i] + 1;
//            int min = Math.max(res[i - 1], arr[i] + lastDiff + 1);
////            lastDiff++;
//
//            // check
//            if (min < l || min > r) {
//                return new int[]{-1};
//            }
//            lastDiff = min - arr[i];
//            res[i] = min;
//        }
//        return res;
//    }

    public static void main(String[] args) {
        ArrayGenerator test = new ArrayGenerator();
        int[] arr = new int[]{1, 2, 1, 2};
        System.out.println(Arrays.toString(test.arrayGenerator(arr, 1, 10)));
    }
}
