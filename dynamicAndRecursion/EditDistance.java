package dynamicAndRecursion;

public class EditDistance {

	public static void main(String[] args) {
		String a = "intention";
		String b = "execution";
		System.out.println(editDistanceRecursive(a,b, a.length(), b.length()));
		System.out.println(editDistanceDP(a,b, a.length(), b.length()));
	}

	private static int editDistanceDP(String a, String b, int lengthOfA, int lengthOfB) {
		int[][] dp =  new int[lengthOfA+1][lengthOfB+1];
		
		for (int i=0; i <= lengthOfA; i++) {
			for (int j = 0; j <= lengthOfB; j++) {
				if (i==0) { 
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
				}
			}
		}
		
		return dp[lengthOfA][lengthOfB];
	}

	private static int editDistanceRecursive(String a, String b, int lengthOfA, int lengthOfB) {
		if (lengthOfA == 0) return lengthOfB;
	
		if (lengthOfB == 0) return lengthOfA;
		
		if (a.charAt(lengthOfA-1) == b.charAt(lengthOfB-1)) {
			return editDistanceRecursive(a, b, lengthOfA-1, lengthOfB-1);
		}
		
		return 1 + Math.min(Math.min(editDistanceRecursive(a, b, lengthOfA, lengthOfB-1), editDistanceRecursive(a, b, lengthOfA-1, lengthOfB)), editDistanceRecursive(a, b, lengthOfA-1, lengthOfB-1));
		
	}
	
	

}
