package hard;

public class NumberOf2s_4 {

	public static void main(String[] args) {
		int number = 123;
		int length = String.valueOf(number).length();
		int count = 0;
		for (int i = 0; i < length; i++) {
			count += count2s(number, i);
		}
		
		System.out.println("Number of twos: " + count);
	}

	private static int count2s(int number, int digit) {
		int powerOf10 = (int)Math.pow(10, digit);
		int nextPowerOf10 = 10 * powerOf10;
		int right = number % powerOf10;
		
		int roundDown = number - (number % nextPowerOf10);
		int roundUp = roundDown + nextPowerOf10;
		
		int actualDigit = (number/ powerOf10) % 10;
		
		
		if (actualDigit < 2) {
			return roundDown/10;
		} else if (actualDigit == 2) {
			return roundDown/10 + right + 1;
		} else {
			return roundUp/10;
		}
		
	}

}
