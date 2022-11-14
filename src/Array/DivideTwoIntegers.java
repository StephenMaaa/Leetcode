package Array;

/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

        The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

        Return the quotient after dividing dividend by divisor.

        Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
*/

public class DivideTwoIntegers {
    // approach 1 - Loop TC: O(k/n) SC: O(1)
    public int divide(int dividend, int divisor) {
        // edge case
        if (dividend == 0) {
            return 0;
        }

        int sign = 1;
//        if (dividend < 0 && divisor < 0) {
//            dividend = -dividend;
//            divisor = -divisor;
//        }
        if (dividend < 0 && divisor > 0) {
            sign = -1;
            dividend *= sign;
        } else if (dividend > 0 && divisor < 0) {
            sign = -1;
            divisor *= sign;
        }

        int count = 0;
        while ((dividend >= divisor && sign == 1) || (dividend <= divisor && sign == -1)) {
            dividend -= divisor;
            count += sign;

            // check overflow
            if (count == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (count == Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return count;
    }

    // approach 2 - Binary Search TC: O(log(m + n)) SC: O(1)
    public int divide2(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;

        boolean flag = false;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            flag = true;
        }

        // set both integers to positive
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }

        // binary search
        // k * divisor <= a <= (k + 1) * divisor
        long l = 0, r = a;
        while (l < r) {
            long mid = l + r + 1 >> 1;

            if (mul(mid, b) <= a) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        r = flag ? -r : r;
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) r;
    }
    long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans += a;
            }

            k >>= 1;
            a += a;
        }
        return ans;
    }

    public static void main(String[] args) {
        DivideTwoIntegers test = new DivideTwoIntegers();
        System.out.println(test.divide2(-2147483648, -1));
    }
}
