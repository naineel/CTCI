package moderate;

public class SmallestSequenceForSorting_6 {

	public static void main(String[] args) {
		
		int[] a = new int[] {
			1,2,4,6,7,16,18,19	
		};
		findUnsortedSequence(a);

	}

	private static void findUnsortedSequence(int[] a) {
		int left_end = findLeftEnd(a);
		System.out.println(left_end);
		int right_start = findRightStart(a);
		System.out.println(right_start);
		int min_index = left_end + 1;
		
		//Check if array already sorted.
		if (min_index > a.length) {
			System.out.println("Already sorted");
			return;
		}
//		
		int max_index = right_start - 1;
//		
		for (int i = left_end; i <= right_start; i++) {
			if (a[i] < a[min_index]) min_index = i;
			if (a[i] > a[max_index]) max_index = i;
		}
		
		System.out.println("Min Index: " + min_index);
		System.out.println("Max Index: " + max_index);
//		
		int left_index = shrinkLeft(a, min_index, left_end);
//		
		int right_index = shrinkRight(a, max_index, right_start);
		
		System.out.println("Left Index: " + left_index + " \nRight Index: " + right_index);
		
	}

	private static int shrinkRight(int[] a, int max_index, int right_start) {
		int compareWith = a[max_index];
		for (int i = right_start; i < a.length; i++) {
			if (a[i] >= compareWith) return i - 1;
		}
		return a.length - 1;
	}

	private static int shrinkLeft(int[] a, int min_index, int left_end) {
		int compareWith = a[min_index];
		for (int i = left_end - 1; i < a.length; i++) {
			if (a[i] >= compareWith) return i - 1;
		}
		return a.length - 1;
	}

	private static int findRightStart(int[] a) {
		for (int i = a.length - 1; i >= 1; i--) {
//			System.out.println(i);
			if (a[i] < a[i-1]) return i;
		}
		return 0;
	}

	private static int findLeftEnd(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			if(a[i+1] < a[i]) return i;
		}
		return a.length;
	}
	

}
