package com.techfirebase.daa.algo.graph.traversals;

import com.techfirebase.daa.algo.graph.GraphObjects;
import com.techfirebase.daa.ds.advance_ds.graph.Graph;

/**
 * @author VIVEK KUMAR SINGH
 * @since 19-12-2017
 */
public class TraversalTest {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		sb.append("*************Traversal Test*************\n");
		
		sb.append("\n\n*************Undirected Graph*************\n");
		Graph undirectedGraph = GraphObjects.undirectedGraphOne();
		sb.append(undirectedGraph);
		System.out.println(sb);
		sb.delete(0, sb.length());
		
		sb.append("\n*************(((BFS Traversal)))*************\n");
		System.out.println(sb);
		sb.delete(0, sb.length());
		
		BFS bfs = new BFS(undirectedGraph);
		bfs.BFSTraversal(0);
		bfs.printPiArray();

		sb.append("\n*************(((DFS Traversal)))*************\n");
		System.out.println(sb);
		sb.delete(0, sb.length());

		DFS dfs = new DFS(undirectedGraph, 0);
		dfs.DFSTraversal(0);
		dfs.printPiArray();

		sb.append("\n\n*************Directed Graph*************\n");
		Graph directedGraph = GraphObjects.directedGraphOne();
		sb.append(directedGraph);
		System.out.println(sb);
		sb.delete(0, sb.length());
	}
}
