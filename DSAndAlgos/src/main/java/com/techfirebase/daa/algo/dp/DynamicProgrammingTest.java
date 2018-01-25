package com.techfirebase.daa.algo.dp;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

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

        /*sb.append("\n*************0-1 Knapsack*************\n");

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
        sb.append("\n =====> Maximum Profit: ").append(ZeroOneKnapsack.maximumProfit(weights, values, capacity));
        sb.append("\n =====> Weights give maximum Profit: ").append(Arrays.toString(ZeroOneKnapsack.getKnapsackWeights()));
        sb.append("\n End Time: ").append(LocalTime.now());

        sb.append("\n\n*************(((Optimized SC)))*************\n");
        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Length: ").append(ZeroOneKnapsack.maximumProfitBySpaceOptimize(weights, values, capacity));
        sb.append("\n End Time: ").append(LocalTime.now());*/

        /*sb.append("\n*************Coin Exchange*************\n");

        int[] denominations;

         * Ascending order

//        denominations = new int[] {1, 2, 3};
        denominations = new int[] {1, 5, 6, 9};


         * Descending order

//        denominations = new int[] {25, 10, 5};
//        denominations = new int[] {9, 6, 5, 1};
//        denominations = new int[] {1, 9, 5, 6};
        sb.append("\n Denominations : ").append(Arrays.toString(denominations));

        int rupee;
        rupee = 5;
        rupee = 15;

//        rupee = 30;
//        rupee = 15;
//        rupee = 12;
        sb.append("\n Rupee : ").append(rupee);

        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Minimum Coins: ").append(CoinExchange.minimumCoins(denominations, rupee));
        sb.append("\n =====> Minimum Coins to pay given Rupee: ").append(Arrays.toString(CoinExchange.getMinimumCoins()));
        sb.append("\n End Time: ").append(LocalTime.now());
        System.out.println(sb);
        sb.delete(0, sb.length());

        sb.append("\n\n*************(((Optimized SC)))*************\n");
        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Minimum Coins By 1-D Array: ").append(CoinExchange.minimumCoinByOneDArray(denominations, rupee));
        sb.append("\n End Time: ").append(LocalTime.now());*/


        /*sb.append("\n*************Cutting Rod*************\n");

        int[] values;
        values = new int[] {2, 5, 7, 8};
//        values = new int[] {1, 5, 8, 9, 10, 17, 17, 20};

        sb.append("\n Prices of pieces of rods : ").append(Arrays.toString(values));

        int length;
        length = 5;
//        length = 8;

        sb.append("\n Lenght of rod u want to sell : ").append(length);

        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Maximum Profit: ").append(CuttingRod.maximumProfit(values, length));
        sb.append("\n =====> Peices to cut the given rod: ").append(Arrays.toString(CuttingRod.getMaximumProfit()));
        sb.append("\n End Time: ").append(LocalTime.now());

        sb.append("\n\n*************(((Optimized SC)))*************\n");
        sb.append("\n Start Time: ").append(LocalTime.now());
		sb.append("\n =====> Maximum Profit By 1-D Array: ").append(CuttingRod.maximumProfitByOneDArray(values, length));
		sb.append("\n End Time: ").append(LocalTime.now());

		sb.append("\n Start Time: ").append(LocalTime.now());
		sb.append("\n =====> Peices to cut the given rod By 1-D Array: ");
        System.out.println(sb);
		sb.delete(0, sb.length());

		CuttingRod.getMaximumProfitByOneDArray();
		sb.append("\n End Time: ").append(LocalTime.now());*/

        /*sb.append("\n*************Cutting Rod*************\n");

        int[] numbers;
        numbers = new int[] {3, 34, 4, 12, 5, 2};

        sb.append("\n Set of Positive integers : ").append(Arrays.toString(numbers));

        int sum;
        sum = 9;

        sb.append("\n Sum that we need to find : ").append(sum);

        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Is Sum exist by their subsets: ").append(SubsetSumProblem.isSubsetSum(numbers, sum));
        sb.append("\n =====> Print the subset: ").append(Arrays.toString(CuttingRod.getMaximumProfit()));
        sb.append("\n End Time: ").append(LocalTime.now());

//        sb.append("\n\n*************(((Optimized SC)))*************\n");
//        sb.append("\n Start Time: ").append(LocalTime.now());
//		sb.append("\n =====> Maximum Profit By 1-D Array: ").append(CuttingRod.maximumProfitByOneDArray(numbers, sum));
//		sb.append("\n =====> Peices to cut the given rod By 1-D Array: ");
//		sb.append("\n End Time: ").append(LocalTime.now());*/

        /*sb.append("\n*************Longest Palindrome Subsequence*************\n");

        sb.append("\n Enter sequence :\n");
        System.out.println(sb);
        sb.delete(0, sb.length());

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();

        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Length: ").append(LongestPalindromeSubsequence.lengthOfLPS(str1));
        sb.append("\n =====> LPS: ").append(Arrays.toString(LongestPalindromeSubsequence.getLPS()));
        sb.append("\n End Time: ").append(LocalTime.now());

//        sb.append("\n\n*************(((Optimized SC)))*************\n");
//        sb.append("\n Start Time: ").append(LocalTime.now());
//        sb.append("\n =====> Length: ").append(LongestCommonSubsequence.lengthOfLCSBySpaceOptimize(str1, str2));
//        sb.append("\n End Time: ").append(LocalTime.now());*/

        sb.append("\n*************Matrix Chain Multiplication*************\n");

        int[] dimensions;
        dimensions = new int[] {2, 3, 6, 4, 5};
//        dimensions = new int[] {1, 2, 3, 4};

        sb.append("\n Set of Matrix dimensions : ").append(Arrays.toString(dimensions));

        sb.append("\n Start Time: ").append(LocalTime.now());
        sb.append("\n =====> Minimum Cost of MCM : ").append(MatrixChainMultiplication.minimumCostOfMCM(dimensions));
//        sb.append("\n =====> Print the subset: ").append(Arrays.toString(CuttingRod.getMaximumProfit()));
        sb.append("\n End Time: ").append(LocalTime.now());

//        sb.append("\n\n*************(((Optimized SC)))*************\n");
//        sb.append("\n Start Time: ").append(LocalTime.now());
//		sb.append("\n =====> Maximum Profit By 1-D Array: ").append(CuttingRod.maximumProfitByOneDArray(numbers, sum));
//		sb.append("\n =====> Peices to cut the given rod By 1-D Array: ");
//		sb.append("\n End Time: ").append(LocalTime.now());

        System.out.println(sb);
		sb.delete(0, sb.length());

    }

}
