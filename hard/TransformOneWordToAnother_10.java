package hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TransformOneWordToAnother_10 {

	public static void main(String[] args) {
		String startWord = "cat";
		String stopWord = "dog";
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("bat");
		dictionary.add("bet");
		dictionary.add("bot");
		dictionary.add("bog");
		dictionary.add("cot");
		dictionary.add("mob");
		dictionary.add("rob");
		dictionary.add("job");
		LinkedList<String> result = transform(startWord, stopWord, dictionary);
		for (String string : result) {
			System.out.println(string);
		}
	}

	private static LinkedList<String> transform(String startWord, String stopWord, Set<String> dictionary) {
		Queue<String> actionSet = new LinkedList<String>();
		Set<String> visitedSet = new HashSet<String>();
		Map<String, String> backtrapMap = new TreeMap<String, String>();

		actionSet.add(startWord);
		visitedSet.add(startWord);

		while (!actionSet.isEmpty()) {
			String word = actionSet.poll();
			Set<String> newDict = getAllOneChangeWords(word);
			for (String v : newDict) {
				if (v.equals(stopWord)) {
					LinkedList<String> result = new LinkedList<String>();
					result.add(v);
					while (word != null) {
						result.add(0, word);
						word = backtrapMap.get(word);
					}
					return result;
				}

				if (dictionary.contains(v)) {
					if (!visitedSet.contains(v)) {
						actionSet.add(v);
						visitedSet.add(v);
						backtrapMap.put(v, word);
					}
				}
			}
		}
		return null;
	}

	private static Set<String> getAllOneChangeWords(String word) {
		Set<String> listOfWords = new TreeSet<String>();
		for (int i = 0; i < word.length(); i++) {
			char[] wordArray = word.toCharArray();
			for (char j = 'a'; j <= 'z' ; j++) {
				if (j !=wordArray[i]) {
					wordArray[i] = j;
					listOfWords.add(new String(wordArray));
				}
			}
		}
		return listOfWords;
	}

}
