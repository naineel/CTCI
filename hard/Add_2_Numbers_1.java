package hard;

public class Add_2_Numbers_1 {

	public static void main(String[] args) {
		int a = 15;
		int b = 30;
		int sum = addTwoNumbers(a, b);
		System.out.println(sum);
	}

	private static int addTwoNumbers(int a, int b) {
		if(b == 0) return a;
		int sum = a^b;
		int carry = (a & b) << 1;
		return addTwoNumbers(sum, carry);
	}

}
