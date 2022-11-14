package BinarySearch;

/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

        Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

        Return the minimum integer k such that she can eat all the bananas within h hours.
*/

public class KokoEatingBananas {
    // approach 1 - Binary Search + Arrays TC: O(nlogm) SC: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        // binary search
        while (left < right) {
            int mid = (left + right) >> 1;

            int count = 0;
            for (int i = 0; i < piles.length; i++) {
                count += Math.ceil(piles[i] * 1.0 / mid);
            }

            // check
            if (count > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        KokoEatingBananas test = new KokoEatingBananas();
        int[] arr = new int[]{30, 11, 23, 4, 20};
        System.out.println(test.minEatingSpeed(arr, 6));
    }
}
