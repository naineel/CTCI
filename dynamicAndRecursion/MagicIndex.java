package dynamicAndRecursion;

public class MagicIndex {

	public static void main(String[] args) {
		int[] array = new int[] {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
		int[] array2 = new int[] {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		System.out.println(magicFastRecursive(array, 0, array.length - 1));
		System.out.println(magicFastNotDistinctRecursive(array2, 0, array2.length - 1));
	}
	
	private static int magicFastNotDistinctRecursive(int[] array, int start, int end) {
		if (end < start || start < 0 || end > array.length) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		int midValue = array[mid];
		
		if (midValue == mid) {
			return mid;
		} 
		
		//Search left
		
		int leftIndex = Math.min(mid-1, midValue);
		int left = magicFastNotDistinctRecursive(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}
		
		//Search right
		
		int rightIndex = Math.max(mid + 1, midValue);
		int right = magicFastNotDistinctRecursive(array, rightIndex, end);
		
		
		return right;

	}

	public static int magicFastRecursive(int[] array, int start, int end) {
		if (end < start || start < 0 ||end >= array.length) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid){
			return magicFastRecursive(array, start, mid - 1);
		} else {
			return magicFastRecursive(array, mid + 1, end);
		}
		
	}

}
