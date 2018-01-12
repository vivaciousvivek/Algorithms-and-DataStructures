package com.techfirebase.daa.ds.advance_ds.graph;


import java.util.LinkedList;

import com.techfirebase.daa.utils.constants.GraphType;

/**
 * @author VIVEK KUMAR SINGH
 * @since 19-12-2017
 */
public class AdjacencyList {

    /*
    * For undirected Graph
    */
    public static void addEdge(Graph graph, int from, int to) {
        addEdge(graph, from, to, 0);
    }

    /*
    * For directed Graph
    */
    public static void addEdge(Graph graph, int from, int to, int weight) {
        if (graph != null && graph.getE() != null) {
            if (graph.getE()[from] == null) {
                graph.getE()[from] = new LinkedList<>();
            }

            graph.getE()[from].add(to);

            graph.getWeight()[from][to] = weight;

            if (graph.getGraphType() != null && GraphType.UNDIRECTED == graph.getGraphType()) {
                if (graph.getE()[to] == null) {
                    graph.getE()[to] = new LinkedList<>();
                }

                graph.getE()[to].add(from);

                graph.getWeight()[to][from] = weight;
            }
        }
    }

    // to be implement
    /*public static int removeEdge(Graph graph, GraphType graphType, int src, int dest) {
        return 0;
    }*/
}


