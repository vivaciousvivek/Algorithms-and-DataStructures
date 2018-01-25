package com.techfirebase.daa.algo.dp;

/**
 * Problem Statement:
 * <p>
 * Given sequence, compute the length of longest palindrome sub-sequence
 * <p>
 * For example:
 * <p>
 * if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic
 * sub-sequence in it. “BBBBB” and “BBCBB” are also palindromic sub-sequences of the given sequence, but not the longest
 * ones.
 * <p>
 * Optimal Substructure:
 * <p>
 * We'll start by checking first and the last character of the given sequence, then there will be 2 case possible,
 * either they are equal or not, if the are equal then they will make the palindromic sub-sequence otherwise not.
 * <p>
 * 1. If first and the last character of some sequence is same:
 * <p>
 * entry=length of palindromic sub-sequence; i=first character of some length sub-sequence; j=last character of some
 * length sub-sequence
 * <p>
 * if first and the last character is same then their length will be 2(i.e one for each)
 * <p>
 * if we are comparing character to itself then the longest palindromic sequence we can have: LPS(i,i) = 1;
 * <p>
 * LPS(i,j) = 2 + LPS(i+1,j-1); if x(i) = y(i)
 * <p>
 * 2. If first and the last character of some sequence is not same:
 * <p>
 * LPS(i,j) = Max[LPS(i+1,j), LPS(i,j-1)]; if x(i) != y(i)
 *
 * @author VIVEK KUMAR SINGH
 * @since 23-01-2018
 */
public class LongestPalindromeSubsequence {

    /*
     * use to store the solutions of previously solved sub-problems into this table
     */
    private static int[][] lookupTable;

    /*
     * use to hold the given sequences
     */
    private static String str1;

    /*
     * use to hold the size of both sequences
     */
    private static int m = 0;

    private LongestPalindromeSubsequence() {}

    private static void initialize(String s1, boolean isSpaceOptimize) {
        str1 = s1;
        m = str1.length();

        /*
        * This if block will be use for space optimized version of LPS
        */
        if (isSpaceOptimize)
            lookupTable = new int[2][m];
        else
            lookupTable = new int[m][m];
    }

    /**
     * Tabulated implementation for the LPS problem
     * <p>
     * TC: O(m^2), SC: O(m^2)
     *
     * @param s1 sequence
     *
     * @return length of LPS
     */
    public static int lengthOfLPS(String s1) {

        initialize(s1, false);

        /*
         * Length of LPS will be 1, when there is single character
         */
        for (int i = 0; i < m; i++) {
            lookupTable[i][i] = 1;
        }

        /*
         * len is the Length of sub-sequence, start from 2 as we already computed the one length entries
         */
        for (int len = 2; len <= m; len++) {
            for (int i = 0; i < m - len + 1; i++) {
                int j = i + len - 1;
                /*
                * First row and column represent the empty sub-sequence of length 0 so we initialize them with 0
                * and also provide the value for the next sub-problems
                */
                if (str1.charAt(i) == str1.charAt(j))
                    lookupTable[i][j] = 2 + lookupTable[i + 1][j - 1];
                else
                    lookupTable[i][j] = Math.max(lookupTable[i + 1][j], lookupTable[i][j - 1]);
            }
        }

        return lookupTable[0][m - 1];
    }

    public static char[] getLPS() {
        int i = 0;
        int j = m - 1;

        char[] lps = new char[m];

        while (j > 0) {
            /*
             * put matched character into lps
             */
            if ((lookupTable[i][j] != lookupTable[i + 1][j]) && (lookupTable[i][j] != lookupTable[i][j - 1])) {
                lps[i] = str1.charAt(i);
                lps[j] = str1.charAt(j);
                i++;
                j--;

             /*
             * If character is not same then go in the direction of larger value
             */
            } else if (lookupTable[i + 1][j] > lookupTable[i][j - 1])
                i++;
            else
                j--;
        }

        return lps;
    }
}
