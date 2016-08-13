package dynamicAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class Paranthesis {

	public static void main(String[] args) {
		List<String> result = generateParens(2);
		for (String string : result) {
			System.out.println(string);
		}
	}
	
	public static ArrayList<String> generateParens(int count) {
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		addParens(list, count, count, str, 0);
		return list;
	}

	private static void addParens(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
		if (leftRem < 0 || rightRem < leftRem) {
			return;
		}
		
		if (leftRem == 0 && rightRem == 0) {
			String x = String.copyValueOf(str);
			list.add(x);
		} else {
			if (leftRem > 0) {
				str[count] = '(';
				addParens(list, leftRem-1, rightRem, str, count+1);
			}
			
			if (rightRem > leftRem) {
				str[count] = ')';
				addParens(list, leftRem, rightRem-1, str, count+1);
			}
		}
		
	}

}
