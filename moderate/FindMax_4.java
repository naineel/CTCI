package moderate;

public class FindMax_4 {

	public static void main(String[] args) {
		int a = -100;
		int b = 50;
		System.out.println(findMax(a, b));
	}
	
	private static int findMax(int a, int b) {
		int c = a-b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		
		int use_sign_of_a = sa^sb;
		int use_sign_of_c = flip(use_sign_of_a);
				
		int k = use_sign_of_a*sa + use_sign_of_c*sc;
		int q = flip(k);
		
		return a*k + b*q;
	}

	public static int sign(int num) {
		return flip(num >> 31 & 1);
	}
	
	public static int flip(int bit) {
		return 1^bit;
	}

}
