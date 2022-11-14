package HashTable;

/*
You are given a 0-indexed array of n integers arr.

        The interval between two elements in arr is defined as the absolute difference between their indices. More formally, the interval between arr[i] and arr[j] is |i - j|.

        Return an array intervals of length n where intervals[i] is the sum of intervals between arr[i] and each element in arr with the same value as arr[i].

        Note: |x| is the absolute value of x.
*/

import java.util.*;

public class IntervalsBetweenIdenticalElements {
//    // approach 1 - Map TC: O(n^2) SC: O(n)
//    public long[] getDistances(int[] arr) {
//        // index map
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (!map.containsKey(arr[i])) {
//                map.put(arr[i], new ArrayList<>());
//            }
//            map.get(arr[i]).add(i);
//        }
//
//        long[] res = new long[arr.length];
//        long sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum = 0;
//            for (int index : map.get(arr[i])) {
//                sum += Math.abs(i - index);
//            }
//            res[i] = sum;
//        }
//        return res;
//    }

//    // approach 2 - Map + prefixSum TC: O(n) SC: O(n)
//    public long[] getDistances(int[] arr) {
//        // index map
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (!map.containsKey(arr[i])) {
//                map.put(arr[i], new ArrayList<>());
//            }
//            map.get(arr[i]).add(i);
//        }
//
//        long[] res = new long[arr.length];
//        for (int key : map.keySet()) {
//            List list = map.get(key);
//            long[] prefixSum = new long[list.size()];
//            prefixSum[0] = (int) list.get(0);
//            for (int i = 1; i < list.size(); i++) {
//                prefixSum[i] = prefixSum[i - 1] + (int) list.get(i);
//            }
//
//            for (int i = 0; i < list.size(); i++) {
//                long index = (long) (int) list.get(i);
//                res[(int) index] = index * (i + 1) - prefixSum[i] + prefixSum[list.size() - 1] - prefixSum[i] - index * (list.size() - i - 1);
//            }
//        }
//        return res;
//    }

    public long[] getDistances(int[] arr) {
        long[] intervals = new long[arr.length];

        long[] sum = new long[100001];
        long[] count = new long[100001];

        for(int i=0; i<arr.length; i++){
            intervals[i] += count[arr[i]]*i - sum[arr[i]];

            sum[arr[i]] += i;
            count[arr[i]]++;
        }

        Arrays.fill(sum, 0);
        Arrays.fill(count, 0);

        for(int i=arr.length-1; i>=0; i--){
            intervals[i] += sum[arr[i]] - count[arr[i]]*i;

            sum[arr[i]] += i;
            count[arr[i]]++;
        }

        return intervals;
    }

    public static void main(String[] args) {
        IntervalsBetweenIdenticalElements test = new IntervalsBetweenIdenticalElements();
        int[] arr = new int[]{10, 5, 10, 10};
        System.out.println(Arrays.toString(test.getDistances(arr)));
    }
}
