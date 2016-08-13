package moderate;

public class TrailingZerosInFactorial_3 {
	
	public static void main(String[] args) {
		int number = 50;
		System.out.println(countFactZeros(number));
	}
	
	//Method 1
//	public static int countFactZeros(int num) {
//		int count = 0;
//		for (int i = 2; i <= num; i++) {
//			count += factorsOf5(i);
//		}
//		
//		return count;
//	}
//
//	private static int factorsOf5(int i) {
//		int count = 0;
//		
//		while (i % 5 == 0) {
//				count++;
//				i = i/5;
//			}
//		return count;
//	}
	//End of method 1
	
	
	//Method 2
	public static int countFactZeros(int num) {
		int count = 0;
		if (num < 0) {
			return -1;
		}
		for (int i = 5; num/i > 0; i=i*5) {
			count += num/i;
		}
		return count;
	}

}
