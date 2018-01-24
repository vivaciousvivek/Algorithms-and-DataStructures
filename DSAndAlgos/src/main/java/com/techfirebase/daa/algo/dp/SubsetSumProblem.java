package com.techfirebase.daa.algo.dp;

/**
 * Problem Statement:
 * <p>
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal
 * to given sum.
 * <p>
 * Optimal Substructure:
 * <p>
 * There are 2 cases possible either we take the element(integer) or don't
 * <p>
 * 1. If we take the element(integer): To check whether there is sum possible, by using the first i no., to have sum j.
 * <p>
 * entry = True or False; i = no. of elements in set/array; j = first jth sum
 * <p>
 * SS(i,j) = T + SS(i-1,j-Number(i)) ; If Number(i) <= j
 * <p>
 * 2. If we don't take the element(integer):
 * <p>
 * SS(i,j) = SS(i-1,j) ; If Number(i) <= j
 * <p>
 * Using first i no. whether it is possible to have sum j
 *
 * @author VIVEK KUMAR SINGH
 * @since 23-01-2018
 */
public class SubsetSumProblem {

    /*
     * use to store the solutions of previously solved sub-problems into this table
     */
    private static boolean[][] lookupTable;

    /*
     * use to store the solutions of previously solved sub-problems into this One D array and 
     * second array will be used for backtrack the result for One D array
     */
    private static boolean[] lookup;
    private static int[] backtrack;

    /*
     * use to hold the values of pieces of rod
     */
    private static int[] numbers;

    /*
     * use to hold the size of values array
     */
    private static int m = 0;

    /*
     * use to hold Length of given road to cut
     */
    private static int n = 0;

    private SubsetSumProblem() {
    }

    /**
     * @param num
     * @param sum
     * @param isSpaceOptimize
     */
    private static void initialize(int[] num, int sum, boolean isSpaceOptimize) {
        numbers = num;
        m = num.length;
        n = sum;

        /*
        * This if block will be use for space optimized version of Knapsack
        */
        if (isSpaceOptimize) {
            lookup = new boolean[n + 1];
            backtrack = new int[n + 1];
        } else
            lookupTable = new boolean[m + 1][n + 1];
    }

    /**
     * @param num
     * @param s
     *
     * @return
     */
    public static boolean isSubsetSum(int[] num, int s) {
        initialize(num, s, false);

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                /*
                * First row and column represent the empty sub-sequence of length 0 so we initialize them with 0
                * and also provide the value for the next sub-problems
                */
                if (i != 0 && j == 0)
                    lookupTable[i][j] = true;
                else if ((i == 0 && j == 0) || (i == 0 && j != 0))
                    lookupTable[i][j] = false;
                else if (numbers[i - 1] <= j)
                    lookupTable[i][j] = lookupTable[i - 1][j - numbers[i - 1]] || lookupTable[i - 1][j];
                else
                    lookupTable[i][j] = lookupTable[i - 1][j];
            }
        }

        return lookupTable[m][n];
    }

}
