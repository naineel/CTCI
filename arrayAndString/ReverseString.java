package arrayAndString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string to reverse");
		String x = br.readLine();
		System.out.println("The original String: " + x);
		String reversed = reverseString(x);
		System.out.println("The reversed String: " + reversed);
		
	}

	//Use recursion
	private static String reverseString(String x) {
		if (x.length() == 1) {
			return x;
		}
		return reverseString(x.substring(1)) + x.charAt(0);
	}

}
