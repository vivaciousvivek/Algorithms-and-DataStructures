package com.techfirebase.daa.ds.advance_ds.graph;

import java.util.Arrays;

import com.techfirebase.daa.utils.constants.GraphType;

/**
 * @author VIVEK KUMAR SINGH
 * @since 18-01-2018
 * 
 * Graph DS implementation using Edge List structure
 */
public class EdgeListGraph {

	private int V;
	private int E;

	/*
	 * contains all adjacency vertices of every vertex
	 */
	private Edge[] edge;
	private GraphType graphType;

	/*
	 * Inner Member class for storing end points(both vertices) of edge
	 * 
	 * need to make it public, as we are using this in other packages
	 */
	public class Edge {
		private int src;
		private int dest;
		private int weight;

		public Edge() {
		}

		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		public int getSrc() {
			return src;
		}

		public void setSrc(int src) {
			this.src = src;
		}

		public int getDest() {
			return dest;
		}

		public void setDest(int dest) {
			this.dest = dest;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + "]";
		}
		
	}

	public EdgeListGraph(int v, int e) {
		this(v, e, GraphType.UNDIRECTED);
	}

	public EdgeListGraph(int v, int e, GraphType graphType) {
		V = v;
		E = e;
		edge = new Edge[V];
		this.graphType = graphType;
	}

	/*
	 * For undirected Graph
	 */
	public void addEdge(int edgeNumber, int src, int dest) {
		addEdge(edgeNumber, src, dest, 0);
	}

	public void addEdge(int edgeNumber, int src, int dest, int weight) {
		if (edgeNumber > 0 && edgeNumber <= E) {
			if (getEdge()[edgeNumber - 1] == null) {
				getEdge()[edgeNumber - 1] = new Edge(src, dest, weight);
			}
		} else {
			System.out.println("Please provide valid details");
		}
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public Edge[] getEdge() {
		return edge;
	}

	public void setEdge(Edge[] edge) {
		this.edge = edge;
	}

	public GraphType getGraphType() {
		return graphType;
	}

	public void setGraphType(GraphType graphType) {
		this.graphType = graphType;
	}

	@Override
	public String toString() {
		return "EdgeListGraph{" + "V=" + V + ", E=" + E + ", edge=" + Arrays.toString(edge) + ", graphType=" + graphType
				+ '}';
	}
}
