package Math;

/*
Given an integer n, return the number of prime numbers that are strictly less than n.
*/

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {
//    // approach 1 - The Sieve of Eratosthenes TC: O(nlog(logn)) SC: O(n)
//    public int countPrimes(int n) {
//        // initialization
//        boolean[] isPrimes = new boolean[n];
//        for (int i = 2; i < n; i++) {
//            isPrimes[i] = true;
//        }
//
//        // i < sqrt(n)
//        for (int i = 2; i * i < n; i++) {
//            // case: already non-prime
//            if (!isPrimes[i]) {
//                continue;
//            }
//
//            // update all non-primes < n with factor j < n
//            for (int j = i * i; j < n; j += i) {
//                isPrimes[j] = false;
//            }
//        }
//
//        // count
//        int count = 0;
//        for (int i = 2; i < n; i++) {
//            if (isPrimes[i]) {
//                count++;
//            }
//        }
//        return count;
//    }

    // approach 1 - The Sieve of Eratosthenes TC: O(nlog(logn)) SC: O(n)
    public List<Integer> countPrimes(int n) {
        // initialization
        boolean[] isPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrimes[i] = true;
        }

        // i < sqrt(n)
        for (int i = 2; i * i < n; i++) {
            // case: already non-prime
            if (!isPrimes[i]) {
                continue;
            }

            // update all non-primes < n with factor j < n
            for (int j = i * i; j < n; j += i) {
                isPrimes[j] = false;
            }
        }

        // count
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountPrimes test = new CountPrimes();
        System.out.println(test.countPrimes(500));
    }
}
