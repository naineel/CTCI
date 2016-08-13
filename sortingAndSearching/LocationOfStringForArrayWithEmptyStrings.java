package sortingAndSearching;

public class LocationOfStringForArrayWithEmptyStrings {

	public static void main(String[] args) {
		String[] str = new String[] {"abc", "abcde", "", "ytr", " ", "zqwe"};
		System.out.println(findLocation(str, 0, str.length-1, "ytr"));
		

	}

	private static int findLocation(String[] str, int start, int end, String string) {
		if (start > end) return -1;
		int mid = (start + end) / 2;
		if (str[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (left < start && right > end) {
					return -1;
				} else if (right <= end && !str[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= start && !str[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
			
		}
		
		if (string.equals(str[mid])) {
			return mid;
		} else if (string.compareTo(str[mid]) < 0){
			return findLocation(str, mid+1, end, string);
		} else {
			return findLocation(str, start, mid-1, string);
		}
		
	}

}
