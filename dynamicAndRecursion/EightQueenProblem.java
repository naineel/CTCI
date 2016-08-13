package dynamicAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class EightQueenProblem {
	static int GRID_SIZE = 8;

	public static void main(String[] args) {
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		List<Integer[]> results = placeQueens(0, new Integer[GRID_SIZE], list);
		System.out.println("Size of results is " + results.size());
//		for (Integer[] in : results) {
//			for (int i = 0; i < in.length; i++) {
//				System.out.println(in[i]);
//			}
//			System.out.println("Next");
//		}

	}
	
	public static List<Integer[]> placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
		if (row == GRID_SIZE) {
			results.add(columns.clone());
		} else {
			for (int col = 0; col < GRID_SIZE; col++) {
				if (checkValid(row, col, columns)) {
					columns[row] = col;  // Place queens
					placeQueens(row + 1, columns, results);
				}
			}
		}
		return results;
	}

	private static boolean checkValid(int row1, int column1, Integer[] columns) {
		for (int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			
			/* Two queens have the same column*/
			if (column1 == column2) {
				return false;
			}
			
			int columnDistance = Math.abs(column2 -column1);
			int rowDistance = Math.abs(row1-row2);
			
			// If column distance and row distance us equal then they are
			// on a diagonal
			if (columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}

}
