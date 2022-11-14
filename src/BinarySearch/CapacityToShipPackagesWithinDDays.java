package BinarySearch;

/*
A conveyor belt has packages that must be shipped from one port to another within days days.

        The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

        Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
*/

public class CapacityToShipPackagesWithinDDays {
    // approach 1 - Binary Search + Arrays TC: O(nlogn) SC: O(1)
    public int shipWithinDays(int[] weights, int days) {
        // get max and sum of arr
        int left = 0;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        // binary search
        int min = right;
        while (left <= right) {
            int mid = (left + right) >> 1;

            // count number of days
            int count = 1;
            int capacity = 0;
            for (int i = 0; i < weights.length; i++) {
                // case 1: cap + arr[i] <= mid
                // case 2: otherwise
                if (capacity + weights[i] <= mid) {
                    capacity += weights[i];
                } else {
                    capacity = weights[i];
                    count++;
                }
            }

            // check
            // case 1: count <= D
            // case 2: otherwise
            if (count <= days) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min; 
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays test = new CapacityToShipPackagesWithinDDays();
        int[] arr = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(test.shipWithinDays(arr, 3));
    }
}
