package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 18.6 
 * Describe an algorithm to find the smallest one million numbers in one billion
numbers. Assume that the computer memory can hold all one billion numbers.
 * @author naineel
 *
 */
public class FindSmallestNNumbers_6 {

	public static void main(String[] args) {
		int[] input = new int[] {
				6,7,8,9,14,20,30,40,1,2,3,4,5
		};
		Object[] resultObj = smallestNumbers(input, 9);
		int[] result = new int[9];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int)resultObj[i];
		}
//		System.out.println(Integer.reverse(1));
		System.out.println(result[0]);

	}

	private static Object[] smallestNumbers(int[] input, int i) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(i, new MaximumComparator());
		for (int j = 0; j < i; j++) {
			maxHeap.add(input[j]);
		}
		
		for (int j = i; j < input.length; j++) {
			if (maxHeap.peek() > input[j]) {
				maxHeap.poll();
				maxHeap.add(input[j]);
			}
		}
		
		return maxHeap.toArray();
		
	}
	
	static class MaximumComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
		
	}

}
