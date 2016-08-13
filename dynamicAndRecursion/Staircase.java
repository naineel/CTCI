package dynamicAndRecursion;

public class Staircase {

	public static void main(String[] args) {
		Staircase s = new Staircase();
		System.out.println("The DP way: " + s.countWays(10, new int[1000]));
		System.out.println("The recursive way: " + s.countWaysRecursive(10));
	}

	private int countWays(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] > 0){
			return map[n];
		} else{
			map[n] = countWays(n-1, map) + countWays(n-2, map) + 
					countWays(n-3, map); 
			return map[n];
		}
	}
	
	private int countWaysRecursive(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWaysRecursive(n-1) + countWaysRecursive(n-2) + countWaysRecursive(n-3);
		}
	}

}
