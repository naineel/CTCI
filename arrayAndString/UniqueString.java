package arrayAndString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string");
		String x = br.readLine();
		Boolean flag = false;
		for (int i = 1; i < x.length(); i++) {
			String one = x.substring(i-1, i);
			String two = x.substring(i);
			if (two.contains(one)) {
				System.out.println("Not Unique");
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println("unique");
		}
	}

}
