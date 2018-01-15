package com.techfirebase.daa.algo.graph;

import com.techfirebase.daa.ds.advance_ds.graph.AdjacencyList;
import com.techfirebase.daa.ds.advance_ds.graph.Graph;
import com.techfirebase.daa.utils.constants.GraphType;

/**
 * 
 * @author VIVEK KUMAR SINGH
 * @since 13-01-2018
 */

public class GraphObjects {

	private static Graph graph;

	private GraphObjects() {
	}

	// 5 vertex graph
	public static Graph undirectedGraphOne() {
		graph = new Graph(5);

		AdjacencyList.addEdge(graph, 0, 1);
		AdjacencyList.addEdge(graph, 0, 4);
		AdjacencyList.addEdge(graph, 1, 2);
		AdjacencyList.addEdge(graph, 1, 3);
		AdjacencyList.addEdge(graph, 1, 4);
		AdjacencyList.addEdge(graph, 2, 3);
		AdjacencyList.addEdge(graph, 3, 4);

		return graph;
	}

	// 5 vertex graph
	public static Graph undirectedGraphTwo() {
		graph = new Graph(5);

		AdjacencyList.addEdge(graph, 1, 0);
		AdjacencyList.addEdge(graph, 0, 2);
		AdjacencyList.addEdge(graph, 2, 1);
		AdjacencyList.addEdge(graph, 0, 3);
		AdjacencyList.addEdge(graph, 3, 4);

		return graph;
	}

	// 5 vertex graph
	public static Graph undirectedGraphThree() {
		graph = new Graph(5);

		AdjacencyList.addEdge(graph, 1, 3);
		AdjacencyList.addEdge(graph, 1, 4);
		AdjacencyList.addEdge(graph, 4, 3);
		AdjacencyList.addEdge(graph, 1, 0);
		AdjacencyList.addEdge(graph, 0, 2);

		return graph;
	}

	// *************************************Directed
	// Graphs******************************

	// 5 vertex graph
	public static Graph directedGraphOne() {
		graph = new Graph(5, GraphType.DIRECTED);

		AdjacencyList.addEdge(graph, 0, 1);
		AdjacencyList.addEdge(graph, 0, 4);
		AdjacencyList.addEdge(graph, 1, 2);
		AdjacencyList.addEdge(graph, 1, 3);
		AdjacencyList.addEdge(graph, 1, 4);
		AdjacencyList.addEdge(graph, 2, 3);
		AdjacencyList.addEdge(graph, 3, 4);

		return graph;
	}

	// 5 vertex graph
	public static Graph directedGraphTwo() {
		graph = new Graph(5, GraphType.DIRECTED);

		AdjacencyList.addEdge(graph, 0, 1);
		AdjacencyList.addEdge(graph, 0, 2);
		AdjacencyList.addEdge(graph, 1, 2);
		AdjacencyList.addEdge(graph, 2, 0);
		AdjacencyList.addEdge(graph, 2, 3);
		AdjacencyList.addEdge(graph, 3, 3);

		return graph;
	}

	// 5 vertex graph
	public static Graph directedGraphThree() {
		graph = new Graph(5, GraphType.DIRECTED);

		AdjacencyList.addEdge(graph, 0, 1);
		AdjacencyList.addEdge(graph, 0, 2);
		AdjacencyList.addEdge(graph, 2, 1);
		AdjacencyList.addEdge(graph, 2, 3);
		AdjacencyList.addEdge(graph, 3, 0);

		return graph;
	}

	// *************************************Directed Weighted
	// Graphs******************************

	public static Graph directedWeightedGraphOne() {
		graph = new Graph(5, GraphType.DIRECTED);

		AdjacencyList.addEdge(graph, 0, 1, 3);
		AdjacencyList.addEdge(graph, 0, 4, 6);
		AdjacencyList.addEdge(graph, 1, 2, 9);
		AdjacencyList.addEdge(graph, 1, 3, 3);
		AdjacencyList.addEdge(graph, 1, 4, 2);
		AdjacencyList.addEdge(graph, 2, 3, 2);
		AdjacencyList.addEdge(graph, 3, 4, 1);

		return graph;
	}

	// 5 vertex graph
	public static Graph directedWeightedGraphTwo() {
		graph = new Graph(5, GraphType.DIRECTED);

		// need to create

		// AdjacencyList.addEdge(graph, 0, 1, 3);
		// AdjacencyList.addEdge(graph, 0, 4, 6);
		// AdjacencyList.addEdge(graph, 1, 2, 9);
		// AdjacencyList.addEdge(graph, 1, 3, 3);
		// AdjacencyList.addEdge(graph, 1, 4, 2);
		// AdjacencyList.addEdge(graph, 2, 3, 2);
		// AdjacencyList.addEdge(graph, 3, 4, 1);

		return graph;
	}

	// 5 vertex graph
	public static Graph directedWeightedGraphThree() {
		graph = new Graph(5, GraphType.DIRECTED);

		// need to create

		// AdjacencyList.addEdge(graph, 0, 1, 3);
		// AdjacencyList.addEdge(graph, 0, 4, 6);
		// AdjacencyList.addEdge(graph, 1, 2, 9);
		// AdjacencyList.addEdge(graph, 1, 3, 3);
		// AdjacencyList.addEdge(graph, 1, 4, 2);
		// AdjacencyList.addEdge(graph, 2, 3, 2);
		// AdjacencyList.addEdge(graph, 3, 4, 1);

		return graph;
	}
}
