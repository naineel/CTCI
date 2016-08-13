package arrayAndString;

import java.util.HashSet;
import java.util.Set;

public class MatrixZero {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,0,12}};
		Set<Integer> rowNum = new HashSet<Integer>();
		Set<Integer> colNum = new HashSet<Integer>();		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rowNum.add(i);
					colNum.add(j);
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (rowNum.contains(i) || colNum.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for (int i=0 ; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.println(matrix[i][j]);
			}
		}

	}

}
