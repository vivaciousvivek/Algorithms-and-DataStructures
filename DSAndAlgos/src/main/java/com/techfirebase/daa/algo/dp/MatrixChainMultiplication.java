package com.techfirebase.daa.algo.dp;

/**
 * Problem Statement:
 * 
 * Given certain no. of matrices, in which order we should multiply so that the cost of multiplication is minimum.
 * 
 * We have many options to multiply a chain of matrices because matrix multiplication is associative.
 * 
 * For example, if we had four matrices A, B, C, and D, we would have n-1 ways to multiply them:
 * (ABC)D = (AB)(CD) = A(BCD)
 * 
 * So the final result will be the same, but we can minimize the cost of multiplication
 * 
 * For example:
 * 
 * ---------------------------------------------------------------------------------
 * 	 0		  1		  2		  3
 * [2,3]	[3,6]	[6,4]	[4,5]
 * 
 * 1. (0*1)(2*3)	=	2*3*6 + 6*4*5 + 2*6*5	=	216
 * 2. ((0*1*2)*3)	=	2*3*6 + 2*6*4 + 2*4*5	=	124
 * 3. (0*(1*2*3))	=	3*6*4 + 3*4*5 + 2*3*5	=	152
 * ---------------------------------------------------------------------------------
 * 
 * So here we can see the cost of the multiplication with second way is cost effective, so we need to find this
 * 
 * Optimal Substructure:
 * 
 * To calculate the minimum cost
 * 
 * 
 * @author VIVEK KUMAR SINGH
 * @since 24-01-2018
 */
public class MatrixChainMultiplication {

}
