package com.techfirebase.daa.algo.graph.dfs_applications;

/**
 * @author VIVEK KUMAR SINGH
 * @since 10-01-2018
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

import com.techfirebase.daa.ds.advance_ds.graph.Graph;
import com.techfirebase.daa.utils.constants.VisitingColor;

/**
 * We can use DFS to detect cycle in graph(undirected & directed both)
 * <ul>
 * <li>Once DFS finds a cycle, the stack will contain the nodes forming the
 * cycle.</li>
 * <li>The same is not true for BFS, so you need to do extra work if you want to
 * print the found cycle. This makes DFS a lot more convenient.</li>
 * <li>Depth first search is more memory efficient than breadth first search as
 * you can backtrack sooner.</li>
 * </ul>
 */
public class CycleDetectionByDFS {
	/*
	 * use it to color the vertices, we can also use boolean array here but these
	 * three colors will be very useful in Dijkstra’s algo
	 */
	private char[] visited;

	/*
	 * pi(parent info) array will use to get the parent info after each traversal
	 */
	private int[] piArray;

	/*
	 * these arrays will be used to store when the vertex is pushed into and popped
	 * from stack
	 */
	private int[] discoverTime;
	private int[] finishTime;

	private int[] cycleArray;

	private Graph graph;

	public CycleDetectionByDFS(Graph graph) {
		this.graph = graph;
		if (this.graph != null) {
			this.visited = new char[this.graph.getV()];
			this.piArray = new int[this.graph.getV()];
			this.discoverTime = new int[this.graph.getV()];
			this.finishTime = new int[this.graph.getV()];
			this.cycleArray = new int[this.graph.getV()];

			Arrays.fill(this.visited, VisitingColor.RED.getChar());
			Arrays.fill(this.piArray, -1);
		} else {
			System.out.println("Please provide the valid graph.");
		}
	}

	public boolean cycleUtil() {
//		int cycleCount = 0;
		/**
		 * For a disconnected graph, we get the DFS forest, so put loop for those
		 * different DFS trees
		 */
		for (int v = 0; v < visited.length; v++) {
			if (visited[v] == VisitingColor.RED.getChar()) {
				if (hasCycle(v)) {
//					cycleCount++;
					// won't print correct cycle, will try to do with some other algo(if exist)
					printCycle();

					return true;
				}

				if (v != visited.length) {
					cycleArray = new int[graph.getV()];
				}
			}
		}

//		if (cycleCount > 0) {
//			System.out.println("\nCycles : " + cycleCount);
//		} else {
//			System.out.println("\nNo Cycle");
//		}

		return false;
	}

	/**
	 * Check whether there is cycle or not, start from source vertex
	 *
	 * @return true if there is any cycle in graph from source vertex otherwise
	 *         false
	 */
	public boolean hasCycle(int source) {
		/**
		 * set the color green of vertex that is going to traverse
		 */
		visited[source] = VisitingColor.GREEN.getChar();
		List<Integer> E = graph.getAdj()[source];

		// this condition is required for directed graph
		if (E != null) {
			Iterator<Integer> itr = E.iterator();
			while (itr.hasNext()) {
				int adj = itr.next();

				// either we can use parent array here to know the parent of this vertex
				// due to the recursive stack that is already managing this for us we can
				// use a parameter here
				if (visited[adj] == VisitingColor.GREEN.getChar() && adj != piArray[source]) {
					cycleArray[source] = source + 1;

					return true;
				} else if (visited[adj] == VisitingColor.RED.getChar()) {
					piArray[adj] = source;

					if (hasCycle(adj)) {
						cycleArray[source] = source + 1;

						return true;
					}
				}
			}
		}

		visited[source] = VisitingColor.BLACK.getChar();

		return false;
	}

	/**
	 * predecessor array to find the tree that is created by visited vertices
	 */
	public void printPiArray() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (int v = 0; v < graph.getV(); v++) {
			sb.append("parent of ").append(piArray[v]).append(" ********* start: ").append(discoverTime[v])
					.append(" end: ").append(finishTime[v]).append("\n");
		}

		System.out.println(sb);
	}

	/**
	 * print the cycle that is created by visited vertices
	 */
	public void printCycle() {
		StringJoiner sb = new StringJoiner(" -> ");
		for (int v = 0; v < cycleArray.length; v++) {
			if (cycleArray[v] != 0) {
				sb.add(String.valueOf(v));
			}
		}

		System.out.println(sb);
	}

}
