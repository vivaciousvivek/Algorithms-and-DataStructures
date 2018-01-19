package com.techfirebase.daa.algo.dp;

import java.util.Arrays;

/**
 * Fibonacci series is the following series of integers:
 * 0,1,1,2,3,5,8,13,21.......
 * 
 * We can get fibonacci series till nth number and get the nth fibonacci number
 * by recursion and by dynamic programming
 * 
 * @author VIVEK KUMAR SINGH
 * @since 19-01-2018
 */
public class FibonacciNumber {

	private static int[] lookup;

	/**
	 * Initialize lookup table from Nill for memoization
	 * 
	 * @param n
	 */
	public static void initializeLookupTable(int n) {
		lookup = new int[n + 1];
		Arrays.fill(lookup, -1);
	}

	/**
	 * Recursive implementation TC: O(2^n), SC: O(n) for stack size of n elements
	 * 
	 * @param n input nth term
	 * @return nth fibonacci number
	 */
	public static int fibByRecursion(int n) {
		if (n <= 1)
			return n;
		return fibByRecursion(n - 1) + fibByRecursion(n - 2);
	}

	/**
	 * Implementation by DP[overlapping sub problem and
	 * memoization(top-down/recursive)]
	 * 
	 * Memoization technique is similar to recursive technique, but the difference
	 * is we maintain a lookup table to store the solutions of previously solved
	 * sub-problems.
	 * 
	 * Instead of solving the same sub-problems multiple times we solve and store
	 * solutions into lookup table once, and reuse their solutions
	 * 
	 * TC: O(), SC: O(n) for stack size of n elements
	 * 
	 * @param n input nth term
	 * @return nth fibonacci series
	 */
	public static int fibByDPMemoization(int n) {
		if (lookup[n] == -1) {
			if (n <= 1)
				lookup[n] = n;
			else
				lookup[n] = fibByDPMemoization(n - 1) + fibByDPMemoization(n - 2);
		}

		return lookup[n];
	}
}
