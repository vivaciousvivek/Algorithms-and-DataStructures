package com.techfirebase.daa.algo.dp;

import java.util.Arrays;

/**
 * Fibonacci series is the following series of integers: 0,1,1,2,3,5,8,13,21.......
 * <p>
 * We can get fibonacci series till nth number and get the nth fibonacci number by recursion and by dynamic programming
 *
 * @author VIVEK KUMAR SINGH
 * @since 19-01-2018
 */
public class FibonacciNumber {

    /*
     * use to store the solutions of previously solved sub-problems into this table for memoization
     */
    private static int[] lookupTable;
    private static final int NILL = -1;

    /**
     * Initialize lookupTable table from Nill for memoization
     *
     * @param n
     */
    public static void initializeLookupTable(int n) {
        lookupTable = new int[n + 1];
        Arrays.fill(lookupTable, NILL);
    }

    /**
     * Recursive implementation TC: O(2^n), SC: O(n) for stack size of n elements
     *
     * @param n input nth term
     *
     * @return nth fibonacci number
     */
    public static int fibByRecursion(int n) {
        if (n <= 1)
            return n;
        return fibByRecursion(n - 1) + fibByRecursion(n - 2);
    }

    /**
     * Implementation by DP[overlapping sub problem and memoization(top-down/recursive)]
     * <p>
     * Memoization technique is similar to recursive technique, but the difference is we maintain a lookupTable table to
     * store the solutions of previously solved sub-problems.
     * <p>
     * Instead of solving the same sub-problems multiple times we solve and store solutions into lookupTable table once,
     * and reuse their solutions
     * <p>
     * TC: O(), SC: O(n) [n + n] for stack and lookupTable array size of n elements
     *
     * @param n input nth term
     *
     * @return nth fibonacci number
     */
    public static int fibByDPMemoization(int n) {
        if (lookupTable[n] == NILL) {
            if (n <= 1)
                lookupTable[n] = n;
            else
                lookupTable[n] = fibByDPMemoization(n - 1) + fibByDPMemoization(n - 2);
        }

        return lookupTable[n];
    }

    /**
     * Implementation by DP[overlapping sub problem and tabulation(bottom-up/iterative)]
     * <p>
     * Tabulation technique is similar to iterative technique, but the difference is we maintain a lookupTable table to
     * store the solutions in bottom up fashion.
     * <p>
     * We begin with solutions with base problem and used them to calculate solutions of higher problems
     * <p>
     * Instead of solving the same sub-problems multiple times we solve and store solutions into lookupTable table once,
     * and reuse their solutions
     * <p>
     * But the difference between both of the DP techniques is that,
     * <p>
     * In memoization there are multiple functions calls, and this is maintained by call stack, so it uses extra
     * memory.
     * <p>
     * In tabulation we avoid multiple lookups by functional call, so it required less amount of space
     * <p>
     * TC: O(n), SC: O(n) for lookupTable array size of n elements
     *
     * @param n input nth term
     *
     * @return nth fibonacci number
     */
    public static int fibByDPTabulation(int n) {
        lookupTable[0] = 0;
        lookupTable[1] = 1;

        for (int i = 2; i <= n; i++) {
            lookupTable[i] = lookupTable[i - 1] + lookupTable[i - 2];
        }

        if (n < 0)
            return 0;

        return lookupTable[n];
    }

    /**
     * To find the next number in the fibonacci series we only need previous two numbers in the series, so we don't need
     * to manage whole series in the table, we can accomplish it by store only previous two numbers in fibonacci series
     * <p>
     * This will improve the space complexity from O(n) to O(1)
     * <p>
     * TC: O(n), SC: O(1)
     *
     * @param n input nth term
     *
     * @return nth fibonacci number
     */
    public static int fibBySpaceOptimize(int n) {
        int i = 0;
        int j = 1;
        int nextFib = 1;

        for (int k = 2; k <= n; k++) {
            nextFib = i + j;
            i = j;
            j = nextFib;
        }

        return nextFib;
    }

    /**
     * Using power of matrix [1 1]^n [1 0]
     * <p>
     * if we multiply this matrix to itself we will get (n+1)th fibonacci number at (0,0) index in the resultant matrix
     * <p>
     * We are using recurrence relation that is derived from this matrix
     * <p>
     * If n is even then k = n/2: F(n) = [2*F(k-1) + F(k)]*F(k)
     * <p>
     * If n is odd then k = (n + 1)/2 F(n) = F(k)*F(k) + F(k-1)*F(k-1)
     * <p>
     * TC: O(logn) [we divide the problem to half in every recursive call], SC: O(n)
     *
     * @param n input nth term
     *
     * @return nth fibonacci number
     */
    public static int fibByOptimizeTC(int n) {
        if (n == 0)
            return lookupTable[n] = 0;

        if (n == 1 || n == 2)
            return lookupTable[n] = 1;

        if (lookupTable[n] == NILL) {
            /*
             * check whether n is even of odd and calculate k's value accordingly
             */
            int k = (n & 1) == 1 ? (n + 1) / 2 : n / 2;

            /*
             * Applying above formula for odd and even n
             */
            if ((n & 1) == 1)
                lookupTable[n] = (fibByOptimizeTC(k) * fibByOptimizeTC(k) + fibByOptimizeTC(k - 1) * fibByOptimizeTC(k - 1));
            else
                lookupTable[n] = (2 * fibByOptimizeTC(k - 1) + fibByOptimizeTC(k)) * fibByOptimizeTC(k);
        }


        return lookupTable[n];
    }
}
