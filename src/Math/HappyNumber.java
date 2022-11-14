package Math;

/*
Write an algorithm to determine if a number n is happy.

        A happy number is a number defined by the following process:

        Starting with any positive integer, replace the number by the sum of the squares of its digits.
        Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        Those numbers for which this process ends in 1 are happy.
        Return true if n is a happy number, and false if not.
*/

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    // approach 1 - Set TC: O(n) SC: O(n)
    public boolean isHappy(int n) {
        // initialization
        int sum = n;
        Set<Integer> set = new HashSet<>();

        while (sum != 1) {
            n = 0;
            while (sum != 0) {
                int digit = sum % 10;
                n += digit * digit;
                sum /= 10;
            }
            sum = n;

            // check cycle
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
        }
        return true;
    }

    public static void main(String[] args) {
        HappyNumber test = new HappyNumber();
        System.out.println(test.isHappy(2));
    }
}
