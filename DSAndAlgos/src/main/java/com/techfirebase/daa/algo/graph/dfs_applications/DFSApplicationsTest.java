package com.techfirebase.daa.algo.graph.dfs_applications;

import com.techfirebase.daa.algo.graph.GraphObjects;
import com.techfirebase.daa.ds.advance_ds.graph.Graph;

/**
 * @author VIVEK KUMAR SINGH
 * @since 12-01-2017
 */
public class DFSApplicationsTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		sb.append("*************DFS Applications Test*************\n");
		sb.append("\n*************(((Undirected Graph)))*************\n");
		// use other graph objects to test more
		Graph undirectedGraph = GraphObjects.undirectedGraphOne();
		sb.append(undirectedGraph);
		System.out.println(sb);
		sb.delete(0, sb.length());

		sb.append("\n\n*************Cycle Detection*************\n");
		System.out.println(sb);
		sb.delete(0, sb.length());

		CycleDetectionByDFS cycleDFS = new CycleDetectionByDFS(undirectedGraph);
		cycleDFS.cycleUtil();

		sb.append("\n\n*************(((Directed Graph)))*************\n");
		// use other graph objects to test more
		Graph directedGraph = GraphObjects.directedGraphOne();
		sb.append(directedGraph);
		System.out.println(sb);
		sb.delete(0, sb.length());

		sb.append("\n\n*************Cycle Detection*************\n");
		System.out.println(sb);
		sb.delete(0, sb.length());

		CycleDetectionByDFS cycleDFS1 = new CycleDetectionByDFS(directedGraph);
		cycleDFS1.cycleUtil();

	}

}
