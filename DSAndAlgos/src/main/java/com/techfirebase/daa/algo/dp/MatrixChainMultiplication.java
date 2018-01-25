package com.techfirebase.daa.algo.dp;

/**
 * Problem Statement:
 * <p>
 * Given certain no. of matrices, in which order we should multiply so that the cost of multiplication is minimum.
 * <p>
 * We have many options to multiply a chain of matrices because matrix multiplication is associative.
 * <p>
 * For example, if we had four matrices A, B, C, and D, we would have n-1 ways to multiply them: (ABC)D = (AB)(CD) =
 * A(BCD)
 * <p>
 * So the final result will be the same, but we can minimize the cost of multiplication
 * <p>
 * For example:
 * <p>
 * ---------------------------------------------------------------------------------
 * 	 0		  1		  2		  3
 * [2,3]	[3,6]	[6,4]	[4,5]
 *
 * 1. (0*1)(2*3)	=	2*3*6 + 6*4*5 + 2*6*5	=	216
 * 2. ((0*1*2)*3)	=	2*3*6 + 2*6*4 + 2*4*5	=	124
 * 3. (0*(1*2*3))	=	3*6*4 + 3*4*5 + 2*3*5	=	152
 * ---------------------------------------------------------------------------------
 * <p>
 * So here we can see the cost of the multiplication with second way is cost effective, so we need to find this
 * <p>
 * Optimal Substructure:
 * <p>
 * MCM(i,j) = Minimum of(MCM(i,k) + MCM(k+1,j) + dimensions[i-1]*dimensions[k]*dimensions[j]) - minimum of every first split combinations of n matrices
 * 
 * entry: minimum cost of first i and j matrices multiplication, i: first ith matrices, j: first jth matrices, k: splits of first n numbers (n-1 split possible for every combination) 
 * 
 * To calculate the minimum cost
 *
 * @author VIVEK KUMAR SINGH
 * @since 24-01-2018
 */
public class MatrixChainMultiplication {
    /*
     * use to store the solutions of previously solved sub-problems into this table
     */
    private static int[][] lookupTable;

    /*
     * use to hold the given dimensions of matrices
     */
    private static int[] p;
    
    /*
     * use to backtrack to find matrices with minimum cost
     */
    private static int[][] backtrack;

    /*
     * use to hold the size of both sequences
     */
    private static int m = 0;

    private MatrixChainMultiplication() {
    }

    private static void initialize(int[] dimensions, boolean isSpaceOptimize) {
        p = dimensions;
        m = p.length - 1;

        /*
        * This if block will be use for space optimization
        */
        if (isSpaceOptimize)
            lookupTable = new int[2][m];
        else {
            lookupTable = new int[m][m];
            backtrack = new int[m][m];
        }
    }

    /**
     * 
     * TC: O(n^3) - as there are n^2 entries we need to compute and to compute every entry O(n) time is taken
     * (for every entry we need to split it into n-1 partitions) 
     * 
     * SC: O(n^2)
     * 
     * @param dimensions
     *
     * @return
     */
    public static int minimumCostOfMCM(int[] dimensions) {
        initialize(dimensions, false);

        /*
         * Cost will be zero, when there is single matrix multiply
         *
         * No need of for loop as 0 is the default value of int
         */
        /*for (int i = 0; i < m; i++) {
            lookupTable[i][i] = 0;
        }*/

        /*
         * To use this please change the length of lookup table from length-1 to length.
         *
         * This code will waste some space of lookup table
         */
        /*for (int len = 2; len < m; len++) {
            for (int i = 0; i < m - len; i++) {
                int j = i + len;

                if (j == m) continue;
                lookupTable[i][j] = Integer.MAX_VALUE;

                *//*
                 * K is split from where we split the array of matrix to multiply from i....k.....j
                 *
                 * maximum split possible from 1 to n-1(i.e if we have 4 matrices then we can split it from 1-3
                 *//*
                for (int k = i + 1; k < j; k++) {
                    lookupTable[i][j] = Math.min(lookupTable[i][k] + lookupTable[k][j] + p[i] * p[k] * p[j], lookupTable[i][j]);
                }
            }
        }*/

        /*
         * len is the Length of matrices we are taking to multiply different ways, start from 2 as we already computed the one length entries
         */
        for (int len = 2; len <= m; len++) {
            for (int i = 1; i < m - len + 2; i++) {
                int j = i + len - 2;

                lookupTable[i - 1][j] = Integer.MAX_VALUE;

                /*
                 * K is split from where we split the array of matrix to multiply from i....k.....j
                 *
                 * maximum split possible from 1 to n-1(i.e if we have 4 matrices then we can split it from 1-3
                 */
                for (int k = i; k <= j; k++) {
//                    lookupTable[i-1][j] = Math.min(lookupTable[i-1][k-1] + lookupTable[k][j] + p[i-1] * p[k] * p[j+1], lookupTable[i-1][j]);
                	int q = lookupTable[i-1][k-1] + lookupTable[k][j] + p[i-1] * p[k] * p[j+1];
                	if(q < lookupTable[i-1][j]) {
                		lookupTable[i-1][j] = q;
                		backtrack[i-1][j] = k;
                	}
                }
            }
        }

        return lookupTable[0][m - 1];
    }
}
