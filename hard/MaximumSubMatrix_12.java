package hard;

public class MaximumSubMatrix_12 {

	public static void main(String[] args) {
		System.out.println((int)4.999);
		int[][] a = new int[][] { 
			{ 2,  1, -3, -4,  5},
			{ 0,  6,  3,  4,  1},
			{ 2, -2, -1,  4, -5},
			{-3,  3,  1,  0,  3}
		};

		int maxSum = findMaxSubArray(a);
		
		System.out.println(maxSum);
	}

	private static int findMaxSubArray(int[][] a) {
		int[] temp = new int[a.length];
		int currentMax, maxSum=0, maxLeft=0, maxRight=0, maxUp=0, maxDown=0;
		
		for (int i=0; i < a[0].length; i++) {
			currentMax = 0;
			
			for (int j = i; j < a[0].length; j++) {
				for (int k = 0; k < a.length; k++) {
					temp[k] += a[k][j];
				}
				
				//Now kadane's algorithm implementation
				int tempMax = 0, tempIndex = 0, startIndex = 0, stopIndex = 0;
				for (int l = 0; l < temp.length; l++) {
					tempMax += temp[l];
					
					if (tempMax > currentMax) {
						startIndex = tempIndex;
						stopIndex = l;
						currentMax = tempMax;
					}
					
					if (tempMax < 0) {
						tempIndex = l + 1;
						tempMax = 0;
					}
					
				}
				
				if (currentMax > maxSum) {
					maxLeft = i;
					maxRight = j;
					maxUp = startIndex;
					maxDown = stopIndex;
					maxSum = currentMax;
				}
				
			}
	
			for (int k = 0; k < temp.length; k++) {
				temp[k] = 0;
			}
			
		}
		
		
		int solution[][] = new int[maxDown - maxUp + 1][maxRight - maxLeft + 1];
		
		for (int x = 0, i = maxUp; i <= maxDown;i++, x++) {
			for (int y = 0, j = maxLeft; j <= maxRight;j++, y++) {
				solution[x][y] = a[i][j];
				if (solution[x][y] >= 0) {
					System.out.println(" " + solution[x][y] + "\t");
				} else {
					System.out.println(solution[x][y] + "\t");
				}
			}
			System.out.println();
		}
		return maxSum;
	}

}
