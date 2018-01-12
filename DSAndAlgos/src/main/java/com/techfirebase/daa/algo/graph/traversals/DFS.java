package com.techfirebase.daa.algo.graph.traversals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.techfirebase.daa.ds.advance_ds.graph.Graph;
import com.techfirebase.daa.utils.constants.VisitingColor;

/**
 * @author VIVEK KUMAR SINGH
 * @since 20-12-2017
 */
public class DFS {

    /*
    * use it to color the vertices, we can also use boolean array here
    * but these three colors wil be very useful in Dijkstra’s algo
    */
    private char visited[];

    /*
    * pi(parent info) array will use to get the parent info after each traversal
    */
    private int piArray[];

    /*
    *  Array after applying DFS and storing vertices by their decreasing order of finishing time
    */
    private static int[] decreasingFinishTimeArray;

    /*
    * these arrays will be used to store when the vertex is pushed into and popped from stack
    */
    private int discoverTime[];
    private int finishTime[];

    private int time = 0;
    private int v = 0;

    private Graph graph;

    public DFS(Graph graph, int source) {
        this.graph = graph;
        if (this.graph != null) {
            this.v = this.graph.getV();
            this.visited = new char[this.graph.getV()];
            this.piArray = new int[this.graph.getV()];
            decreasingFinishTimeArray = new int[v];
            this.discoverTime = new int[this.graph.getV()];
            this.finishTime = new int[this.graph.getV()];
            /*
            * initialize piArray from the given element
            */
            this.piArray[source] = source;

            Arrays.fill(this.visited, 0, this.graph.getV(), VisitingColor.RED.getChar());
        } else {
            System.out.println("Please provide the valid graph.");
        }
    }

    /**
     * First call the DFSTraversal then get this topologically sorted array
     * @return topologically sorted array(descending order of finishing time of visited vertices)
     */
    public static int[] getDecreasingFinishTimeArray() {
        return decreasingFinishTimeArray;
    }

    /**
     * DFS traversal of given Graph
     * @param source vertex from which you want to start the traversal
     */
    public void DFSTraversal(int source) {
        /*
        * Set the color of current vertex green as visited
        */
        visited[source] = VisitingColor.GREEN.getChar();
        discoverTime[source] = ++time;
        System.out.print(source + " -> ");

        /*
        *  Get all adjacent vertices of the dequeued source vertex
        *  If a adjacent has not been visited, then color it green and enqueue it
        */

        List<Integer> E = this.graph.getE()[source];

        // this condition is required for directed graph
        if (E != null) {
            Iterator<Integer> i = E.iterator();
            while (i.hasNext()) {
                int v = i.next();
                if (visited[v] == VisitingColor.RED.getChar()) {
                    piArray[v] = source;
                    DFSTraversal(v);
                }
            }
        }

        // using java 8
        /*this.graph.getE()[source].stream()
                .filter(v -> visited[v] == VisitingColor.RED.getChar())
                .map(v -> {
                    piArray[v] = source;
                    DFSTraversal(v);
                    return true;
                })
                .collect(Collectors.toList());*/

        visited[source] = VisitingColor.BLACK.getChar();
        finishTime[source] = ++time;

        // arranging the vertices in the decreasing order of their finish time
        // will be used for Topological Sorting in DAG and to find Strongly Connected component in directed graph
        decreasingFinishTimeArray[--v] = source;
    }

    /**
     * predecessor array to find the tree that is created by visited vertices
     */
    public void printPiArray() {
        System.out.println("\n");
        for (int v = 0; v < graph.getV(); v++) {
            System.out.println("parent of " + v + " is " + piArray[v] + " ********* start: " + discoverTime[v] + " end: " + finishTime[v]);
        }
    }
}
