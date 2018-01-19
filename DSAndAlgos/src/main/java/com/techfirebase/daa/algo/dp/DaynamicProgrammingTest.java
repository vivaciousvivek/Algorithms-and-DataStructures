package com.techfirebase.daa.algo.dp;

/**
 * 
 * @author VIVEK KUMAR SINGH
 * @since 19-01-2018
 */
public class DaynamicProgrammingTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n*************nth Fibonacci Number*************\n");
		sb.append("\n*************(((By Recursion)))*************\n");
		System.out.println(sb);
		sb.delete(0, sb.length());
		
		System.out.println(FibonacciNumber.fibByRecursion(9));
		
		sb.append("\n*************(((By DP)))*************\n");
		System.out.println(sb);
		sb.delete(0, sb.length());
		
		FibonacciNumber.initializeLookupTable(9);
		System.out.println(FibonacciNumber.fibByDPMemoization(9));
		
	}

}
