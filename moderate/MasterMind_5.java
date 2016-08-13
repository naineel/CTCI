package moderate;

public class MasterMind_5 {

	public static int MAX_COLORS = 4;
	public static void main(String[] args) {
		String solution = "RGBY";
		String guess = "GGRR";
		Result res = estimate(solution, guess);
		System.out.println(res);

	}
	
	private static Result estimate(String solution, String guess) {
		if (solution.length() != guess.length()) return null;
		int[] freq = new int[MAX_COLORS];
		Result res = new Result();
		
		//Compute hits
		for (int i = 0; i < solution.length(); i++) {
			if (solution.charAt(i) == guess.charAt(i)) {
				res.hit++;
			} else {
				int code = code(solution.charAt(i));
				freq[code]++;
			}
		}
		
		//Compute pseudoHits
		for (int i = 0; i < guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (code >= 0 && freq[code] > 0 && solution.charAt(i) != guess.charAt(i)) {
				res.pseudo++;
				freq[code]--;
			}
		}
		return res;
	}

	
	
	public static int code(char c) {
		switch(c) {
		case 'R':
			return 0;
		case 'G':
			return 1;
		case 'B':
			return 2;
		case 'Y':
			return 3;
		default:
			return -1;
		}
	}
	
	public static class Result {
		int hit;
		int pseudo;
		
		public Result() {
			hit = 0;
			pseudo = 0;
		}
		
		public String toString() {
			return "Hit: " + hit + " pseudo: " + pseudo;
		}
	}

}
