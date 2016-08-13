package weightedGraphs;

public class MST {
	
	private static final int V=5;

	public static void main(String[] args) {
		MST mst = new MST();
		
		int graph[][] = new int[][] {
			{0,2,0,6,0},
			{2,0,3,8,5},
			{0,3,0,0,7},
			{6,8,0,0,9},
			{0,5,7,9,0}
		};
		
		mst.primMST(graph);

	}

	private void primMST(int[][] graph) {
		
		//Array to store constructed MST
		int mstSet[] = new int[V];
		
		//Key values used to pick minimum weight edge in cut
		int key[] = new int[V];
		
		Boolean includedInMst[] = new Boolean[V];
		
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			includedInMst[i] = false;
		}
		
		// Alwayys include first vertex in the MST
		// So make 0 so that it is selected first
		key[0] = 0;
		
		//First node is always root node.
		mstSet[0] = -1;
		
		
		for (int count=0; count < V -1; count++) {
		
			//Pick the minimum
			int u = minKey(key, includedInMst);
			
			//Add the vertex to the MST set
			includedInMst[u] = true;
			
			for (int v = 0; v < V; v++) {
				
				if (graph[u][v]!=0 && !includedInMst[v] && 
						graph[u][v] < key[v]) {
					mstSet[v] = u;
					key[v] = graph[u][v];
				}
			}
			
		}
		
		printMST(mstSet, graph);
		
	}

	private int minKey(int[] key, Boolean[] includedInMst) {
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		
		for (int v = 0; v < V; v++) {
			if (!includedInMst[v] && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
		
		return min_index;
	}

	private void printMST(int[] mstSet, int[][] graph) {
		System.out.println("Edge Weight");
		for (int i = 1; i < V; i++)
			System.out.println(mstSet[i]+" - "+ i+" "+
							graph[i][mstSet[i]]);
		
	}
	
	

}
