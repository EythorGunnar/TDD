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
				return toInt(text);
			} 
			catch (Exception e) {
				return 0;
			}
		}
	}

	private static int total(String input){
		String deliminator = ",|\\\n";
		
		if (input.startsWith("//")) {
			deliminator = input.substring(2, input.indexOf("\n"));
			input = input.substring(4);
		}

		String [] allTheNumbers = input.split(deliminator);
		int sum = 0;
		for (int x = 0; x < allTheNumbers.length; x++) {
			sum += toInt(allTheNumbers[x]);
		}
		return sum;
	}

	private static int toInt(String input){
		return Integer.parseInt(input);
	} 
}