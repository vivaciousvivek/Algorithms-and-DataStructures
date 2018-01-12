package com.techfirebase.daa.ds.advance_ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.techfirebase.daa.utils.constants.GraphType;

/**
 * @author VIVEK KUMAR SINGH
 * @since 18-12-2017
 */
public class Graph {

    private int V;
    private List<Integer> E[];
    private int[][] weight;
    private GraphType graphType;

    public Graph(int v) {
        this(v, GraphType.UNDIRECTED);
    }

    public Graph(int v, GraphType graphType) {
        V = v;
        E = new LinkedList[V];
        weight = new int[V][V];
        this.graphType = graphType;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public List<Integer>[] getE() {
        return E;
    }

    public void setE(List<Integer>[] e) {
        E = e;
    }

    public int[][] getWeight() {
        return weight;
    }

    public void setWeight(int[][] weight) {
        this.weight = weight;
    }

    public GraphType getGraphType() {
        return graphType;
    }

    public void setGraphType(GraphType graphType) {
        this.graphType = graphType;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "V=" + V +
                ", E=" + Arrays.toString(E) +
                ", weight=" + Arrays.toString(weight) +
                ", graphType=" + graphType +
                '}';
    }
}

/*enum GraphType {
    UNDIRECTED, DIRECTED;
}

enum VisitingColor {
    RED('R'), GREEN('G'), BLACK('B');

    private char color;

    VisitingColor(char color) {
        this.color = color;
    }

    public char getChar() {
        return color;
    }
}*/
