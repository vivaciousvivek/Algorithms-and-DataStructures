package com.techfirebase.daa.algo.dp;

import java.util.Arrays;

/**
 * Problem Statement:
 * 
 * We have to cut the rod in such a way that we have to maximize the profit by selling some pieces.
 * 
 * 1. Given a rod of length N inches and an array of prices that contains prices of different pieces of size smaller than N.
 * 2. So we have to cut the rod of length N using these pieces in such a way that we get the maximum profit.
 * 
 * For example, if length of the rod is 8 and the values of different pieces are given as following, then the
 * maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *
 * length | 1 2 3 4 5 6 7 8 
 * -------------------------------------------- 
 * price  | 1 5 8 9 10 17 17 20
 * 
 * Optimal Substructure:
 * 
 * There are 2 cases possible either we take the rod or doesn't
 * <p>
 * 1. If we take any piece of rod: To get the maximum profit/value, by using the first i rods, to cut first j length(given) of rod.
 * <p>
 * entry = maximum profit/value; i = no. of pieces of rod; j = length of rod
 * <p>
 * CR(i,j) = value(i) + CR(i,j-i)) ; If i <= j
 * <p>
 * 2. If we don't take any piece of rod:
 * <p>
 * CR(i,j) = CR(i-1,j) ; If i <= j
 * <p>
 * To get the maximum profit/value, we need to find that in which case will get maximum profit/value by taking ith rod or by not taking it
 * 
 * 
 * @author VIVEK KUMAR SINGH
 * @since 23-01-2018
 */
public class CuttingRod {
	
	/*
     * use to store the solutions of previously solved sub-problems into this table
     */
    private static int[][] lookupTable;
    
    /*
     * use to store the solutions of previously solved sub-problems into this One D array and 
     * second array will be used for backtrack the result for One D array
     */
    private static int[] lookup;
    private static int[] backtrack;

    /*
     * use to hold the values of pieces of rod
     */
    private static int[] values;

    /*
     * use to hold the size of values array
     */
    private static int m = 0;

    /*
     * use to hold Length of given road to cut
     */
    private static int n = 0;

    
    private CuttingRod() {}
    
    /**
     * 
     * @param val values of pieces of rod
     * @param length Length of given road to cut
     * @param isSpaceOptimize initialize the lookupTable according to optimize the space or not
     */
    private static void initialize(int[] val, int length, boolean isSpaceOptimize) {
        values = val;
        m = val.length;
        n = length;

        /*
        * This if block will be use for space optimized version of Knapsack
        */
        if (isSpaceOptimize) {
        	lookup = new int[n + 1];
        	backtrack = new int[n + 1];
        } else
            lookupTable = new int[m + 1][n + 1];
    }
    
    /**
     * 
     * @param val values of pieces of rod
     * @param length Length of given road to cut
     * @return Maximum Profit after cutting the rod of given length
     */
    public static int maximumProfit(int[] val, int length) {
    	
    	initialize(val, length, false);
    	
    	for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                /*
                * First row and column represent the empty sub-sequence of length 0 so we initialize them with 0
                * and also provide the value for the next sub-problems
                */
                if ((i == 0 && j == 0) || (i != 0 && j == 0))
                    lookupTable[i][j] = 0;
                else if (i == 0 && j != 0)
                    lookupTable[i][j] = j;
                else if (i <= j && (values[i - 1] + lookupTable[i][j - i] > lookupTable[i - 1][j]))
                    lookupTable[i][j] = values[i - 1] + lookupTable[i][j - i];
                else
                    lookupTable[i][j] = lookupTable[i - 1][j];
            }
        }

        return lookupTable[m][n];
    }
    
    /**
     * 
     * @return Maximum Profit after cutting the rod of given length
     */
    public static int[] getMaximumProfit() {
        int i = m;
        int j = n;

        int[] profitValues = new int[m];

        while (i > 0 && j > 0) {
          /*
           * If not coming from above row then it we had picked it otherwise not
    	   */
            if (lookupTable[i][j] != lookupTable[i - 1][j]) {
                profitValues[i - 1] = values[i - 1];
                j -= i;
            } else
                i--;
        }

        return profitValues;
    }
    
    /**
     * One D array implementation
     * 
     * @param val values of pieces of rod
     * @param length Length of given road to cut
     * @return Maximum Profit after cutting the rod of given length
     */
    public static int maximumProfitByOneDArray(int[] val, int length) {
    	initialize(val, length, true);
        
    	Arrays.fill(lookup, 1, lookup.length, Integer.MIN_VALUE);
    	Arrays.fill(backtrack, -1);
    	
    	for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                
    			/*
                 * If picked value is maximum than already exist value
    			 */
                if (i < j && ((values[i] + lookup[j - i - 1]) > lookup[j])) {
                    lookup[j] = values[i] + lookup[j - i - 1];
                    backtrack[j] = i;
                }

            }
        }
    	
		return lookup[n];
    }
    
    /**
     * One D array implementation of printing the selected rods
     */
    public static void getMaximumProfitByOneDArray() {
    	int j = n;
    	int i = m;
    	System.out.println("\n=========================================");
    	
    	while (j > 0 && i > 0) {
    		i = backtrack[j--];
    		System.out.println("Picked rod piece : " + values[i]);
    		j -= i;
    	}
    	
    	System.out.println("\n=========================================");
    	
    }

}
