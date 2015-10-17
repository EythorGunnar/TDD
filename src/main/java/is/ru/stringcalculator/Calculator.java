package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if (text == ("")) {
			return 0;
		}
		else if (text.contains(",") || text.contains("\n")) {
			return total(text);
		}
		else; {
			try {
				return toInt(text);
			} 
			catch (Exception e) {
				return 0;
			}
		}
	}

	private static int total(String input){
		String [] allTheNumbers = input.split(",|\\\n");
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