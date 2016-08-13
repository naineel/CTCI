package weightedGraphs;

public class GraphMain {

	public static void main(String[] args) {
		int V = 3, E = 3;
        Graph graph = new Graph(V, E);
        /* Let us create following graph
        0
       |  \
       |    \
       1-----2 */
        // add edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
 
        // add edge 1-2
        graph.edge[1].source = 1;
        graph.edge[1].destination = 2;
 
        // add edge 0-2
        graph.edge[2].source = 0;
        graph.edge[2].destination = 2;
        
//        graph.isCycle(graph);
        
        Graph graph1 = new Graph(4, 5);
        
        // add edge 0-1
        graph1.edge[0].source = 0;
        graph1.edge[0].destination = 1;
        graph1.edge[0].weight = 10;
 
        // add edge 0-2
        graph1.edge[1].source = 0;
        graph1.edge[1].destination = 2;
        graph1.edge[1].weight = 6;
 
        // add edge 0-3
        graph1.edge[2].source = 0;
        graph1.edge[2].destination = 3;
        graph1.edge[2].weight = 5;
 
        // add edge 1-3
        graph1.edge[3].source = 1;
        graph1.edge[3].destination = 3;
        graph1.edge[3].weight = 15;
 
        // add edge 2-3
        graph1.edge[4].source = 2;
        graph1.edge[4].destination = 3;
        graph1.edge[4].weight = 4;
		
        graph1.kruskalMST(graph1);
        
        
	}

}
