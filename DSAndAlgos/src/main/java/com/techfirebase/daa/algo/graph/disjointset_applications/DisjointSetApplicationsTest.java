package com.techfirebase.daa.algo.graph.disjointset_applications;

import com.techfirebase.daa.ds.advance_ds.disjointset.DisjointSet;
import com.techfirebase.daa.ds.advance_ds.graph.EdgeListGraph;

/**
 * @author VIVEK KUMAR SINGH
 * @since 18-01-2018
 */
public class DisjointSetApplicationsTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("*************Cycle Detection of Undirected Graph by Disjoint Set*************\n");
		/*
		 * First Graph
		 */
		EdgeListGraph edgeListGraph = new EdgeListGraph(3, 3);

		// Add first edge
		edgeListGraph.addEdge(1, 0, 1);

		// Add second edge
		edgeListGraph.addEdge(2, 1, 2);

		// Add third edge
		edgeListGraph.addEdge(3, 0, 2);
		
		/*
		 * Second Graph
		 */
		/*EdgeListGraph edgeListGraph = new EdgeListGraph(4, 3);

		// Add first edge
		edgeListGraph.addEdge(1, 0, 1);

		// Add second edge
		edgeListGraph.addEdge(2, 1, 3);

		// Add third edge
		edgeListGraph.addEdge(3, 0, 2);*/
		
		sb.append("\n*************(((Edge List graph)))*************\n");
		sb.append(edgeListGraph);
		System.out.println(sb);
		sb.delete(0, sb.length());
		
		sb.append("\nHas Cycle ?\n");
		if (CycleDetectionByDisjointSet.hasCycle(edgeListGraph)) {
			sb.append("\n Yes");
		} else {
			sb.append("\n No");
		}
		
		sb.append("\n\nDisjoint set after fast union and find\n");
        sb.append(DisjointSet.printDisjointSet());
		System.out.println(sb);
	}

}
