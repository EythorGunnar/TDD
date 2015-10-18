package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){



		if (text == ("")) {
			return 0;
		}

		else if (text.startsWith("//") || text.contains(",") || text.contains("\n")) {
			return total(text);
		}

		else {
			try {
				if (toInt(text) < 0) {
					throw new IllegalArgumentException();
				}
			} 
			catch (Exception e) {
				System.out.println("Negatives not allowed: " + text);
			}
			return toInt(text);
		}
	}

	private static int total(String input){
		String deliminator = ",|\\\n";

		if (input.startsWith("//")) {
			deliminator = input.substring(2, input.indexOf("\n"));
			input = input.substring(4);
		}

		String [] allTheNumbers = input.split(deliminator);

		checkForNegatives(allTheNumbers);

		int sum = 0;
		for (int x = 0; x < allTheNumbers.length; x++) {
			sum += toInt(allTheNumbers[x]);
		}
		return sum;
	}

	private static int toInt(String input){
		return Integer.parseInt(input);
	} 

	private static void checkForNegatives(String[] input) {
		String msg = "Negatives not allowed: ";
		boolean isNegative = false;
		for (int x = 0; x < input.length; x++) {
			if (toInt(input[x]) < 0) {
				if (isNegative) {
					msg = msg + ("," + input[x]);
				}
				else {
					isNegative = true;
					msg = msg + input[x];
				}
			}
		}
		if (isNegative) {
			throw new IllegalArgumentException(msg);
		}
		return;
	}
}