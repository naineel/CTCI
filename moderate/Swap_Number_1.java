package moderate;

public class Swap_Number_1 {

	public static void main(String[] args) {
		int a = 9;
		int b = 18;
		swapInPlace(a, b);
	}

	private static void swapInPlace(int a, int b) {
		a = a - b;
		b = a + b;
		a = b - a;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}

}
