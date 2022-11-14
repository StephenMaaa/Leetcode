package Array;

public class TwoSortedArraysSumToTarget {
    // approach 1 - Two Pointers TC: O(m + n) SC: O(1)
    public boolean sumToTarget(int[] arr1, int[] arr2, int target) {
        int pointerA = 0;
        int pointerB = arr2.length - 1;

        while (pointerA < arr1.length && pointerB >= 0) {
            // case 1: arrA[pA] + arrB[pB] == target
            // case 2: arrA[pA] + arrB[pB] < target
            // case 3: arrA[pA] + arrB[pB] > target
            int sum = arr1[pointerA] + arr2[pointerB];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                pointerA++;
            } else {
                pointerB--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSortedArraysSumToTarget test = new TwoSortedArraysSumToTarget();
        int[] arr1 = new int[]{1, 3, 7};
        int[] arr2 = new int[]{2, 3, 6};
        System.out.println(test.sumToTarget(arr1, arr2, 6));
    }
}
