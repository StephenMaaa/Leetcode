package Math;

/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

        Given an integer n, return true if n is an ugly number.
*/

public class UglyNumber {
    // approach 1 - Math TC: O(n) SC: O(1)
    public boolean isUgly(int n) {
        // edge case
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        UglyNumber test = new UglyNumber();
        System.out.println(test.isUgly(21));
    }
}
