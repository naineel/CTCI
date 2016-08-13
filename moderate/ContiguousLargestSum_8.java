package moderate;

public class ContiguousLargestSum_8 {

	public static void main(String[] args) {
		int[] seq = new int[] {2, 3, -8, -1, 2, 4, -2, 3};
		int sum = findMaxSum(seq);
		System.out.println("The sum: " + sum);
	}

	private static int findMaxSum(int[] seq) {
		int sum = 0;
		int maxSum = 0;
		for (int i = 0; i < seq.length; i++) {
			sum += seq[i];
			if (maxSum < sum) {
				maxSum = sum;
			} else if (sum < 0){
				sum = 0;
			}
		} 
		return sum;
	}

}
