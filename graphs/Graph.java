package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	private int noOfVertices;
	private LinkedList<Integer> adjacencyList[];
	
	@SuppressWarnings("unchecked")
	Graph(int v) {
		noOfVertices = v;
		adjacencyList = new LinkedList[v];
		for (int i=0; i < v ;i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
		
	}
	
	void addEdge(int v,int weight) {
		adjacencyList[v].add(weight);
	}
	
	// Time complexity O(V + E) 
	void BFS(int source) {
		boolean visited[] = new boolean[noOfVertices];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[source] = true;
		queue.add(source);
		
		while (queue.size() != 0) {
			source = queue.poll();
			
			System.out.print(source + " ");
			Iterator<Integer> i = adjacencyList[source].iterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]){
					visited[n] = true;
					queue.add(n);	
				}
			}
			
		}
		
	}
	
	//Time complexity O()
	void DFS(int source) {
		boolean visited[] = new boolean[noOfVertices];
		DFSHelper(source, visited);
	}

	private void DFSHelper(int source, boolean[] visited) {
		visited[source] = true;
		System.out.print(source + " ");
		
		Iterator<Integer> i = adjacencyList[source].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				DFSHelper(n, visited);
			}
		}
		
	}
	
	//USE DFS and a back edge on the recursion stack will give you a loop.
	boolean isGraphCyclic(Graph g) {
		boolean visited[] = new boolean[noOfVertices];
		boolean recursionStack[] = new boolean[noOfVertices];
		
		// Mark all vertices as not visited and not in the recursion stack.
		for (int i=0; i < noOfVertices; i++) {
			visited[i] = false;
			recursionStack[i] = false;
			
		}
		
		for (int i=0; i < noOfVertices; i++) {
			if (isCyclicHelper(i, visited, recursionStack)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean isCyclicHelper(int i, boolean[] visited, boolean[] recursionStack) {
		if (visited[i] == false) {
			visited[i] = true;
			recursionStack[i] = true;
			
			Iterator<Integer> iterator = adjacencyList[i].listIterator();
			
			while (iterator.hasNext()) {
				int n = iterator.next();
				if (!visited[n] && isCyclicHelper(n, visited, recursionStack)){
					return true;
				} else if (recursionStack[n]) {
					return true;
				}
			}
		}
		recursionStack[i] = false;
		return false;
	}
	
	public void topologicalSort(Graph g) {
		boolean visited[] = new boolean[noOfVertices];
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i=0; i < noOfVertices;i++) {
			visited[i] = false;
		}
		
		for (int i=0; i < noOfVertices;i++) {
			if (visited[i] == false) {
				topologicalSortHelper(i, visited, stack);
			}
		}
		
		while (!stack.empty()) {
			System.out.println(stack.pop() + " ");
		}
		
	}

	private void topologicalSortHelper(int i, boolean[] visited, Stack<Integer> stack) {
		visited[i] = true;
		Integer n;
		Iterator<Integer> iterator = adjacencyList[i].listIterator();
		while (iterator.hasNext()) {
			n = iterator.next();
			if (!visited[n]) {
				topologicalSortHelper(i, visited, stack);
			}
		}
		stack.push(new Integer(i));
	}	
	
	
	
}

