package com.techfirebase.daa.ds.advance_ds.disjointset;

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
		 * Find the representative(root) of element1 and element2
		 */
		int element1Rep = slowFind(element1);
		int element2Rep = slowFind(element2);
		
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
			 */
			
			int result = fastFind(parent[element]);
			
			/**
			 *  We cache the result by moving i’s node directly under the representative of this set
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
	public static void fastUnion(int element1, int element2) {
		/**
		 * Find the representative(root) of element1 and element2
		 */
		int element1Rep = slowFind(element1);
		int element2Rep = slowFind(element2);
		
		/**
		 * Make element2's representative as a parent of element1's representative(root)
		 */
		parent[element1Rep] = element2Rep;
	}
	
}
