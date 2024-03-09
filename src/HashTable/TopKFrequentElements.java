package HashTable;

/*
LeetCode 347

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/

import java.util.*;

public class TopKFrequentElements {
//    // approach 1 - Map + PriorityQueue (minHeap) TC: O(nlogk) SC: O(n + k)
//    public int[] topKFrequent(int[] nums, int k) {
//        // generate a frequency map
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//
//        // maintain a minHeap of size k
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//        for (int key : map.keySet()) {
////            // check
////            if (minHeap.size() < k) {
////                minHeap.offer(new int[]{key, map.get(key)});
////            } else if (minHeap.peek()[1] < map.get(key)) {
////                minHeap.poll();
////                minHeap.offer(new int[]{key, map.get(key)});
////            }
//            minHeap.offer(new int[]{key, map.get(key)});
//
//            // check
//            if (minHeap.size() > k) {
//                minHeap.poll();
//            }
//        }
//
//        // populate
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = minHeap.poll()[0];
//        }
//        return res;
//    }

//    // approach 2 - Map + Count Array (Bucket Sort) TC: O(n) SC: O(n)
//    public int[] topKFrequent(int[] nums, int k) {
//        // generate a frequency map
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//
//        // generate a count-list array of size n
//        List<Integer>[] countArr = new List[nums.length + 1];
//        for (int key : map.keySet()) {
//            if (countArr[map.get(key)] == null) {
//                countArr[map.get(key)] = new ArrayList<>();
//            }
//            countArr[map.get(key)].add(key);
//        }
//
//        // populate
//        int[] res = new int[k];
//        int count = 0;
//        List<Integer> list;
//        for (int i = nums.length; i > 0; i--) {
//            if (countArr[i] == null) {
//                continue;
//            }
//
//            for (int key : countArr[i]) {
//                if (count < k) {
//                    res[count++] = key;
//                }
//            }
//
//            // check
//            if (count == k) {
//                break;
//            }
//        }
//        return res;
//    }

//    Random random = new Random();
//
//    // approach 3 - Map + Quick Sort (Partition) TC: O(n) SC: O(n)
//    public int[] topKFrequent(int[] nums, int k) {
//        // generate a frequency map
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//
//        // generate a 2D array
//        int[][] arr = new int[map.size()][2];
//        int i = 0;
//        for (int key : map.keySet()) {
//            arr[i++] = new int[]{key, map.get(key)};
//        }
//
//        // quick sort
//        quickSort(arr, arr.length - k);
//
//        // populate
//        int[] res = new int[k];
//        for (i = 0; i < k; i++) {
//            res[i] = arr[arr.length - i - 1][0];
//        }
//        return res;
//    }
//
//    private void quickSort(int[][] arr, int k) {
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            int pivot = partition(arr, left, right);
//
//            // case 1: pivot == k
//            // case 2: pivot < k
//            // case 3: pivot > k
//            if (pivot == k) {
//                break;
//            } else if (pivot < k) {
//                left = pivot + 1;
//            } else {
//                right = pivot - 1;
//            }
//        }
//    }
//
//    private int partition(int[][] arr, int left, int right) {
//        int pivot = left + random.nextInt(right - left + 1);
//        swap(arr, pivot, right);
//        pivot = arr[right][1];
//        for (int i = left; i < right; i++) {
//            if (arr[i][1] <= pivot) {
//                swap(arr, i, left++);
//            }
//        }
//        swap(arr, left, right);
//        return left;
//    }
//
//    private void swap(int[][] arr, int i, int j) {
//        int[] temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    // approach 1: Map + Quick Sort TC: O(n) SC: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        // initialization
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int[][] arr = new int[map.size()][];
        int i = 0;
        for (int key : map.keySet()) {
            arr[i++] = new int[]{key, map.get(key)};
        }

        // sort
        quickSort(arr, k);

        // process result
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = arr[j][0];
        }
        return res;
    }

    private void quickSort(int[][] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int pivot = partition(arr, left, right);

            // check
            // case 1: == k
            // case 2: < k
            // case 3: > k
            if (pivot == k) {
                return;
            } else if (pivot < k) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
    }

    Random rand = new Random();

    private int partition(int[][] arr, int left, int right) {
        int pivot = left + rand.nextInt(right - left + 1);
        swap(arr, pivot, right);

        // partition
        for (int i = left; i < right; i++) {
            // check
            if (arr[i][1] > arr[right][1]) {
                swap(arr, i, left++);
            }
        }

        // swap with pivot
        swap(arr, left, right);
        return left;
    }

    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        TopKFrequentElements test = new TopKFrequentElements();
        int[] arr = new int[]{1, 1, 1, 2, 3};
        System.out.println(Arrays.toString(test.topKFrequent(arr, 2)));
    }
}
