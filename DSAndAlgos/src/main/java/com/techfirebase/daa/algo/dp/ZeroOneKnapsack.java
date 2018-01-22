package com.techfirebase.daa.algo.dp;

/**
 * Problem Statement:
 * <p>
 * 1. Given weights(array of weights) and profit/values(array of values) of n items, put these items in a knapsack of
 * capacity W in such a way that we get the maximum total profit/value in the knapsack.
 * <p>
 * 2. And sum of weights of knapsack element that we put, should be less than or equal to the maximum capacity of
 * knapsack i.e W
 * <p>
 * 3. We can't break/fraction the item, either we take it or leave it(should hold 0-1 property)
 * <p>
 * Optimal Substructure:
 * <p>
 * There are 2 cases possible either we take the element or doesn't
 * <p>
 * 1. If we take element: To get the maximum profit/value, using first i elements, to fill the first j capacity of
 * knapsack
 * <p>
 * i = no of elements; j = capacity of knapsack; entry = of DP table will denote profit/value of every corresponding
 * element
 * <p>
 * ED(i,j)= value(i) + ED((i-1),(j-weights(i))) ; if weights(i) <= j
 * <p>
 * 2. If we don't take element:
 * <p>
 * ED(i,j)= ED((i-1),j) ; if weights(i) <= j
 * <p>
 * To get the maximum profit/values, we need to find that in which case will get maximum profit, by picking the element
 * or by leaving the element
 *
 * @author VIVEK KUMAR SINGH
 * @since 21-01-2018
 */
public class ZeroOneKnapsack {

    /*
     * use to store the solutions of previously solved sub-problems into this table
     */
    private static int[][] lookupTable;

    /*
     * use to hold the both array of weights and their corresponding values
     */
    private static int[] weights;
    private static int[] values;

    /*
     * use to hold the size of weights
     */
    private static int n = 0;

    /*
     * use to hold the capacity of knapsack
     */
    private static int m = 0;

    private ZeroOneKnapsack() {
    }

    /**
     * Initialize the required variables
     *
     * @param w               weight array
     * @param v               values array
     * @param capacity        capacity of knapsack
     * @param isSpaceOptimize initialize the lookupTable according to optimize the space or not
     */
    private static void initialize(int[] w, int[] v, int capacity, boolean isSpaceOptimize) {
        weights = w;
        values = v;
        m = weights.length;
        n = capacity;

        /*
        * This if block will be use for space optimized version of Knapsack
        */
        if (isSpaceOptimize)
            lookupTable = new int[2][n + 1];
        else
            lookupTable = new int[m + 1][n + 1];
    }

    /**
     * Tabulated implementation of 0-1 Knapsack problem
     * <p>
     * TC: O(m*n), SC: O(m*n)
     *
     * @param w        weight array
     * @param v        values array
     * @param capacity capacity of knapsack
     *
     * @return maximum profit of knapsack
     */
    public static int maximumProfit(int[] w, int[] v, int capacity) {

        initialize(w, v, capacity, false);

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                /*
                * First row and column represent the empty sub-sequence of length 0 so we initialize them with 0
                * and also provide the value for the next sub-problems
                */
                if (i == 0 || j == 0)
                    lookupTable[i][j] = 0;
                else if (weights[i - 1] <= j)
                    lookupTable[i][j] = Math.max((values[i - 1] + lookupTable[i - 1][j - weights[i - 1]]), lookupTable[i - 1][j]);
                else
                    lookupTable[i][j] = lookupTable[i - 1][j];
            }
        }

        return lookupTable[m][n];
    }

    /**
     * Backtracking will work only with table of all rows, not for 2 rows tabulation technique used in Space
     * optimization
     *
     * @return Weights of Knapsack that will give the maximum profit
     */
    public static int[] getKnapsackWeights() {

        int i = m;
        int j = n;

        int[] knapsack = new int[m];

        while (i > 0 && j > 0) {
            if (lookupTable[i][j] != lookupTable[i - 1][j]) {
                knapsack[i - 1] = weights[i - 1];
                j -= weights[i - 1];
                i--;
            } else if (lookupTable[i - 1][j] > lookupTable[i][j - 1])
                i--;
            else
                j--;
        }

        return knapsack;
    }

    /**
     * As we observed in {@link ZeroOneKnapsack#maximumProfit(int[], int[], int)} that, in each iteration of outer loop
     * we only, need values from all columns of previous row
     * <p>
     * So there is no need to store all rows in matrix, we just need of 2 rows to get the length of LCS, but we can't
     * find the LCS by backtracking because we loose the memoization of all rows
     * <p>
     * TC: O(m*n), SC: O(n)
     *
     * @param w        weight array
     * @param v        values array
     * @param capacity capacity of knapsack
     *
     * @return maximum profit of knapsack
     */
    public static int maximumProfitBySpaceOptimize(int[] w, int[] v, int capacity) {

        initialize(w, v, capacity, true);

        /*
         * binary index used to index current row and previous row
         */
        int bi = 0;

        for (int i = 0; i <= m; i++) {

            /*
             * compute current binary index, by using bit and operator, if value of i is even
             */
            bi = i & 1;

            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    lookupTable[bi][j] = 0;
                else if (weights[i - 1] <= j)
                    lookupTable[bi][j] = Math.max((values[i - 1] + lookupTable[1 - bi][j - weights[i - 1]]), lookupTable[1 - bi][j]);
                else
                    lookupTable[bi][j] = lookupTable[1 - bi][j];
            }
        }

        return lookupTable[bi][n];
    }
}
