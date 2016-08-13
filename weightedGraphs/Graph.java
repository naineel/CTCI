package weightedGraphs;

import java.util.Arrays;

public class Graph {
	
	class Subset {
		int parent, rank;
	}
	
	int noOfVertices, noOfEdges;
	Edge edge[];
	
	Graph(int v, int e) {
		noOfVertices = v;
		noOfEdges = e;
		edge = new Edge[e];
		for (int i=0; i < e; ++i) {
			edge[i] = new Edge();
		}
	}
	
	void isCycle(Graph g) {
		//Allocate memory for creating V subsets.
		int parent[] = new int[g.noOfVertices];
		
		//Initialize all subsets as single element sets.
		for (int i = 0; i < g.noOfVertices; i++) {
			parent[i] = -1;
		}
		// Iterate through the edges
		for (int i=0; i < g.noOfEdges; i++) {
			int x = g.find(parent, g.edge[i].source);
			int y = g.find(parent, g.edge[i].destination);
			
			if (x == y) {
				System.out.println("There is a cycle");
				return;
			}
			
			g.union(parent, x, y);
		}
		System.out.println("There is no cycle");
		return;
		
	}

	// Find the subset of the element s
	private int find(int[] parent, int s) {
		if (parent[s] == -1) {
			return s;
		}
		return find(parent, parent[s]);
	}
	
	// Do union of the two subsets
	private void union(int[] parent, int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	public void kruskalMST(Graph graph1) {
		//result stores the MST.
		int v = graph1.noOfVertices;
		Edge result[] = new Edge[v];
		int e = 0;
		int i = 0;
		
		for (i = 0; i < v; ++i) {
			result[i] = new Edge();
		}
		
		Arrays.sort(graph1.edge);
		
		Subset subsets[] = new Subset[v];
		for (i = 0; i < v; i++) {
			subsets[i] = new Subset();
		}
		
		for (int j = 0; j < v;++j) {
			subsets[j].parent = j;
			subsets[j].rank = 0;
		}
		
		i = 0;
		
		while (e < v - 1) {
			Edge next_edge = new Edge();
			next_edge = edge[i++];
			
			int x = kruskalFind(subsets, next_edge.source);
			int y = kruskalFind(subsets, next_edge.destination);
			
			if (x != y) {
				result[e++] = next_edge;
				kruskalUnion(subsets, x, y);
			}
		}

		System.out.println("Edges in the MST are ");
		for (int j = 0; j < e; j++) {
			System.out.println(result[j].source + " -- " + 
							   result[j].destination + "==" + 
							   result[j].weight);
		}
	}

	private int kruskalFind(Subset[] subsets, int source) {
		if (subsets[source].parent != source) {
			subsets[source].parent = kruskalFind(subsets, subsets[source].parent);
		}
		return subsets[source].parent;
	}

	private void kruskalUnion(Subset[] subsets, int x, int y) {
		int xroot = kruskalFind(subsets, x);
		int yroot = kruskalFind(subsets, y);
		
		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
		
		
	}

}
