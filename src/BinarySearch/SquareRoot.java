package BinarySearch;

/*
Given an integer number n, find its integer square root.

        Assumption:

        n is guaranteed to be >= 0.
        Example:

        Input: 18, Return: 4

        Input: 4, Return: 2
*/

public class SquareRoot {
    public int sqrt(int x) {
        int left = 0;
        int right = x / 2 + 1;
        int closest = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 || mid < x / mid) {
                closest = mid;
                left = mid + 1;
            } else if (mid == x / mid) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return closest;
    }

    // approach 1 - Math + Binary Search TC: O(logn) SC: O(1)
    public int mySqrt(int x) {
        int left = 0;
        int right = x / 2 + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // case 1: mid^2 <= x
            // case 2: mid^2 > x
            if (mid == 0 || mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        SquareRoot test = new SquareRoot();
        System.out.println(test.sqrt(99));
    }
}
