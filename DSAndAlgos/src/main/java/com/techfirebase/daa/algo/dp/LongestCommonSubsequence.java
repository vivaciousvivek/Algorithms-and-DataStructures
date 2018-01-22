package com.techfirebase.daa.algo.dp;

/**
 * Problem Statement:
 * <p>
 * We need to find the longest common sub-sequence(sequence that appear in the same relative order, but need not
 * necessarily contiguous) of given two sequence
 * <p>
 * Naive(brute force) solution of the problem is we need to find all sub-sequence of both given sequence, and find the
 * longest among them
 * <p>
 * TC: O(2^n)
 * <p>
 * DP: to solve this problem we need to identify two properties of DP 1. Optimal Substructure 2. Overlapping
 * Sub-problems
 * <p>
 * 1. We can break this problem into such recursive manner that if any character is matches then either it came from its
 * previously solved sub-problems or itself
 * <p>
 * or if not matches then we need to traverse recursively of left and right subtrees and find the maximum(as we need to
 * find maximum sub-sequence) of sub-sequence of both side tree at every level
 * <p>
 * 2. If we draw the recursive tree then we can clearly see that most of the sub-problems are repeating so we need to
 * store them into the lookup table to reuse their values for their super problems
 * <p>
 * <p>
 * Another problem - EditDistance is similar to this, except we need to find those characters that are not in the same
 * index in both sequence
 *
 * @author VIVEK KUMAR SINGH
 * @since 20-01-2018
 */
public class LongestCommonSubsequence {

    /*
     * use to store the solutions of previously solved sub-problems into this table
     */
    private static int[][] lookupTable;

    /*
     * use to hold the both sequences
     */
    private static String str1;
    private static String str2;

    /*
     * use to hold the size of both sequences
     */
    private static int n = 0;
    private static int m = 0;

    private LongestCommonSubsequence() {
    }

    /**
     * Initialize the required variables
     *
     * @param s1              first sequence
     * @param s2              second sequence
     * @param isSpaceOptimize initialize the lookupTable according to optimize the space or not
     */
    private static void initialize(String s1, String s2, boolean isSpaceOptimize) {
        str1 = s1;
        str2 = s2;
        m = str1.length();
        n = str2.length();

        /*
        * This if block will be use for space optimized version of LCS
        */
        if (isSpaceOptimize)
            lookupTable = new int[2][n + 1];
        else
            lookupTable = new int[m + 1][n + 1];
    }

    /**
     * Tabulated implementation for the LCS problem
     * <p>
     * TC: O(m*n), SC: O(m*n)
     *
     * @param s1 first sequence
     * @param s2 second sequence
     *
     * @return length of LCS
     */
    public static int lengthOfLCS(String s1, String s2) {

        initialize(s1, s2, false);

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                /*
                * First row and column represent the empty sub-sequence of length 0 so we initialize them with 0
                * and also provide the value for the next sub-problems
                */
                if (i == 0 || j == 0)
                    lookupTable[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];
                else
                    lookupTable[i][j] = Math.max(lookupTable[i - 1][j], lookupTable[i][j - 1]);
            }
        }

        return lookupTable[m][n];
    }

    /**
     * Backtracking will work only with table of all rows, not for 2 rows tabulation technique used in Space
     * optimization
     *
     * @return Longest Common Sub-sequence
     */
    public static char[] getLCS() {
        int i = m;
        int j = n;

        /*
         * Index will be the length of LCS
         */
        int index = lookupTable[m][n];

        /*
         * Store the LCS
         */
        char[] lcs = new char[index];

        while (i > 0 && j > 0) {
            /*
             * put matched character into lcs
             */
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs[index - 1] = str1.charAt(i - 1);

                i--;
                j--;
                index--;

            /*
             * If character is not same then go in the direction of larger value
             */
            } else if (lookupTable[i - 1][j] > lookupTable[i][j - 1])
                i--;
            else
                j--;

        }

        return lcs;
    }

    /**
     * As we observed in {@link LongestCommonSubsequence#lengthOfLCS(String, String)} that, in each iteration of outer
     * loop we only, need values from all columns of previous row
     * <p>
     * So there is no need to store all rows in matrix, we just need of 2 rows to get the length of LCS, but we can't
     * find the LCS by backtracking because we loose the memoization of all rows
     * <p>
     * TC: O(m*n), SC: O(n)
     *
     * @param str1
     * @param str2
     *
     * @return length of LCS
     */
    public static int lengthOfLCSBySpaceOptimize(String str1, String str2) {

        initialize(str1, str2, true);

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
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    lookupTable[bi][j] = 1 + lookupTable[1 - bi][j - 1];
                else
                    lookupTable[bi][j] = Math.max(lookupTable[1 - bi][j], lookupTable[bi][j - 1]);
            }
        }

        return lookupTable[bi][n];
    }
}
