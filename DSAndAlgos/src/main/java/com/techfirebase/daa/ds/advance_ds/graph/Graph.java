package com.techfirebase.daa.ds.advance_ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.techfirebase.daa.utils.constants.GraphType;

/**
 * @author VIVEK KUMAR SINGH
 * @since 18-12-2017
 * 
 * Graph DS implementation using Adjacency List structure
 */
public class Graph {

	/*
	 * No of vertices in graph
	 */
	private int V;
	/*
	 * contains all adjacency vertices of every vertex
	 */
	private List<Integer>[] adj;

	/*
	 * weight associated with every edge of adjacency list
	 */
	private int[][] weight;

	/*
	 * graph type: undirected or directed
	 */
	private GraphType graphType;

	public Graph(int v) {
		this(v, GraphType.UNDIRECTED);
	}

	public Graph(int v, GraphType graphType) {
		V = v;
		adj = new LinkedList[V];
		weight = new int[V][V];
		this.graphType = graphType;
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public List<Integer>[] getAdj() {
		return adj;
	}

	public void setAdj(List<Integer>[] adj) {
		this.adj = adj;
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
		return "Graph{" + "V=" + V + ", adj=" + Arrays.toString(adj) + ", weight=" + Arrays.toString(weight)
				+ ", graphType=" + graphType + '}';
	}
}
