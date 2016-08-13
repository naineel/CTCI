package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * This solution works for 18.8
 * @author naineel
 *
 */
public class LongestWord_7 {

	public static void main(String[] args) {
		String arr[] = new String[] {
			"testing", "Tester", "def", "n", "ew", "testingTesternnew", "new"	
		};
		String result = printLongestWord(arr);
//		System.out.println(result);

	}

	private static String printLongestWord(String[] arr) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (String string : arr) {
			map.put(string, true);
		}
		
		Arrays.sort(arr, new LengthComparator());
		for (String s: arr) {
			if (canBuildWord(s, true, map)) {
				System.out.println(s);
				return s;
			}
		}
		return "";
	}
	
	private static boolean canBuildWord(String str, boolean isOriginalWord, HashMap<String, Boolean> map) {
		if (map.containsKey(str) && !isOriginalWord) {
			return map.get(str);
		}
		for (int i = 1; i < str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i);
			if (map.containsKey(left) && map.get(left) == true && canBuildWord(right, false, map)) {
				return true;
			}
		}
		map.put(str, false);
		return false;
	}

	static class LengthComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o2.length() - o1.length();
		}
		
	}
	

}
