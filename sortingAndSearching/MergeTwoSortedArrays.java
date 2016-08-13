package sortingAndSearching;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] a = new int[8];
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		a[3] = 40;
		int[] b = new int[] {2,4,12,45};
		
		int[] resultA = merge(a, b, 4, b.length);
		
		for (int i = 0; i < resultA.length; i++) {
			System.out.println("The position " + (i + 1) + " has value: " + a[i]);
		}
		
	}

	private static int[] merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int mergedArrayIndex = lastA + lastB - 1;
		
		while (indexA >= 0 && indexB >= 0) {
			if (a[indexA] > b[indexB]) {
				a[mergedArrayIndex] = a[indexA];
				mergedArrayIndex--;
				indexA--;
			} else {
				a[mergedArrayIndex] = b[indexB];
				mergedArrayIndex--;
				indexB--;
			}
		}
		
		while (indexB >= 0) {
			a[mergedArrayIndex] = b[indexB];
			mergedArrayIndex--;
			indexB--;
		}
		
		return a;
	}
	
	

}
