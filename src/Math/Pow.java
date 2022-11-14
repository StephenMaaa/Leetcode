package Math;

/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
*/

public class Pow {
    // approach 1 - Math + Recursion TC: O(logn) SC: O(logn)
    public double myPow(double x, int n) {
        // case 1: n < 0
        // case 2: otherwise
        if (n < 0) {
            return pow(1.0 / x, -n);
        } else {
            return pow(x, n);
        }
    }

    private double pow(double x, int n) {
        // base case
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        // recursive case
        double half = pow(x, n / 2);

        // case 1: even
        // case 2: odd
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Pow test = new Pow();
        System.out.println(test.myPow(2, 10));
    }
}
