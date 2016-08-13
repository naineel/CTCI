package moderate;

import java.util.Hashtable;

public class SumPair_12 {

	public static void main(String[] args) {
		int a[] = new int[] {
			-2,-1,0,3,4,5,6,7,9,13,14	
		};
		int sum = -3;
		findPairs(a, sum);
	}

	private static void findPairs(int[] a, int sum) {
		Hashtable<Integer, Integer> has = new Hashtable<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			int other = sum-a[i];
			if (has.containsKey(other)) {
				System.out.println(a[i] + " " + other);
			} else {
				has.put(a[i], 0);
			}
		}
	}

}
