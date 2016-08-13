package arrayAndString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoStringPermutations {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string 1\n");
		String x = br.readLine();
		System.out.println("Enter string 2\n");
		String y = br.readLine();
		
		System.out.println("String 1: " + x);
		System.out.println("String 2: " + y);
		
		System.out.println("To check if the two strings are permutations of each other");
		
		char[] charArray1 = x.toCharArray();
		Arrays.sort(charArray1);
		String sortedX = new String(charArray1);
		
		char[] charArray2 = y.toCharArray();
		Arrays.sort(charArray2);
		String sortedY = new String(charArray2);
		
		System.out.println("The sorted string is 1:" + sortedX + " 2: " + sortedY );
		
		if (sortedX.compareTo(sortedY) == 0) {
			System.out.println("They are a permutation of each other");
		} else {
			System.out.println("NOT a permutation of each other");
		}
		

	}

}
