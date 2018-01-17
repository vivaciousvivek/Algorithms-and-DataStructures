package com.techfirebase.daa.algo.graph.traversals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

import com.techfirebase.daa.ds.advance_ds.graph.Graph;
import com.techfirebase.daa.utils.constants.VisitingColor;

/**
 * @author VIVEK KUMAR SINGH
 * @since 19-12-2017
 */
public class BFS {
    /*
    * use it to color the vertices, we can also use boolean array here
    * but these three colors will be very useful in Dijkstra’s algo
    */
    private char[] visited;

    /*
    * pi(parent info) array will use to get the parent info after each traversal
    */
    private int[] piArray;

    /*
    * Create a queue for BFS
    */
    private Queue<Integer> queue;

    private Graph graph;

    public BFS(Graph graph) {
        this.graph = graph;
        if (this.graph != null) {
            this.queue = new LinkedList<>();
            this.visited = new char[this.graph.getV()];
            this.piArray = new int[this.graph.getV()];

            Arrays.fill(this.visited, VisitingColor.RED.getChar());
            Arrays.fill(this.piArray, -1);
        } else {
            System.out.println("Please provide the valid graph.");
        }
    }

    public void BFSTraversal(int source) {
        enqueue(source, source);

        while (!queue.isEmpty()) {
            /*
            * Dequeue current vertex from queue color it black and print it
            */
            source = queue.poll();
            visited[source] = VisitingColor.BLACK.getChar();
            System.out.print(source + " -> ");

            /*
            *  Get all adjacent vertices of the dequeued source vertex
            *  If a adjacent has not been visited, then color it green and enqueue it
            */

            /*Iterator<Integer> i = graph.getAdj()[source].iterator();
            while (i.hasNext()) {
                int v = i.next();
                if (visited[v] == VisitingColor.RED.getChar()) {
                    visited[v] = VisitingColor.GREEN.getChar();
                    piArray[v] = source;
                    queue.add(v);
                }
            }*/

            // using java 8
            int parent = source;
            this.graph.getAdj()[source].stream()
                    .filter(v -> visited[v] == VisitingColor.RED.getChar())
                    .map(v -> enqueue(v, parent))
                    .collect(Collectors.toList());
//                    .map(v -> visited[v] = VisitingColor.GREEN.getChar());
        }
    }

    /*
    * Set the color of current vertex green as visited and enqueue it and set the predecessor(parent) of this vertex
    */
    public Queue<Integer> enqueue(int vertex, int predecessor) {
        visited[vertex] = VisitingColor.GREEN.getChar();
        piArray[vertex] = predecessor;
        queue.add(vertex);

        return queue;
    }

	public void printPiArray() {
		StringBuilder sb = new StringBuilder();

		for (int v = 0; v < graph.getV(); v++) {
			sb.append("parent of ").append(v).append(" is ").append(piArray[v]);
			System.out.println(sb);
		}
	}
}
