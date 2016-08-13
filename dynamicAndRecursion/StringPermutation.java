package dynamicAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {
		String x = "abc";
		List<String> permutations = getPermutations(x);
		for (String string : permutations) {
			System.out.println(string);
		}
	}

	private static List<String> getPermutations(String str) {
		if (str == null) {
			return null;
		}
		List<String> permutations = new ArrayList<String>();
		if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0);
		String remainder = str.substring(1);
		//Recurse
		List<String> words = getPermutations(remainder);
		
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				String s = insertCharAt(word, first,i);
				permutations.add(s);
			}
		}
		return permutations;
		
	}

	private static String insertCharAt(String word, char first, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + first + end;
	}

}
