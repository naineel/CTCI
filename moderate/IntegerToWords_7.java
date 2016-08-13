package moderate;

public class IntegerToWords_7 {

	final static String[] ones = new String[] {
			"one", "two", "three", "four", "five", 
			"six", "seven", "eight", "nine", "ten"
	};
	
	final static String[] teens = new String[] {
			"eleven", "twelve", "thirteen", "fourteen",
			"fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen"
	};
	
	final static String[] tens = new String[] {
			"Ten", "Twenty", "Thirty", "Forty",
			"Fifty", "Sixty", "Seventy", "Eighty", 
			"Ninety"
	};
	
	final static String[] big = new String[] {
		"","thousand", "million"
	};
	
	public static void main(String[] args) {
		int number = 19323984;
		String result = convert(number);
		System.out.println(result);
	}

	private static String convert(int number) {
		if (number == 0) {
			return "zero";
		} else if (number < 0) {
			return "Negative" + convert(-1*number);
		}
		
		String words = " ";
		int count = 0;
		
		while (number > 0) {
			if (number % 1000 != 0) {
				words = numToString(number%1000) + big[count]+" " + words;
			}
			number = number/1000;
			count++;
		}
		return words;
	}

	private static String numToString(int num) {
		String words = "";
		//for 100's
		int number = num;
		if (num >= 100) {
			num = num/100;
			number = number % 100;
			words = words + ones[num-1] + " Hundred" + " ";
		}
		
		if (number >= 11 && number <= 19) {
			return words + teens[number - 11] + " ";
		} else if (number == 10 || number >= 20){
			words += tens[number/10 -1] + " ";
			number = number % 10;
		}
		
		
		if (number >= 1 && number <=9) {
			words += ones[number-1] + " ";
		}
		
		return words;
	}

}
