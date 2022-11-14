package Array;

/*
Given two positive integers a and b, return the number of common factors of a and b.

        An integer x is a common factor of a and b if x divides both a and b.
*/

public class NumberOfCommonFactors {
//    // approach 1 - Arrays TC: O(MIN(m, n)) SC: O(1)
//    public int commonFactors(int a, int b) {
//        int count = 0;
//        int min = Math.min(a, b);
//        for (int i = 1; i <= min; i++) {
//            if (a % i == 0 && b % i == 0) {
//                count++;
//            }
//        }
//        return count;
//    }

//    // approach 2 - Improved Arrays TC: O(MIN(m, n)) SC: O(1)
//    public int commonFactors(int a, int b) {
//        int count = 0;
//        int min = Math.min(a, b);
//        if (a != b) {
//            min = Math.min(min, Math.max(a, b) / 2);
//        }
//        for (int i = 1; i <= min; i++) {
//            if (a % i == 0 && b % i == 0) {
//                count++;
//            }
//        }
//        return count;
//    }

    // approach 3 - GCD TC: O(GCD(m, n)) SC: O(1)
    public int commonFactors(int a, int b) {
        int count = 0;
        for (int i = 1; i <= gcd(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        NumberOfCommonFactors test = new NumberOfCommonFactors();
        System.out.println(test.commonFactors(885, 885));
    }
}
