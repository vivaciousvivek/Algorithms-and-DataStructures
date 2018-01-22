package com.techfirebase.daa.algo.dp;

/**
 * Problem Statement:
 * <p>
 * Given coins of denomination Denomination={d1, d2,.... dk} (infinite number of each type i.e we can take one
 * denomination more than one) in increasing order(d1<d2<d3..<dk), Find minimum no. of coins required to pay N
 * Rupee/value, order of coins doesn't matter
 * <p>
 * Optimal Substructure:
 * <p>
 * There are 2 cases possible either we take the coin or doesn't
 * <p>
 * 1. If we take the coin: To get the minimum no. of coins, using the first j coins, required to pay first i
 * rupee/value.
 * <p>
 * entry = minimum no. of coins required; i = no. of coins; j = no. of rupee/value
 * <p>
 * CE(i,j) = 1 + CE(i,j-Denomination(i)) ; If Denomination(i) <= j
 * <p>
 * 2. If we don't take the coin:
 * <p>
 * CE(i,j) = CE(i-1,j) ; If Denomination(i) <= j
 * <p>
 * To get the minimum no. of coins, we need to find that in which case will get minimum no. of coins to pay j, by
 * picking that coin or by leaving that
 *
 * @author VIVEK KUMAR SINGH
 * @since 22-01-2018
 */
public class CoinExchange {

    /*
     * use to store the solutions of previously solved sub-problems into this table
     */
    private static int[][] lookupTable;

    /*
     * use to hold the denominations we have
     */
    private static int[] denominations;

    /*
     * use to hold the size of denominations array
     */
    private static int n = 0;

    /*
     * use to hold the quantity of Rupee/value
     */
    private static int m = 0;

    private CoinExchange() {
    }

    /**
     * Initialize the required variables
     *
     * @param deno            no. of denominations we have
     * @param rupee           how much money we need to exchange
     * @param isSpaceOptimize initialize the lookupTable according to optimize the space or not
     */
    private static void initialize(int[] deno, int rupee, boolean isSpaceOptimize) {
        denominations = deno;
        m = denominations.length;
        n = rupee;

        /*
        * This if block will be use for space optimized version of Knapsack
        */
        if (isSpaceOptimize)
            lookupTable = new int[2][n + 1];
        else
            lookupTable = new int[m + 1][n + 1];
    }

    /**
     * Tabulated implementation of Coin Exchange
     * <p>
     * TC: O(m*n), SC: O(m*n)
     *
     * @param deno no. of denominations we have
     * @param rupee how much money we need to exchange
     * @return minimum no. of coins to pay given rupee
     */
    public static int minimumCoins(int[] deno, int rupee) {

        initialize(deno, rupee, false);

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                /*
                * First row and column represent the empty sub-sequence of length 0 so we initialize them with 0
                * and also provide the value for the next sub-problems
                */
                if (i == 0 || j == 0)
                    lookupTable[i][j] = 0;
                else if (denominations[i] <= j)
                    lookupTable[i][j] = Math.max(1 + lookupTable[i][j - denominations[i]], lookupTable[i - 1][j]);
                else
                    lookupTable[i][j] = lookupTable[i - 1][j];
            }
        }

        return lookupTable[m][n];
    }
}
