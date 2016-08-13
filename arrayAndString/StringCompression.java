package arrayAndString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCompression {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string");
		String x = br.readLine();
		System.out.println("The string: "  + x);
		String compressedString = compressString(x);
		System.out.println("The compressed string: " + compressedString);
	}

	private static String compressString(String x) {
		StringBuilder sb = new StringBuilder();
		char prevChar = x.charAt(0);
		int count = 1;
		for (int i = 1; i < x.length(); i++) {
			char currentChar = x.charAt(i);
			if (currentChar == prevChar) {
				count++;
			} else {
				sb.append(prevChar);
				sb.append(count);
				prevChar = x.charAt(i);
				count = 1;
			}
		}
		sb.append(prevChar);
		sb.append(count);
		return sb.toString();
	}

}
