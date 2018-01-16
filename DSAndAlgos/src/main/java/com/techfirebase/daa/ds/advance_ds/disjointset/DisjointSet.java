package com.techfirebase.daa.ds.advance_ds.disjointset;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author VIVEK KUMAR SINGH
 * @since 15-01-2018
 */

/**
 * Disjoint set(virtually represents tree) is a data structure it will applied when 
 * 
 * It has two operations:
 * 1. Find - Can be implemented by recursively traversing the parent array until 
 * 			 we hit a node who is parent of itself.
 * 2. Union - Merging root node of two disjoint trees\sets.
 * 
 * There are two ways to implement Disjoint set:
 * 1. Array
 * 2. Tree
 * 
 * This is a Disjoint Array Set
 */
public class DisjointSet {

	/**
	 * We are creating virtual tree structures using this array, that can be understand as
	 * i'th element of parent array is actually the parent of i'th element
	 */
	private static int[] parent;
	
	/**
	 * this array will be very useful for (Path Compression) when we want to compress the 
	 * rank(height, weight) of the tree, this will reduce the TC O(n) [given by normal Find-Union]
	 * to O(logn)
	 */
	private static int[] rank;

	private DisjointSet(){}
	
	public static void makeSet(int size) {
		parent = new int[size];
		rank = new int[size];
		
		parent = IntStream.range(0, size).toArray();
	}

	/**
	 * To Find the representative(root) of given element in its subset 
	 * 
	 * O(n) WTC - because of skew tree
	 * 
	 * @param element
	 * @return representative(root) of subset 
	 */
	public static int slowFind(int element) {
		/**
		 * If element is a parent of itself,
		 * then this element is the representative(root) of set
		 */
		if (parent[element] == element) {
			
			return element;
		} else {
			/**
			 * If element is not a parent of itself,
			 * then we need to find its parent recursively 
			 */
			
			return slowFind(parent[element]);
		}
	}
	
	/**
	 * To merge(union) of two disjoint sets
	 * 
	 * O(n) WTC - because of skew tree
	 * 
	 * @param element1
	 * @param element2
	 * @return parent array of elements after performing union
	 */
	public static int[] slowUnion(int element1, int element2) {
		/**
		 * Find the representatives(root) of element1 and element2
		 */
		int element1Rep = slowFind(element1);
		int element2Rep = slowFind(element2);

		/**
		 * If elements are in the same set, then no need to unite them
		 */
		if (element1Rep == element2Rep)
			return parent;

		/**
		 * Make element2's representative as a parent of element1's representative(root)
		 */
		parent[element1Rep] = element2Rep;

		return parent;
	}
	
	/**
	 * To Find the representative(root) of given element in its subset by applying 
	 * path compression(by compressing the height of the tree)
	 * 
	 * O(logn) WTC - because we are compressing the height of the tree by 
	 * minimum rank approach
	 * 
	 * @param element
	 * @return representative(root) of subset
	 */
	public static int fastFind(int element) {
		/**
		 * If element is a parent of itself,
		 * then this element is the representative(root) of set
		 */
		if (parent[element] == element) {
			
			return element;
		} else {
			/**
			 * If element is not a parent of itself,
			 * then we need to find its parent recursively
			 *
			 * Here We caching the result of find
			 */
			int result = fastFind(parent[element]);
			
			/**
			 *  by moving the representative of this element directly
			 *  under the representative of find above set to compress(minimize)
			 *  the height of the tree
			 */
			parent[element] = result;

			return result;
		}
	}
	
	/**
	 * To merge(union) of two disjoint sets by applying 
	 * path compression(by compressing the height of the tree)
	 * 
	 * O(logn) WTC - because we are compressing the height of the tree by 
	 * minimum rank approach
	 * 
	 * @param element1
	 * @param element2
	 * @return parent array of elements after performing union
	 */
	public static int[] fastUnion(int element1, int element2) {
		/**
		 * Find the representatives(root) of element1 and element2
		 */
		int element1Rep = fastFind(element1);
		int element2Rep = fastFind(element2);

		/**
		 * If elements are in the same set, then no need to unite them
		 */
		if (element1Rep == element2Rep)
			return parent;

		/**
		 * If rank of element1's tree is less than the rank of element2's tree,
		 * then we can't decrease the rank of greater tree, but if we make
		 * representative(root) to smaller tree then we will increase its height(rank)
		 *
		 * so attach smaller rank tree under root of higher rank tree
		 */
		if (rank[element1] < rank[element2]) {
			parent[element1] = element2;
		} else if (rank[element2] < rank[element1]) {
			parent[element2] = element1;
		} else {
			/**
			 * If rank is similar then make one as root and increase its rank by one
			 */
			parent[element1] = element2;
			rank[element2]++;
		}

		return parent;
	}

	public static String printDisjointSet() {
		return "DisjointSet{" +
				"parent=" + Arrays.toString(parent) +
				", rank=" + Arrays.toString(rank) +
				"}";
	}
}
