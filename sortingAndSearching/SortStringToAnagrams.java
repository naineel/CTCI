package sortingAndSearching;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class SortStringToAnagrams {

	public static void main(String[] args) {
		String[] array = new String[] {"abcd", "edr", "tuy", "dcba", "rde", "yut"};
		sortArray(array);

	}
	
	
	private static void sortArray(String[] array) {
		Hashtable<String, LinkedList<String>> hashtable = new Hashtable<String, LinkedList<String>>();
		
		for (int i = 0; i < array.length; i++) {
			char[] so = array[i].toCharArray();
			Arrays.sort(so);
			String a = String.copyValueOf(so);
			if (hashtable.containsKey(a)) {
				LinkedList<String> oldLL = hashtable.get(a);
				oldLL.add(array[i]);
			} else {
				LinkedList<String> n = new LinkedList<String>();
				hashtable.put(a, n);
			}
		}
		
		int index = 0;
		for (String s : hashtable.keySet()) {
			LinkedList<String> data = hashtable.get(s);
			for (int i=0; i < data.size(); i++) {
				array[index] = data.get(i);
				index++;
			}
		}
	}


	public boolean checkAnagram(String one, String two) {
		char[] one1 = one.toCharArray();
		Arrays.sort(one1);
		char[] two1 = two.toCharArray();
		Arrays.sort(two1);
		
		return one1.equals(two1);
	}

}
