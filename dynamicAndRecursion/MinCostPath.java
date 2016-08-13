package dynamicAndRecursion;

public class MinCostPath {

	public static void main(String[] args) {
		int[][] cost = new int[][] { {1,2,3},
			{4, 8, 2},
			{1,5,3}};
		System.out.println(findCostPathRecursive(cost, 2, 2));
		System.out.println(findCostPathDP(cost, 2, 2));
		
	}

	private static int findCostPathRecursive(int[][] cost, int m, int n) {
		if (m < 0 || n < 0) {
			return Integer.MAX_VALUE;
		} else if (m == 0 && n == 0) {
			return cost[0][0];
		} else {
			return cost[m][n] + Math.min(Math.min(findCostPathRecursive(cost, m-1, n-1), findCostPathRecursive(cost, m, n-1)), findCostPathRecursive(cost, m-1, n));
		}
		
	}
	
	private static int findCostPathDP(int[][] cost, int m, int n) {
		int[][] tc = new int[cost.length][cost[0].length];
		
		tc[0][0] = cost[0][0];
		
		for (int i = 1; i <= m; i++) {
			tc[i][0] = tc[i-1][0] + cost[i][0];
		}
		
		for (int j = 1; j <= n; j++) {
			tc[0][j] = tc[0][j-1] + cost[0][j];
		}
		
		for (int i=1; i <= m; i++) {
			for (int j=1; j <= n; j++) {
				tc[i][j] = Math.min(Math.min(tc[i-1][j-1], tc[i-1][j]), tc[i][j-1]) + cost[i][j];
			}
		}
		
		return tc[m][n];
		
	}
	

}
