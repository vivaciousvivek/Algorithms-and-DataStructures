package com.techfirebase.daa.algo.dp;

import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author VIVEK KUMAR SINGH
 * @since 19-01-2018
 */
public class DynamicProgrammingTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        /*int num;

//		num = 9;
//		num = 40;

		 *//*
		 * For large input use BigInteger class in Fibonacci Implementation
		 *//*
//		num = 100;
		num = 10000;

		sb.append("\n*************nth Fibonacci Number*************\n");

//		sb.append("\n*************(((By Recursion)))*************\n");
//
//		sb.append("\n Start Time: ").append(LocalTime.now());
//		sb.append("\n =====> ").append(FibonacciNumber.fibByRecursion(num));
//		sb.append("\n End Time: ").append(LocalTime.now());

//		sb.append("\n\n*************(((By DP [Memoization Technique])))*************\n");
//
//		sb.append("\n Start Time: ").append(LocalTime.now());
//		FibonacciNumber.initializeLookupTable(num);
//		sb.append("\n =====> ").append(FibonacciNumber.fibByDPMemoization(num));
//		sb.append("\n End Time: ").append(LocalTime.now());

//		sb.append("\n\n*************(((By DP [Tabulation Technique])))*************\n");

//		sb.append("\n Start Time: ").append(LocalTime.now());
//		FibonacciNumber.initializeLookupTable(num);
//		sb.append("\n =====> ").append(FibonacciNumber.fibByDPTabulation(num));
//		sb.append("\n End Time: ").append(LocalTime.now());

//		sb.append("\n\n*****(((By using iterative approach to optimize the SC)))*****\n");

//		sb.append("\n Start Time: ").append(LocalTime.now());
//		FibonacciNumber.initializeLookupTable(num);
//		sb.append("\n =====> ").append(FibonacciNumber.fibBySpaceOptimize(num));
//		sb.append("\n End Time: ").append(LocalTime.now());

//		sb.append("\n\n*****(((By using power of matrix to optimize the TC)))*****\n");

//		sb.append("\n Start Time: ").append(LocalTime.now());
//		FibonacciNumber.initializeLookupTable(num);
//		sb.append("\n =====> ").append(FibonacciNumber.fibByOptimizeTC(num));
//		sb.append("\n End Time: ").append(LocalTime.now());
		System.out.println(sb);
		sb.delete(0, sb.length());*/

        /*sb.append("\n*************Longest Common Subsequence*************\n");

        sb.append("\n Enter 2 sequences :\n");
        System.out.println(sb);
        sb.delete(0, sb.length());

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Length: ").append(LongestCommonSubsequence.lengthOfLCS(str1, str2));
        sb.append("\n =====> LCS: ").append(Arrays.toString(LongestCommonSubsequence.getLCS()));
        sb.append("\n End Time: ").append(LocalTime.now());

        sb.append("\n\n*************(((Optimized SC)))*************\n");
        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Length: ").append(LongestCommonSubsequence.lengthOfLCSBySpaceOptimize(str1, str2));
        sb.append("\n End Time: ").append(LocalTime.now());*/

        sb.append("\n*************0-1 Knapsack*************\n");

        int[] weights;
        weights = new int[]{10, 20, 30};
//        weights = new int[]{2, 1, 3, 2};
        sb.append("\n Weights : ").append(Arrays.toString(weights));

        int[] values;
        values = new int[]{60, 100, 120};
//        values = new int[]{12, 10, 21, 15};
        sb.append("\n Profits : ").append(Arrays.toString(values));

        int capacity;
        capacity = 50;
//        capacity = 8;
        sb.append("\n Capacity : ").append(capacity);

        System.out.println(sb);
        sb.delete(0, sb.length());

        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Total Profit: ").append(ZeroOneKnapsack.maximumProfit(weights, values, capacity));
        sb.append("\n =====> Weights give maximum Profit: ").append(Arrays.toString(ZeroOneKnapsack.getKnapsackWeights()));
        sb.append("\n End Time: ").append(LocalTime.now());

        sb.append("\n\n*************(((Optimized SC)))*************\n");
        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Length: ").append(ZeroOneKnapsack.maximumProfitBySpaceOptimize(weights, values, capacity));
        sb.append("\n End Time: ").append(LocalTime.now());

        System.out.println(sb);
		sb.delete(0, sb.length());
    }

}
