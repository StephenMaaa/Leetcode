package DP;

/*
Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).

        Examples

        0th fibonacci number is 0
        1st fibonacci number is 1
        2nd fibonacci number is 1
        3rd fibonacci number is 2
        6th fibonacci number is 8
        Corner Cases

        What if K < 0? in this case, we should always return 0.
        Is it possible the result fibonacci number is overflowed? We can assume it will not be overflowed when we solve this problem on this online judge, but we should also know that it is possible to get an overflowed number, and sometimes we will need to use something like BigInteger.
*/

public class FibonacciNumber {
    public long fibonacci(int K) {
        // base case
        long n1 = 0;
        long n2 = 0;

        for (int i = 0; i < K + 1; i++) {
            if (i == 0) {
                n1 = 0;
            } else if (i == 1) {
                n2 = 1;
            } else {
                long temp = n1 + n2;
                n1 = n2;
                n2 = temp;
            }
        }
        return n2;
    }

    public static void main(String[] args) {
        FibonacciNumber test = new FibonacciNumber();
        System.out.println(test.fibonacci(1));
    }
}
