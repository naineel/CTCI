package arrayAndString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceSpaces {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter string");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		char[] inputArray = input.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inputArray.length; i++) {
			char a = inputArray[i]; 
			if (a == ' ') {
				sb.append("%20");
			} else {
				sb.append(a);
			}
		}
		String replacedString = sb.toString();
		
		System.out.println("The replaced String: " + replacedString);

	}

}
