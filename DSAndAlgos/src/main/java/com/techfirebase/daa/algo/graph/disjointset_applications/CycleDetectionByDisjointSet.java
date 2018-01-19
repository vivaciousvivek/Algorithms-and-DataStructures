package com.techfirebase.daa.algo.graph.disjointset_applications;

import com.techfirebase.daa.ds.advance_ds.disjointset.DisjointSet;
import com.techfirebase.daa.ds.advance_ds.graph.EdgeListGraph;

/**
 * @author VIVEK KUMAR SINGH
 * @since 16-01-2018
 */

/**
 * To Detect Cycle only in undirected graph we can use Disjoint Set(fast union and find), its
 * TC[O(logE)] is less than the TC[O(V + E)] of BFS and DFS
 * 
 */
public class CycleDetectionByDisjointSet {
	
	private CycleDetectionByDisjointSet() {}

	public static boolean hasCycle(EdgeListGraph edgeListGraph) {
		StringBuilder sb = new StringBuilder();

		// making set of vertices
		DisjointSet.makeSet(edgeListGraph.getV());
		
		sb.append("\n*************Disjoint Set*************\n");
		sb.append(DisjointSet.printDisjointSet());
		System.out.println(sb);
		/*
		 * Iterate through all the edges of given edge list graph, find the subset of
		 * both the vertices of every edge,
		 * 
		 * If both the subset are same then there is a cycle otherwise not
		 */
		for (int i = 0; i < edgeListGraph.getE(); i++) {
			if (edgeListGraph.getEdge()[i] != null) {
				int srcVertex = DisjointSet.fastFind(edgeListGraph.getEdge()[i].getSrc());
				int destVertex = DisjointSet.fastFind(edgeListGraph.getEdge()[i].getDest());
				
				/*
				 * If both the representative belongs to same set then there is a cycle
				 */
				if (srcVertex == destVertex)
					return true;
				
				DisjointSet.fastUnion(srcVertex, destVertex);
			}
		}
		
		return false;
	}
}
