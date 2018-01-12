package com.techfirebase.daa.algo.graph.dfs_applications;

import com.techfirebase.daa.ds.advance_ds.graph.AdjacencyList;
import com.techfirebase.daa.ds.advance_ds.graph.Graph;

/**
 * @author VIVEK KUMAR SINGH
 * @since 12-01-2017
 */
public class DFSApplicationsTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("*************Graph Test*************\n");
		sb.append("\n*************DFS Applications*************\n");
		sb.append("\n*************Undirected Graph*************\n");

		int V = 5;
        Graph graph = new Graph(V);

        AdjacencyList.addEdge(graph, 0, 1);
        AdjacencyList.addEdge(graph, 0, 4);
        AdjacencyList.addEdge(graph, 1, 2);
        AdjacencyList.addEdge(graph, 1, 3);
        AdjacencyList.addEdge(graph, 1, 4);
        AdjacencyList.addEdge(graph, 2, 3);
        AdjacencyList.addEdge(graph, 3, 4);

//        AdjacencyList.addEdge(graph, 1, 0);
//        AdjacencyList.addEdge(graph, 0, 2);
//        AdjacencyList.addEdge(graph, 2, 1);
//        AdjacencyList.addEdge(graph, 0, 3);
//        AdjacencyList.addEdge(graph, 3, 4);

        sb.append(graph);

        sb.append("\n\n*************Cycle Detection*************\n");
        System.out.println(sb);
        
        CycleDetectionByDFS cycleDFS = new CycleDetectionByDFS(graph);
        cycleDFS.cycleUtil();
	}

}
