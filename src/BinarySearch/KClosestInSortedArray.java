package BinarySearch;

/*
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A. If there is a tie, the smaller elements are always preferred.

        Assumptions

        A is not null
        K is guranteed to be >= 0 and K is guranteed to be <= A.length
        Return

        A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
        Examples

        A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
        A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
*/

import java.util.*;

public class KClosestInSortedArray {
    public class Cell implements Comparable<Cell> {
        int index;
        int diff;

        public Cell(int index, int diff) {
            this.index = index;
            this.diff = diff;
        }

        @Override
        public int compareTo(Cell other) {
            return other.diff - this.diff;
        }
    }

//    public int[] kClosest(int[] array, int target, int k) {
//        if (k == 0) {
//            return new int[0];
//        }
//        PriorityQueue<Cell> maxHeap = new PriorityQueue<>();
//        for (int i = 0; i < array.length; i++) {
//            if (maxHeap.size() < k) {
//                maxHeap.offer(new Cell(array[i], Math.abs(target - array[i])));
//            } else {
//                // case 1: left min diff bound <= right min diff bound -> return
//                // case 2: left min diff bound > right min diff bound -> shift right
//                if (maxHeap.peek().diff <= Math.abs(target - array[i])) {
//                    break;
//                } else {
//                    maxHeap.poll();
//                    maxHeap.offer(new Cell(array[i], Math.abs(target - array[i])));
//                }
//            }
//        }
//
//        int[] ans = new int[k];
//        for (int i = k - 1; i >= 0; i--) {
//            ans[i] = maxHeap.poll().index;
//        }
//        return ans;
//    }

//    public int[] kClosest(int[] array, int target, int k) {
//        if (k == 0) {
//            return new int[0];
//        }
//        int[] ans = new int[k];
//        int left = findLargestSmallerOrEqual(array, target);
//        int right = left + 1;
//        for (int i = 0; i < k; i++) {
//            if (right >= array.length || (left >= 0 && Math.abs(target - array[left])  <= Math.abs(target - array[right]))) {
//                ans[i] = array[left--];
//            } else {
//                ans[i] = array[right++];
//            }
//        }
//        return ans;
//    }
//
//    private int findLargestSmallerOrEqual(int[] array, int target) {
//        int left = 0, right = array.length - 1;
//        while (left < right - 1) {
//            int mid = left + (right - left) / 2;
//            if (array[mid] <= target) {
//                left = mid;
//            } else {
//                right = mid;
//            }
//        }
//
//        if (array[right] <= target) {
//            return right;
//        }
//        if (array[left] <= target) {
//            return left;
//        }
//        return -1;
//    }

    // time complexity: O(logn + k)
    // space complexity: O(1)
    public int[] kClosest(int[] array, int target, int k) {
        int[] res = new int[k];
        // edge case
        if (k == 0) {
            return res;
        }

        int left = 0;
        int right = array.length - 1;

        // binary search to find the closest index
        int closest = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                closest = mid;
                break;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // update closest index
        if (closest == -1) {
            // edge case
            if (left == array.length) {
                closest = right;
            } else if (right == -1) {
                closest = left;
            } else {
                closest = Math.abs(target - array[left]) > Math.abs(target - array[right]) ? right : left;
            }
        }

        // two pointers to find k closest
        res[0] = array[closest];
        left = closest - 1;
        right = closest + 1;
        for (int i = 1; i < k; i++) {
            // case 1: left invalid
            // case 2: right invalid
            // case 3: otherwise
            if (left < 0) {
                res[i] = array[right++];
            } else if (right >= array.length) {
                res[i] = array[left--];
            } else {
                if (target - array[left] > array[right] - target) {
                    res[i] = array[right++];
                } else {
                    res[i] = array[left--];
                }
            }
        }
        return res;
    }

//    // approach 1 - Binary Search TC: O(logn + k) SC: O(k)
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        // find the closest
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            int mid = (left + right) >> 1;
//
//            // case 1: arr[mid] == target
//            // case 2: arr[mid] < target
//            // case 3: otherwise
//            if (arr[mid] == x) {
//                left = mid;
//                break;
//            } else if (arr[mid] < x) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        // check the closest
//        if (left >= arr.length) {
//            left = right;
//        } else if (right < 0) {
//            left = left;
//        } else {
//            left = Math.abs(x - arr[left]) < Math.abs(x - arr[right]) ? left : right;
//        }
//
//        // search left & right
//        Deque<Integer> res = new ArrayDeque<>();
//        res.add(arr[left]);
//        right = left + 1;
//        left = left - 1;
//        while (res.size() < k) {
//            if (left < 0) {
//                res.offerLast(arr[right++]);
//            } else if (right >= arr.length) {
//                res.offerFirst(arr[left--]);
//            } else if (x - arr[left] <= arr[right] - x) {
//                res.offerFirst(arr[left--]);
//            } else {
//                res.offerLast(arr[right++]);
//            }
//        }
//        return new ArrayList<>(res);
//    }

    // approach 2 - Binary Search + Sliding Window TC: O(logn + k) SC: O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // find the closest
//        int left = 0;
//        int right = arr.length - 1;
//        while (left < right) {
//            int mid = (left + right) >> 1;
//
//            // case 1: arr[mid] < target
//            // case 2: otherwise
//            if (arr[mid] < x) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }

        // find the closest
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;

            // case 1: arr[mid] == target
            // case 2: arr[mid] < target
            // case 3: otherwise
            if (arr[mid] == x) {
                left = mid;
                break;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // check the closest
        if (left >= arr.length) {
            left = right;
        } else if (right < 0) {
            left = left;
        } else {
            left = Math.abs(x - arr[left]) < Math.abs(x - arr[right]) ? left : right;
        }

        // search left & right
        List<Integer> res = new ArrayList<>();
        right = left + 1;
        left--;
        while (right - left - 1 < k) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }

        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        KClosestInSortedArray test = new KClosestInSortedArray();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(test.findClosestElements(arr, 4, 3));
    }
}
