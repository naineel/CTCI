package sortingAndSearching;

public class RotatedSortedArray {

	public static void main(String[] args) {
		int[] a = new int[] {10, 15, 20, 0, 5};
		int[] b = new int[] {50, 5, 20, 30, 40};
		int returnIndexForA = findElementInArray(a, 5, 0, a.length-1);
		int returnIndexForB = findElementInArray(b, 40, 0, b.length-1);
		System.out.println(returnIndexForA);
		System.out.println(returnIndexForB);
	}

	private static int findElementInArray(int[] a, int number, int start, int end) {
		int mid = (start + end) / 2;
		
		if (a[mid] == number) {
			return mid;
		}
		
		if (end < start) {
			return -1;
		}
		
		if (a[mid] > a[start]) {//left side is ordered.
			if (number >= a[start] && number <= a[mid]) {
				return (findElementInArray(a, number, start, mid-1)); //Go left
			} else {
				return (findElementInArray(a, number, mid+1, end));
			}
		} else if (a[mid] < a[start]) {//right side is ordered.
			if (number >= a[mid] && number <= a[end]) {
				return (findElementInArray(a, number, mid+1, end));
			} else {
				return (findElementInArray(a, number, start, mid-1));
			}
		} else if (a[start] == a[mid]) {
			if (a[mid] != a[end]) {
				return (findElementInArray(a, number, mid+1, end));
			} else {
				int result = findElementInArray(a, number, start, mid-1);
				if (result == -1) {
					return findElementInArray(a, number, mid+1, end);
				} else {
					return result;
				}
			}
		}
		
		return -1;
	}

}
