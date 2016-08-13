package weightedGraphs;

public class Edge implements Comparable<Edge> {
	int source;
	int destination;
	int weight;
	
	public int compareTo(Edge compareEdge) {
		return this.weight - compareEdge.weight;
	}
}
